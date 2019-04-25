package com.xuming.springboot.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.xuming.springboot.model.Article;
import com.xuming.springboot.respository.ArticleRepository;
import com.xuming.springboot.service.ArticleService;
import com.xuming.springboot.service.IArticleService;

@Controller
@RequestMapping("user")
public class ArticleController {

	@Autowired
	public IArticleService iArticleService;
	public ArticleRepository articleRepository;
	
	@GetMapping("articles/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") long id) {
		
		Article article = iArticleService.getArticleById(id);
		return new ResponseEntity<Article>(article,HttpStatus.OK);
		
	}
	
	@GetMapping("articles")
	public @ResponseBody Iterable<Article> getAllArticles() {
		return iArticleService.getAllArticles();
	}
	
	@PostMapping("articles")
	public ResponseEntity<Article> addArticle(@RequestBody Article article){
		

		iArticleService.addArticle(article);
		return new ResponseEntity<Article>(article,HttpStatus.OK);
		

	}
	
	@PutMapping("articles")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article){
		iArticleService.updateArticle(article);
		return new ResponseEntity<Article>(article,HttpStatus.OK);
	}
	
	@DeleteMapping("articles/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id ){
		iArticleService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("articles")
	public ResponseEntity<Void> deleteAllArticles(){
		iArticleService.deleteAll();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("articles/titles")
   public @ResponseBody Article getArticleByArticleName(@RequestParam(required=true) String title){
	   
		Article article = iArticleService.findByTitle(title);
	   	
		return iArticleService.findByTitle(title);
	   
   }
	
	@GetMapping("articles/category")
	public @ResponseBody List<Article> getArticlesByCategory(@RequestParam(required=true)String category){
		List<Article> articles = iArticleService.getArticlesByCategory(category);
		return articles;
	}
}
