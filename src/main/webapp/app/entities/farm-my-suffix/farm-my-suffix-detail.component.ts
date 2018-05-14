import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { FarmMySuffix } from './farm-my-suffix.model';
import { FarmMySuffixService } from './farm-my-suffix.service';

@Component({
    selector: 'jhi-farm-my-suffix-detail',
    templateUrl: './farm-my-suffix-detail.component.html'
})
export class FarmMySuffixDetailComponent implements OnInit, OnDestroy {

    farm: FarmMySuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private farmService: FarmMySuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInFarms();
    }

    load(id) {
        this.farmService.find(id)
            .subscribe((farmResponse: HttpResponse<FarmMySuffix>) => {
                this.farm = farmResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInFarms() {
        this.eventSubscriber = this.eventManager.subscribe(
            'farmListModification',
            (response) => this.load(this.farm.id)
        );
    }
}
