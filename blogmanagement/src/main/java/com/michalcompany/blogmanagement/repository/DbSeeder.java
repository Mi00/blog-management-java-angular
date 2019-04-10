package com.michalcompany.blogmanagement.repository;

import com.michalcompany.blogmanagement.model.Blog;
import com.michalcompany.blogmanagement.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {
    private BlogService blogService;

    @Autowired
    public DbSeeder(BlogService blogService){
        this.blogService = blogService;
    }

    @Override
    public void run(String... strings) throws Exception{
        Blog blog = new Blog();
        blog.setTitle("Lorem ipsum dolor sit amet.");
        blog.setBody("<br class=\"Apple-interchange-newline\"><div id=\"bannerR\" style=\"margin: 0px -160px 0px 0px; padding: 0px; position: sticky; top: 20px; width: 160px; height: 10px; float: right; color: rgb(0, 0, 0); font-family: &quot;Open Sans&quot;, Arial, sans-serif; font-size: 14px;\"></div><div class=\"boxed\" style=\"margin: 10px 28.7969px; padding: 0px; clear: both; color: rgb(0, 0, 0); font-family: &quot;Open Sans&quot;, Arial, sans-serif; font-size: 14px; text-align: center;\"><div id=\"lipsum\" style=\"margin: 0px; padding: 0px; text-align: justify;\"><p style=\"margin-right: 0px; margin-bottom: 15px; margin-left: 0px; padding: 0px;\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris placerat tristique tincidunt. Integer porta nec nisl eu maximus. Etiam non ex mollis, gravida turpis et, interdum dui. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus id massa in massa vestibulum consequat. Vivamus rhoncus, diam et fermentum convallis, nisl massa elementum enim, a sodales arcu metus nec mi. Vestibulum vehicula ex eget fermentum luctus. Nam at nulla lacus. Sed mattis arcu eu hendrerit maximus. Quisque rhoncus tellus a velit varius, in scelerisque augue malesuada. Donec posuere ante mattis nibh bibendum mattis. Phasellus libero metus, convallis et libero ut, aliquet dictum tortor.</p><p style=\"margin-right: 0px; margin-bottom: 15px; margin-left: 0px; padding: 0px;\"><b>Sed nec ante vitae lorem facilisis imperdiet. Curabitur at nulla tincidunt, hendrerit neque a, mollis justo. Sed et pellentesque lorem. Suspendisse sit amet molestie neque. Integer dapibus dictum mauris vitae laoreet. Nulla ultrices ac massa sed faucibus. Mauris elit tortor, consectetur a nisl et, tempus maximus tellus. Aenean ac sollicitudin dolor, id semper ex. Proin commodo nulla ut urna iaculis, fringilla posuere leo efficitur. Aliquam facilisis dui blandit, pulvinar nisi cursus, cursus quam. Pellentesque luctus nunc sit amet neque efficitur blandit. Cras nunc massa, auctor ut ultrices eu, posuere quis lorem. Suspendisse fermentum magna vel elementum laoreet. Vestibulum mattis bibendum condimentum. Vivamus pulvinar congue mattis.</b></p><p style=\"margin-right: 0px; margin-bottom: 15px; margin-left: 0px; padding: 0px;\"><u>Suspendisse egestas fermentum purus non lacinia. Fusce a nibh libero. Nulla tristique tempor libero, sit amet sagittis lectus porta ut. Fusce tempus est luctus porta faucibus. Curabitur congue suscipit lorem, ut faucibus nisi pretium mollis. Phasellus feugiat rhoncus nisi sit amet sollicitudin. Etiam sit amet dictum quam. Vestibulum eu ipsum nec elit blandit eleifend eu ut nisl. Praesent eu ex a sem placerat faucibus eget vitae libero. Nulla suscipit dui odio. Aenean vestibulum eu eros ut faucibus. Nullam a consequat justo. Ut quis iaculis diam. Nam a ex nunc. Ut sollicitudin dui eu convallis pretium. Curabitur leo libero, lacinia sed luctus vitae, sodales a ligula.</u></p></div></div>");
        blog.setCreatedBy("Admin");
        blog.setUpdatedBy("Admin");

        blogService.saveBlog(blog);
    }
}