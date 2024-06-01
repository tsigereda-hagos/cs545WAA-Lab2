package main.service;

import main.entity.Post;
import main.entity.User;
import main.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    public List<User> findAll(){
        return userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("User not found with id: " + id));
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<Post> findPostsByUserId(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));
        return user.getPosts();
    }

    @Override
    public List<User> findUsersWithMoreThanOnePost() {
        return userRepo.findUsersWithMoreThanOnePost();
    }

}