package com.michalcompany.blogmanagement.controller;

import com.michalcompany.blogmanagement.exceptions.ResourceNotFoundException;
import com.michalcompany.blogmanagement.model.Blog;
import com.michalcompany.blogmanagement.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/blogs")
@CrossOrigin(origins = "http://localhost:4200")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public List<Blog> getAllBlogs() {
        return blogService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable(value = "id") Long blogId) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(blogService.findById(blogId));
    }

    @PostMapping("")
    public Blog createBlog(@Valid @RequestBody Blog blog){
        return blogService.saveBlog(blog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable(value = "id") Long blogId, @Valid @RequestBody Blog blogDetails) throws ResourceNotFoundException {
        return ResponseEntity.ok(blogService.updateBlog(blogId, blogDetails));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteBlog(@PathVariable(value = "id") Long blogId) throws Exception {
        return blogService.deleteBlog(blogId);
    }
}
