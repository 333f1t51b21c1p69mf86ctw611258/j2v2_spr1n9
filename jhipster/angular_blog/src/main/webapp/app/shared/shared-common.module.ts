import { NgModule, Sanitizer } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { AlertService } from 'ng-jhipster';
import {
    AngularBlogSharedLibsModule,
    JhiAlertComponent,
    JhiAlertErrorComponent
} from './';

export function alertServiceProvider(sanitizer: Sanitizer) {
    // set below to true to make alerts look like toast
    const isToast = false;
    return new AlertService(sanitizer, isToast);
}

@NgModule({
    imports: [
        AngularBlogSharedLibsModule
    ],
    declarations: [
        JhiAlertComponent,
        JhiAlertErrorComponent
    ],
    providers: [
        {
            provide: AlertService,
            useFactory: alertServiceProvider,
            deps: [Sanitizer]
        },
        Title
    ],
    exports: [
        AngularBlogSharedLibsModule,
        JhiAlertComponent,
        JhiAlertErrorComponent
    ]
})
export class AngularBlogSharedCommonModule {}
