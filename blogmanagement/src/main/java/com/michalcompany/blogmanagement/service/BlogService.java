package com.michalcompany.blogmanagement.service;

import com.michalcompany.blogmanagement.exceptions.ResourceNotFoundException;
import com.michalcompany.blogmanagement.model.Blog;
import com.michalcompany.blogmanagement.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> findAll() { return blogRepository.findAll();}

    public Blog findById(Long blogId) throws ResourceNotFoundException {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog not found on ::" + blogId));
        return blog;
    }

    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Long blogId, Blog blogDetails) throws ResourceNotFoundException{
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog not found on ::" + blogId));

        blog.setTitle(blogDetails.getTitle());
        blog.setBody(blogDetails.getBody());
        blog.setUpdatedBy(blogDetails.getUpdatedBy());
        blog.setUpdatedAt(new Date());
        final Blog updatedBlog = blogRepository.save(blog);
        return updatedBlog;
    }

    public Map<String, Boolean> deleteBlog(Long blogId) throws Exception{
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog not found on ::" + blogId));

        blogRepository.delete(blog);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
