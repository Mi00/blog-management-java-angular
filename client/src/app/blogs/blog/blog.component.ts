import { Component, OnInit } from '@angular/core';
import { BlogService } from '../../shared/blog.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {
  
  blog: any = {};
  
  sub: Subscription;

  constructor(private blogService: BlogService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      let id = params['id'];
      if(id){
        this.blogService.get(id).subscribe((blog: any) => {
          if(blog){
            this.blog = blog;
          } else {
            console.log(`Blog with id '${id}' not found`);
            this.gotoList();
          }
        })
      }
    })
  }
  
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
  
  gotoList() {
    this.router.navigate(['/blogs/list']);
  }

}
