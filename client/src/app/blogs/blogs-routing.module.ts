import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BlogsComponent } from './blogs.component';
import { ListComponent } from './list/list.component';


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
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BlogsRoutingModule { }