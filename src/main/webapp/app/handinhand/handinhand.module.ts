import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CommonModule } from '@angular/common';


//your route and component
import { HANDINHAND_ROUTE } from './handinhand-routing.module';
import { TestListComponent } from './test-list/test-list.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild([ HANDINHAND_ROUTE ])
  ],
  declarations: [TestListComponent]
})
export class HandinhandModule { }
