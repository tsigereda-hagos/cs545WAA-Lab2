package main.repo;

import main.entity.Post;

import java.util.List;

public interface PostRepo {
    public List<Post> findAll();
    public Post getById(long id);
    public void save(Post post);
    public void delete(long id);
    public void update(long id, Post post);
    List<Post> findByAuthor(String author);
    List<Post> findByAuthorContaining(String text);
}
