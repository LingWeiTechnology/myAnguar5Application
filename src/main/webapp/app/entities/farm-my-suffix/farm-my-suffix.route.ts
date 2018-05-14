import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { FarmMySuffixComponent } from './farm-my-suffix.component';
import { FarmMySuffixDetailComponent } from './farm-my-suffix-detail.component';
import { FarmMySuffixPopupComponent } from './farm-my-suffix-dialog.component';
import { FarmMySuffixDeletePopupComponent } from './farm-my-suffix-delete-dialog.component';

export const farmRoute: Routes = [
    {
        path: 'farm-my-suffix',
        component: FarmMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Farms'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'farm-my-suffix/:id',
        component: FarmMySuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Farms'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const farmPopupRoute: Routes = [
    {
        path: 'farm-my-suffix-new',
        component: FarmMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Farms'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'farm-my-suffix/:id/edit',
        component: FarmMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Farms'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'farm-my-suffix/:id/delete',
        component: FarmMySuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Farms'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
