package main.service;

import main.entity.Post;
import main.entity.dto.response.PostSimpleDto;

import java.util.List;

public interface PostService {
    public List<Post> findAll();
    public PostSimpleDto findById(long id);
    public void save(PostSimpleDto p);


}
