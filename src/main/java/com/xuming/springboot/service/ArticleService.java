package com.xuming.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuming.springboot.model.Article;
import com.xuming.springboot.respository.ArticleRepository;

@Service
public class ArticleService implements IArticleService {
	
	@Autowired
	public ArticleRepository articleRepository;

	@Override
	public List<Article> getAllArticles() {
		List<Article> list = new ArrayList<>();
		articleRepository.findAll().forEach(e->list.add(e));
		return list;
	}

	@Override
	public Article getArticleById(long articleId) {
		
		Article obj = articleRepository.findById(articleId).get();
		return obj;
	}

	@Override
	public boolean addArticle(Article article) {
		List<Article> list = articleRepository.findByTitleAndCategory(article.getTitle(), article.getCategory());
		
		if(list.size()>0) {
			return false;
		}else {
			articleRepository.save(article);
			return true;
		}
		
	}

	@Override
	public void updateArticle(Article article) {
		articleRepository.save(article);
		
	}

	@Override
	public void deleteArticle(long articleId) {
		articleRepository.deleteById(articleId);
		
	}

	@Override
	public void deleteAll() {
		articleRepository.deleteAll();
		
	}

	@Override
	public Article findByTitle(String title) {
		Article article = (Article) articleRepository.findByTitle(title);
		return (Article) article;
		
	}

	@Override
	public List<Article> getArticlesByCategory(String category) {

		List<Article> article = articleRepository.findByCategory(category);
		
		return article;
		
	}

	@Override
	public List<Article> getArticlesByTitleAndCategory(String title, String category) {

		List<Article> articles = articleRepository.findByTitleAndCategory(title, category);
		
		return articles;
	}


}
