import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BlogService } from '../../shared/blog.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-blog-form',
  templateUrl: './blog-form.component.html',
  styleUrls: ['./blog-form.component.css']
})
export class BlogFormComponent implements OnInit {
  
  blog: any = {};
  
  sub: Subscription;
  
  editorConfig = {
    "editable": true,
    "spellcheck": true,
    "height": "auto",
    "minHeight": "600px",
    "width": "auto",
    "minWidth": "1000px",
    "enableToolbar": true,
    "showToolbar": true,
    "placeholder": "Wprowadź tekst",
    "toolbar": [
        ["bold", "underline"]
    ]
  };

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
  
  onSubmit(){
    if(!this.blog.id){
      this.blog.updatedBy = this.blog.createdBy;
    }
    this.blogService.save(this.blog).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

}
