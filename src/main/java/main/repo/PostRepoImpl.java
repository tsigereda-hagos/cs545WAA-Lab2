package main.repo;

import main.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PostRepoImpl implements PostRepo{
    private static List<Post> posts;
    private static long postId = 10;
    static {
        posts = new ArrayList<>();
        Post p1 = new Post(123, "Lifestyle","cooking","Lisa John");
        Post p2 = new Post(456,"Professional", "Career Growth", "Tom Rose");
        posts.add(p1);
        posts.add(p2);
    }
    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post getById(long id) {
        return posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setId(postId);
        postId++;
        posts.add(post);

    }

    @Override
    public void delete(long id) {
        var post = posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
        posts.remove(post);

    }

    @Override
    public void update(long id, Post post) {
        Post toUpdate = getById(id);
        toUpdate.setTitle(post.getTitle());
        toUpdate.setAuthor(post.getAuthor());
        toUpdate.setContent(post.getContent());

    }

    @Override
    public List<Post> findByAuthor(String author) {
        List<Post> result = new ArrayList<>();
        for (Post post : posts) {
            if (post.getAuthor().equalsIgnoreCase(author)) {
                result.add(post);
            }
        }
        return result;
    }

    @Override
    public List<Post> findByAuthorContaining(String text) {
        List<Post> result = new ArrayList<>();
        for (Post post : posts) {
            if (post.getAuthor().toLowerCase().contains(text.toLowerCase())) {
                result.add(post);
            }
        }
        return result;
    }

}
