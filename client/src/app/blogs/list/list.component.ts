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
    this.getBlogs();
  }
  
  getBlogs(){
    this.blogService.getAll().subscribe(data => {
      this.blogs = data;
    });
  }
  
  deleteBlog(id){
    this.blogService.delete(id).subscribe((data)=>{
         console.log("success");
         this.getBlogs();
    });
  }

}
