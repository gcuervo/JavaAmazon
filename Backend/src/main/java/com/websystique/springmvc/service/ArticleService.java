package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Article;

public interface ArticleService {
	
	Article findById(int id);

	Article findByIdUser(int idUser);

	void saveArticle(Article article);

	void updateArticle(Article article);

	void deleteArticleByIdUser(int id_user);

	List<Article> listAllArticles();

	Boolean isArticleIdUnique(Integer id);

}
