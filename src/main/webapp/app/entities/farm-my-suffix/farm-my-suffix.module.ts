import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MyAnguar5ApplicationSharedModule } from '../../shared';
import {
    FarmMySuffixService,
    FarmMySuffixPopupService,
    FarmMySuffixComponent,
    FarmMySuffixDetailComponent,
    FarmMySuffixDialogComponent,
    FarmMySuffixPopupComponent,
    FarmMySuffixDeletePopupComponent,
    FarmMySuffixDeleteDialogComponent,
    farmRoute,
    farmPopupRoute,
} from './';

const ENTITY_STATES = [
    ...farmRoute,
    ...farmPopupRoute,
];

@NgModule({
    imports: [
        MyAnguar5ApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        FarmMySuffixComponent,
        FarmMySuffixDetailComponent,
        FarmMySuffixDialogComponent,
        FarmMySuffixDeleteDialogComponent,
        FarmMySuffixPopupComponent,
        FarmMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        FarmMySuffixComponent,
        FarmMySuffixDialogComponent,
        FarmMySuffixPopupComponent,
        FarmMySuffixDeleteDialogComponent,
        FarmMySuffixDeletePopupComponent,
    ],
    providers: [
        FarmMySuffixService,
        FarmMySuffixPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MyAnguar5ApplicationFarmMySuffixModule {}
