import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BlogsRoutingModule } from './blogs-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule, MatButtonModule } from '@angular/material';
import { FormsModule, FormGroup, ReactiveFormsModule }   from '@angular/forms';

import { BlogsComponent } from './blogs.component';
import { ListComponent } from './list/list.component';
import { BlogFormComponent } from './blog-form/blog-form.component';

@NgModule({
  declarations: [BlogsComponent, ListComponent, BlogFormComponent],
  imports: [
    CommonModule,
    BlogsRoutingModule,
    MatCardModule,
    MatGridListModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class BlogsModule { }
