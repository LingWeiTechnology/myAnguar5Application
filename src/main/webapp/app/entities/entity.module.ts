import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { MyAnguar5ApplicationFarmMySuffixModule } from './farm-my-suffix/farm-my-suffix.module';
import { MyAnguar5ApplicationRegionMySuffixModule } from './region-my-suffix/region-my-suffix.module';
import { MyAnguar5ApplicationCountryMySuffixModule } from './country-my-suffix/country-my-suffix.module';
import { MyAnguar5ApplicationLocationMySuffixModule } from './location-my-suffix/location-my-suffix.module';
import { MyAnguar5ApplicationDepartmentMySuffixModule } from './department-my-suffix/department-my-suffix.module';
import { MyAnguar5ApplicationTaskMySuffixModule } from './task-my-suffix/task-my-suffix.module';
import { MyAnguar5ApplicationEmployeeMySuffixModule } from './employee-my-suffix/employee-my-suffix.module';
import { MyAnguar5ApplicationJobMySuffixModule } from './job-my-suffix/job-my-suffix.module';
import { MyAnguar5ApplicationJobHistoryMySuffixModule } from './job-history-my-suffix/job-history-my-suffix.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        MyAnguar5ApplicationFarmMySuffixModule,
        MyAnguar5ApplicationRegionMySuffixModule,
        MyAnguar5ApplicationCountryMySuffixModule,
        MyAnguar5ApplicationLocationMySuffixModule,
        MyAnguar5ApplicationDepartmentMySuffixModule,
        MyAnguar5ApplicationTaskMySuffixModule,
        MyAnguar5ApplicationEmployeeMySuffixModule,
        MyAnguar5ApplicationJobMySuffixModule,
        MyAnguar5ApplicationJobHistoryMySuffixModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MyAnguar5ApplicationEntityModule {}
