import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { FarmMySuffix } from './farm-my-suffix.model';
import { FarmMySuffixService } from './farm-my-suffix.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-farm-my-suffix',
    templateUrl: './farm-my-suffix.component.html'
})
export class FarmMySuffixComponent implements OnInit, OnDestroy {
farms: FarmMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private farmService: FarmMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.farmService.query().subscribe(
            (res: HttpResponse<FarmMySuffix[]>) => {
                this.farms = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInFarms();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: FarmMySuffix) {
        return item.id;
    }
    registerChangeInFarms() {
        this.eventSubscriber = this.eventManager.subscribe('farmListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
