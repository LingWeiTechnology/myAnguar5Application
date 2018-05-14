/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { MyAnguar5ApplicationTestModule } from '../../../test.module';
import { FarmMySuffixComponent } from '../../../../../../main/webapp/app/entities/farm-my-suffix/farm-my-suffix.component';
import { FarmMySuffixService } from '../../../../../../main/webapp/app/entities/farm-my-suffix/farm-my-suffix.service';
import { FarmMySuffix } from '../../../../../../main/webapp/app/entities/farm-my-suffix/farm-my-suffix.model';

describe('Component Tests', () => {

    describe('FarmMySuffix Management Component', () => {
        let comp: FarmMySuffixComponent;
        let fixture: ComponentFixture<FarmMySuffixComponent>;
        let service: FarmMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [MyAnguar5ApplicationTestModule],
                declarations: [FarmMySuffixComponent],
                providers: [
                    FarmMySuffixService
                ]
            })
            .overrideTemplate(FarmMySuffixComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(FarmMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FarmMySuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new FarmMySuffix(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.farms[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
