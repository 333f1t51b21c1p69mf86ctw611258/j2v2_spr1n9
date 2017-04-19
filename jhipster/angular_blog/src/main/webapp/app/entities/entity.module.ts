import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AngularBlogBlogModule } from './blog/blog.module';
import { AngularBlogEntryModule } from './entry/entry.module';
import { AngularBlogTagModule } from './tag/tag.module';
import { AngularBlogAuthorModule } from './author/author.module';
import { AngularBlogBookModule } from './book/book.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        AngularBlogBlogModule,
        AngularBlogEntryModule,
        AngularBlogTagModule,
        AngularBlogAuthorModule,
        AngularBlogBookModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AngularBlogEntityModule {}
