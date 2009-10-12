package org.yestech.user.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateOperations;
import org.springframework.stereotype.Repository;
import org.yestech.user.User;

@Repository("userDao") 
public class HibernateUserDao implements UserDao {
	
	private static final Logger logger = LoggerFactory.getLogger(HibernateUserDao.class);
	
	@Resource 
	private HibernateOperations template;
	
	/* (non-Javadoc)
	 * @see org.yestech.user.dao.UserDao#save(org.yestech.user.User)
	 */
	public void save(User user) {
		template.save(user);
	}
	
	/* (non-Javadoc)
	 * @see org.yestech.user.dao.UserDao#loadById(long)
	 */
	public User loadById(long id) {
		return (User) template.load(User.class, id); 
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> search(final String query) {
		return template.executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				
				FullTextSession session = Search.getFullTextSession(s);
				MultiFieldQueryParser parser = new MultiFieldQueryParser(new String[] {"firstname", "lastname"}, new StandardAnalyzer());
				try {
					Query q = parser.parse(query);
					FullTextQuery fullTextQuery = session.createFullTextQuery(q, User.class);
					return fullTextQuery.list();
					
				} catch (ParseException e) {
					logger.error(e.getMessage(), e);
					throw new HibernateException(e);
				}
			}
		});
	}

}
