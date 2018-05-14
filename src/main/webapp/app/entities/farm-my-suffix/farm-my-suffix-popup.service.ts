import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { FarmMySuffix } from './farm-my-suffix.model';
import { FarmMySuffixService } from './farm-my-suffix.service';

@Injectable()
export class FarmMySuffixPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private datePipe: DatePipe,
        private modalService: NgbModal,
        private router: Router,
        private farmService: FarmMySuffixService

    ) {
        this.ngbModalRef = null;
    }

    open(component: Component, id?: number | any): Promise<NgbModalRef> {
        return new Promise<NgbModalRef>((resolve, reject) => {
            const isOpen = this.ngbModalRef !== null;
            if (isOpen) {
                resolve(this.ngbModalRef);
            }

            if (id) {
                this.farmService.find(id)
                    .subscribe((farmResponse: HttpResponse<FarmMySuffix>) => {
                        const farm: FarmMySuffix = farmResponse.body;
                        farm.createDate = this.datePipe
                            .transform(farm.createDate, 'yyyy-MM-ddTHH:mm:ss');
                        this.ngbModalRef = this.farmModalRef(component, farm);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.farmModalRef(component, new FarmMySuffix());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    farmModalRef(component: Component, farm: FarmMySuffix): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.farm = farm;
        modalRef.result.then((result) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        }, (reason) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        });
        return modalRef;
    }
}
