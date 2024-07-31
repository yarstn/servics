package com.example.exerciseservice.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Article {
    @NotNull(message = "id cannot be empty")
    private int id;
    @NotEmpty(message = "title cannot be empty")
    @Size(min = 5, max = 100,message = "title max size 100")
    private String title;
    @NotEmpty(message = "author cannot be empty")
    @Size(min = 3,max = 20,message = "author max size 100")
    private String author;
    @NotEmpty(message = "content cannot be empty")
    @Size(min = 200,message = "content min size 200")
    private String content;
    @NotEmpty(message = "category cannot be empty")
    @Pattern(regexp = "^(politics|sports|technology)$", message = "Category must be either 'politics' or 'sports'or technology")
    private String category;
    @NotEmpty(message = "imageUrl cannot be empty")
    private String imageUrl;
    @AssertFalse
    private boolean isPublished;
    private LocalDate publishDate;

}
