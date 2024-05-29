package main.controller;

import main.entity.Post;
import main.entity.dto.response.PostSimpleDto;
import main.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> findAll(){
        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostSimpleDto findById(@PathVariable("id") long id){
        return postService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostSimpleDto post){
        postService.save(post);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long postId, @RequestBody PostSimpleDto p){
        postService.update(postId, p);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        postService.delete(id);
    }

    @GetMapping("/author")
    public List<PostSimpleDto> findByAuthor(@RequestParam String author) {
        return postService.findByAuthor(author);
    }

    @GetMapping("/search")
    public List<PostSimpleDto> findByAuthorContaining(@RequestParam String text) {
        return postService.findByAuthorContaining(text);
    }
}
