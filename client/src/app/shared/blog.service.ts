import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class BlogService {
  public API_BASE = "//localhost:8080/api/v1/blogs";

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.API_BASE);
  }
  
  get(id: string) {
    return this.http.get(this.API_BASE + '/' + id);
  }
  
  save(blog: any): Observable<any>{
    let result: Observable<Object>;
    if (blog['id']) {
      result = this.http.put(this.API_BASE + '/' + blog['id'], blog);
    } else {
      result = this.http.post(this.API_BASE, blog);
    }
    return result;
  }
}