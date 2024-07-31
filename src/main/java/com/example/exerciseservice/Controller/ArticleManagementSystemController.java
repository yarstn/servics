package com.example.exerciseservice.Controller;

import com.example.exerciseservice.ApiResponse;
import com.example.exerciseservice.Model.Article;
import com.example.exerciseservice.Service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/article")
public class ArticleManagementSystemController {
    private final ArticleService articleService;
@GetMapping("/get")
    public ResponseEntity getAllArticles() {
        ArrayList<Article> articleManagementSystems = articleService.getArticleManagementSystems();
        return ResponseEntity.status(200).body(articleManagementSystems);
    }
@PostMapping("/add")
    public ResponseEntity addArticle(@Valid @RequestBody Article articleManagementSystem, Errors errors) {
    if (errors.hasErrors()) {
String errorMessage = errors.getAllErrors().get(0).getDefaultMessage();
    return ResponseEntity.status(400).body(errorMessage);
    }
    articleService.addArticleManagementSystem(articleManagementSystem);
    return ResponseEntity.status(201).body(new ApiResponse( "Article added successfully"));
    }
@PutMapping("/update/{id}")
    public ResponseEntity updateArticle(@PathVariable int id, @Valid @RequestBody Article articleManagementSystem, Errors errors) {
    if (errors.hasErrors()) {
        String errorMessage = errors.getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.status(400).body(errorMessage);
    }
    boolean isUpdated = articleService.updateArticleManagementSystem(id,articleManagementSystem);
if (isUpdated) {
    return ResponseEntity.status(201).body(new ApiResponse( "Article updated successfully"));
}
return ResponseEntity.status(404).body(new ApiResponse( "Article not found"));
}


@DeleteMapping("/delete/{id}")
public ResponseEntity deleteArticle(@PathVariable int id) {
    boolean isDeleted = articleService.deleteArticleManagementSystem(id);
    if (isDeleted) {
        return ResponseEntity.status(201).body(new ApiResponse( "Article deleted successfully"));
    }
    return ResponseEntity.status(404).body(new ApiResponse( "Article not found"));

}
@PutMapping("/isPublish/{id}")
    public ResponseEntity isPublishArticle(@PathVariable int id) {
    boolean isPublished = articleService.isPublished(id);
    if (isPublished) {
        return ResponseEntity.status(201).body(new ApiResponse( "Article published successfully"));
    }
    return ResponseEntity.status(404).body(new ApiResponse( "Article not published"));
}
@GetMapping("all-articles")
    public ResponseEntity allArticles() {
    return ResponseEntity.status(200).body(articleService.getArticleManagementSystems());

}
    @GetMapping("/category/{category}")
    public ResponseEntity getArticlesByCategory(@PathVariable String category) {
        List<Article> articles = articleService.getCategory(category);
        if (articles.isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("No articles found for the given category"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("Articles found", articles));
    }
}
