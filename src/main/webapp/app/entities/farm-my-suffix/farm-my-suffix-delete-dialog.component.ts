import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { FarmMySuffix } from './farm-my-suffix.model';
import { FarmMySuffixPopupService } from './farm-my-suffix-popup.service';
import { FarmMySuffixService } from './farm-my-suffix.service';

@Component({
    selector: 'jhi-farm-my-suffix-delete-dialog',
    templateUrl: './farm-my-suffix-delete-dialog.component.html'
})
export class FarmMySuffixDeleteDialogComponent {

    farm: FarmMySuffix;

    constructor(
        private farmService: FarmMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.farmService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'farmListModification',
                content: 'Deleted an farm'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-farm-my-suffix-delete-popup',
    template: ''
})
export class FarmMySuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private farmPopupService: FarmMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.farmPopupService
                .open(FarmMySuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
