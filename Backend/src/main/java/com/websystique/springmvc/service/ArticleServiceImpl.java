package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ArticleDao;
import com.websystique.springmvc.model.Article;

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao dao;

	public Article findById(int id) {
		return dao.findById(id);
	}

	public Article findByIdUser(int idUser) {
		return dao.findByIdUser(idUser);
	}

	public void saveArticle(Article article) {
		dao.saveArticle(article);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	public void updateArticle(Article article) {
		Article entity = dao.findById(article.getId());
		if (entity != null) {
			entity.setName(article.getName());
			entity.setCreationDate(article.getCreationDate());
			entity.setId_user(article.getId_user());
			entity.setDescription(article.getDescription());
			entity.setState(article.getState());
			entity.setPrivacy(article.getPrivacy());

		}
	}

	public void deleteArticleByIdUser(int id_user) {
		dao.deleteUserByIdUser(id_user);
	}

	public List<Article> listAllArticles() {
		return dao.findAllArticles();
	}

	public Boolean isArticleIdUnique(Integer id) {
		Article article = findById(id);
		return (article == null || ((id != null) && (article.getId() == id)));
	}

}

