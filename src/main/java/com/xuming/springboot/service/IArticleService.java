package com.xuming.springboot.service;

import java.util.List;

import com.xuming.springboot.model.Article;

public interface IArticleService {
	
	List<Article> getAllArticles();
	
	Article getArticleById(long articleId);
	
	boolean addArticle(Article article);
	
	void updateArticle(Article article);
	
	void deleteArticle(long articleId);
    
	void deleteAll();
    
    Article findByTitle(String title);
    
    List<Article> getArticlesByCategory(String category);
	
}
