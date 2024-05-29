package main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    long id;
    String title;
    String content;
    String author;

}
