import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { FarmMySuffix } from './farm-my-suffix.model';
import { FarmMySuffixPopupService } from './farm-my-suffix-popup.service';
import { FarmMySuffixService } from './farm-my-suffix.service';

@Component({
    selector: 'jhi-farm-my-suffix-dialog',
    templateUrl: './farm-my-suffix-dialog.component.html'
})
export class FarmMySuffixDialogComponent implements OnInit {

    farm: FarmMySuffix;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private farmService: FarmMySuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.farm.id !== undefined) {
            this.subscribeToSaveResponse(
                this.farmService.update(this.farm));
        } else {
            this.subscribeToSaveResponse(
                this.farmService.create(this.farm));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<FarmMySuffix>>) {
        result.subscribe((res: HttpResponse<FarmMySuffix>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: FarmMySuffix) {
        this.eventManager.broadcast({ name: 'farmListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-farm-my-suffix-popup',
    template: ''
})
export class FarmMySuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private farmPopupService: FarmMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.farmPopupService
                    .open(FarmMySuffixDialogComponent as Component, params['id']);
            } else {
                this.farmPopupService
                    .open(FarmMySuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
