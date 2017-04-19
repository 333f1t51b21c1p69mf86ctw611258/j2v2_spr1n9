import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AngularBlogSharedModule } from '../../shared';
import { AngularBlogAdminModule } from '../../admin/admin.module';
import {
    BlogService,
    BlogPopupService,
    BlogComponent,
    BlogDetailComponent,
    BlogDialogComponent,
    BlogPopupComponent,
    BlogDeletePopupComponent,
    BlogDeleteDialogComponent,
    blogRoute,
    blogPopupRoute,
} from './';

const ENTITY_STATES = [
    ...blogRoute,
    ...blogPopupRoute,
];

@NgModule({
    imports: [
        AngularBlogSharedModule,
        AngularBlogAdminModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        BlogComponent,
        BlogDetailComponent,
        BlogDialogComponent,
        BlogDeleteDialogComponent,
        BlogPopupComponent,
        BlogDeletePopupComponent,
    ],
    entryComponents: [
        BlogComponent,
        BlogDialogComponent,
        BlogPopupComponent,
        BlogDeleteDialogComponent,
        BlogDeletePopupComponent,
    ],
    providers: [
        BlogService,
        BlogPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AngularBlogBlogModule {}
