package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Article;

@Repository("articleDao")
public class ArticleDaoImpl extends AbstractDao<Integer, Article> implements ArticleDao {

	@Override
	public Article findById(int id) {
		return getByKey(id);
	}

	@Override
	public Article findByIdUser(int idUser) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id_user", idUser));
		return (Article) criteria.uniqueResult();
	}

	@Override
	public void saveArticle(Article article) {
		persist(article);
	}

	@Override
	public void deleteUserByIdUser(int idUser) {
		Query query = getSession().createSQLQuery("delete from Articles where id_user = :id_user");
//		query.setString("id_user", idUser);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Article> findAllArticles() {
		Criteria criteria = createEntityCriteria();
		return (List<Article>) criteria.list();
	}

	
}
