/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { MyAnguar5ApplicationTestModule } from '../../../test.module';
import { FarmMySuffixDetailComponent } from '../../../../../../main/webapp/app/entities/farm-my-suffix/farm-my-suffix-detail.component';
import { FarmMySuffixService } from '../../../../../../main/webapp/app/entities/farm-my-suffix/farm-my-suffix.service';
import { FarmMySuffix } from '../../../../../../main/webapp/app/entities/farm-my-suffix/farm-my-suffix.model';

describe('Component Tests', () => {

    describe('FarmMySuffix Management Detail Component', () => {
        let comp: FarmMySuffixDetailComponent;
        let fixture: ComponentFixture<FarmMySuffixDetailComponent>;
        let service: FarmMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [MyAnguar5ApplicationTestModule],
                declarations: [FarmMySuffixDetailComponent],
                providers: [
                    FarmMySuffixService
                ]
            })
            .overrideTemplate(FarmMySuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(FarmMySuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FarmMySuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new FarmMySuffix(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.farm).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
