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

    @Override
    public void delete(long id) {
        postRepo.delete(id);

    }

    @Override
    public void update(long id, PostSimpleDto p) {
        postRepo.update(id, modelMapper.map(p,Post.class));

    }

    @Override
    public List<PostSimpleDto> findByAuthor(String author) {
        return postRepo.findByAuthor(author).stream()
                .map(post -> modelMapper.map(post, PostSimpleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostSimpleDto> findByAuthorContaining(String text) {
        return postRepo.findByAuthorContaining(text).stream()
                .map(post -> modelMapper.map(post, PostSimpleDto.class))
                .collect(Collectors.toList());
    }

}
