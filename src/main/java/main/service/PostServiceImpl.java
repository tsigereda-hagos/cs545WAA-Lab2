package main.service;

import main.entity.Post;
import main.entity.dto.response.PostSimpleDto;
import main.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public PostSimpleDto findById(long id) {
        return modelMapper.map(postRepo.getById(id), PostSimpleDto.class);
    }

    @Override
    public void save(PostSimpleDto p) {
        postRepo.save(modelMapper.map(p,Post.class));
    }



}
