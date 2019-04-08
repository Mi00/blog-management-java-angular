package com.michalcompany.blogmanagement.controller;

import com.michalcompany.blogmanagement.exceptions.ResourceNotFoundException;
import com.michalcompany.blogmanagement.model.Blog;
import com.michalcompany.blogmanagement.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/blogs")
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable(value = "id") Long blogId) throws ResourceNotFoundException {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog not found on ::" + blogId));
        return ResponseEntity.ok().body(blog);
    }

    @PostMapping("/blogs")
    public Blog createBlog(@Valid @RequestBody Blog blog){
        return blogRepository.save(blog);
    }

    @PutMapping("/blogs/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable(value = "id") Long blogId, @Valid @RequestBody Blog blogDetails) throws ResourceNotFoundException {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog not found on ::" + blogId));

        blog.setTitle(blogDetails.getTitle());
        blog.setBody(blogDetails.getBody());
        blog.setUpdatedAt(new Date());
        final Blog updatedBlog = blogRepository.save(blog);
        return ResponseEntity.ok(updatedBlog);
    }

    @DeleteMapping("/blogs/{id}")
    public Map<String, Boolean> deleteBlog(@PathVariable(value = "id") Long blogId) throws Exception {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog not found on ::" + blogId));

        blogRepository.delete(blog);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
