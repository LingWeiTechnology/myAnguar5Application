/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { MyAnguar5ApplicationTestModule } from '../../../test.module';
import { FarmMySuffixDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/farm-my-suffix/farm-my-suffix-delete-dialog.component';
import { FarmMySuffixService } from '../../../../../../main/webapp/app/entities/farm-my-suffix/farm-my-suffix.service';

describe('Component Tests', () => {

    describe('FarmMySuffix Management Delete Component', () => {
        let comp: FarmMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<FarmMySuffixDeleteDialogComponent>;
        let service: FarmMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [MyAnguar5ApplicationTestModule],
                declarations: [FarmMySuffixDeleteDialogComponent],
                providers: [
                    FarmMySuffixService
                ]
            })
            .overrideTemplate(FarmMySuffixDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(FarmMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FarmMySuffixService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
