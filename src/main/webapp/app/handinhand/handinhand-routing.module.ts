// import { NgModule } from '@angular/core';
// import { Routes, RouterModule } from '@angular/router';

// import { TestListComponent } from './test-list/test-list.component';


// const routes: Routes = [];

// // @NgModule({
// //   imports: [RouterModule.forChild(routes)],
// //   exports: [RouterModule]
// // })
// // export class HandinhandRoutingModule { }

// export const HandinhandRoutingModule: Routes = [
//   {
//       path: 'test-list',
//       component: TestListComponent,
    
//   }
// ];


import { Route } from '@angular/router';
import { TestListComponent } from './test-list/test-list.component';


export const HANDINHAND_ROUTE: Route = {
  path: 'test-list',
  component: TestListComponent,
    data: {
        authorities: [],
        pageTitle: 'Welcome, handinhand'
    }
};
