import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BlogsComponent } from './blogs.component';
import { ListComponent } from './list/list.component';
import { BlogFormComponent } from './blog-form/blog-form.component';
import { BlogComponent } from './blog/blog.component';


const routes: Routes = [
  {
    path: 'blogs',
    component: BlogsComponent,
    children: [
      {
        path: '',
        component: ListComponent
      },
      {
        path: 'list',
        component: ListComponent
      },
      {
        path: 'new',
        component: BlogFormComponent
      },
      {
        path: 'edit/:id',
        component: BlogFormComponent
      },
      {
        path: ':id',
        component: BlogComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BlogsRoutingModule { }