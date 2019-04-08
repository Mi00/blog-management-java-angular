package com.michalcompany.blogmanagement.repository;

import com.michalcompany.blogmanagement.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
