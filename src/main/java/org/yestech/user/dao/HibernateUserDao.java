package org.yestech.user.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateOperations;
import org.springframework.stereotype.Repository;
import org.yestech.user.User;

@Repository("userDao") 
public class HibernateUserDao implements UserDao {
	
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

}
