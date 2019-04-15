package com.xuming.springboot.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.xuming.springboot.model.Article;



public interface ArticleRepository extends CrudRepository<Article,Long> {
	
	List<Article> findByTitle(String title);
	List<Article> findDistinctByCategory(String category);
	List<Article> findByTitleAndCategory(String title,String category);

}
