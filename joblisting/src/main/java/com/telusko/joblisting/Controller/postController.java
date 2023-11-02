package com.telusko.joblisting.Controller;

import com.telusko.joblisting.PostRepository;
import com.telusko.joblisting.SearchRepository;
import com.telusko.joblisting.models.Post;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class postController {
    @Autowired
    PostRepository repo;
    @Autowired
    SearchRepository sepo;
    @ApiIgnore
    @RequestMapping(value = "/")
    public  void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-uri.html");
    }
    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPosts(){
        return  repo.findAll();

    }

    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text){
        return  sepo.findByText(text);

    }

    @PostMapping("/post")
    @CrossOrigin
    public Post addpost(@RequestBody Post post){
         return repo.save(post);
    }

}
