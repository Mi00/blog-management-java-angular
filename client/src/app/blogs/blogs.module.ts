import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BlogsRoutingModule } from './blogs-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';

import { BlogsComponent } from './blogs.component';
import { ListComponent } from './list/list.component';

@NgModule({
  declarations: [BlogsComponent, ListComponent],
  imports: [
    CommonModule,
    BlogsRoutingModule,
    MatCardModule,
    MatGridListModule
  ]
})
export class BlogsModule { }
