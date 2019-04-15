package com.xuming.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.xuming.springboot.model.Article;
import com.xuming.springboot.service.IArticleService;

@Controller
@RequestMapping("user")
public class ArticleController {

	@Autowired
	public IArticleService iArticleService;
	
	@GetMapping("article/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id) {
		
		Article article = iArticleService.getArticleById(id);
		return new ResponseEntity<Article>(article,HttpStatus.OK);
		
	}
	
	@GetMapping("articles")
	public @ResponseBody Iterable<Article> getAllArticles() {
		return iArticleService.getAllArticles();
	}
	
//	@PostMapping("articles")
//	public @ResponseBody String addArticle(@RequestParam String title,@RequestParam String category){
//		
//		Article article = new Article();
//		
//		article.setTitle(title);
//		article.setCategory(category);
//		
//		
//
//	}
}
