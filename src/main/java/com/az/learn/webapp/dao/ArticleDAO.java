package com.az.learn.webapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.az.learn.webapp.entity.Article;

@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Article> getAllArticles() {
		Criteria criteria = getSession().createCriteria(Article.class);
		return criteria.list();
	}

	@Override
	public Article getArticleById(int articleId) {
		Criteria criteria = getSession().createCriteria(Article.class);
		criteria.add(Restrictions.eq("articleId", articleId));
		return (Article) criteria.uniqueResult();
	}

	@Override
	public void addArticle(Article article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArticle(int articleId) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean articleExists(String title, String category) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @PersistenceContext private EntityManager entityManager;
	 * 
	 * @Override public Article getArticleById(int articleId) { return
	 * entityManager.find(Article.class, articleId); }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<Article> getAllArticles() { String hql =
	 * "FROM Article as atcl ORDER BY atcl.articleId"; return (List<Article>)
	 * entityManager.createQuery(hql).getResultList(); }
	 * 
	 * @Override public void addArticle(Article article) {
	 * entityManager.persist(article); }
	 * 
	 * @Override public void updateArticle(Article article) { Article artcl =
	 * getArticleById(article.getArticleId()); artcl.setTitle(article.getTitle());
	 * artcl.setCategory(article.getCategory()); entityManager.flush(); }
	 * 
	 * @Override public void deleteArticle(int articleId) {
	 * entityManager.remove(getArticleById(articleId)); }
	 * 
	 * @Override public boolean articleExists(String title, String category) {
	 * String hql =
	 * "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?"; int count
	 * = entityManager.createQuery(hql).setParameter(1, title) .setParameter(2,
	 * category).getResultList().size(); return count > 0 ? true : false; }
	 */
}
