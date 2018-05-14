import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MyAnguar5ApplicationSharedModule } from '../../shared';
import {
    CountryMySuffixService,
    CountryMySuffixPopupService,
    CountryMySuffixComponent,
    CountryMySuffixDetailComponent,
    CountryMySuffixDialogComponent,
    CountryMySuffixPopupComponent,
    CountryMySuffixDeletePopupComponent,
    CountryMySuffixDeleteDialogComponent,
    countryRoute,
    countryPopupRoute,
} from './';

const ENTITY_STATES = [
    ...countryRoute,
    ...countryPopupRoute,
];

@NgModule({
    imports: [
        MyAnguar5ApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        CountryMySuffixComponent,
        CountryMySuffixDetailComponent,
        CountryMySuffixDialogComponent,
        CountryMySuffixDeleteDialogComponent,
        CountryMySuffixPopupComponent,
        CountryMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        CountryMySuffixComponent,
        CountryMySuffixDialogComponent,
        CountryMySuffixPopupComponent,
        CountryMySuffixDeleteDialogComponent,
        CountryMySuffixDeletePopupComponent,
    ],
    providers: [
        CountryMySuffixService,
        CountryMySuffixPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MyAnguar5ApplicationCountryMySuffixModule {}
