package main.service;

import main.entity.Post;
import main.entity.dto.response.PostSimpleDto;

import java.util.List;

public interface PostService {
     List<Post> findAll();
     PostSimpleDto findById(long id);
    void save(PostSimpleDto p);


}
