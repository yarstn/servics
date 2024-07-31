package com.example.exerciseservice.Service;

import com.example.exerciseservice.Controller.ArticleManagementSystemController;
import com.example.exerciseservice.Model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    ArrayList<Article> articleManagementSystems = new ArrayList<>();
    public ArrayList<Article> getArticleManagementSystems() {
        return articleManagementSystems;
    }
    public void addArticleManagementSystem(Article articleManagementSystem) {
        articleManagementSystems.add(articleManagementSystem);
    }
   public boolean updateArticleManagementSystem(int id, Article articleManagementSystem) {
      for (int i = 0; i < articleManagementSystems.size(); i++) {
          if (articleManagementSystems.get(i).getId() == id) {
              articleManagementSystems.set(i, articleManagementSystem);
              return true;
          }
      }
      return false;
   }
   public boolean deleteArticleManagementSystem(int id) {
        for (int i = 0; i < articleManagementSystems.size(); i++) {
            if (articleManagementSystems.get(i).getId() == id) {
                articleManagementSystems.remove(i);
                return true;
            }
        }
        return false;
   }
    public boolean isPublished(int id) {

              for(Article article : articleManagementSystems) {
                      if (article.getId() == id) {
                  article.setPublished(true);
                  return true;
              }
            }

        return false;
    }
    public ArrayList<Article> allArticlesPublished() {
        ArrayList<Article> articles = new ArrayList<>();
        for(Article article : articleManagementSystems) {
            if(article.isPublished()){
                articles.add(article);
            }
        }
        return articles;


    }
    public List<Article> getCategory(String category) {
        ArrayList<Article> articles = new ArrayList<>();
        for (Article article : allArticlesPublished()) {
            if (article.getCategory().equalsIgnoreCase(category)) {
                articles.add(article);
            }
        }
        return articles;
    }
   }
