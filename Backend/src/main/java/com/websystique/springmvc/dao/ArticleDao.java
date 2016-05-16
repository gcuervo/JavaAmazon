package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Article;

public interface ArticleDao {


	Article findById(int id);

	Article findByIdUser(int idUser);

	void saveArticle(Article article);

	void deleteUserByIdUser(int id_user); // o por ID??
	
	List<Article> findAllArticles();

}
