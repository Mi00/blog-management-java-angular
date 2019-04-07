import { Component, OnInit } from '@angular/core';
import { BlogService } from '../../shared/blog.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  blogs: Array<any>;

  constructor(private blogService: BlogService) { }

  ngOnInit() {
    this.blogService.getAll().subscribe(data => {
      this.blogs = data;
      console.log(data)
    });
  }

}
