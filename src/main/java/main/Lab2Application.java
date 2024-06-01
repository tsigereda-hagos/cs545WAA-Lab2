package main;

import main.entity.Post;
import main.entity.User;
import main.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Lab2Application implements CommandLineRunner {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Autowired
    private UserRepo userRepo;

    public static void main(String[] args) {
        SpringApplication.run(Lab2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save a User
        User user = new User();
        user.setName("John Doe");

        // Create and save Posts
        Post post1 = new Post();
        post1.setTitle("First Post");
        post1.setContent("This is the first post content");
        post1.setAuthor("John Doe");
        //post1.setUser(user);

        Post post2 = new Post();
        post2.setTitle("Second Post");
        post2.setContent("This is the second post content");
        post2.setAuthor("John Doe");
       // post2.setUser(user);

        // Set posts to the user
        user.setPosts(Arrays.asList(post1, post2));

        // Save user which will also save the posts due to CascadeType.ALL
        userRepo.save(user);
    }
}
