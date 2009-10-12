package org.yestech.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.yestech.user.dao.UserDao;

@Service("userService")
public class DefaultUserService implements UserService {
	
	@Resource 
	private UserDao userDao;
	
	/* (non-Javadoc)
	 * @see org.yestech.user.UserService#createUser(org.yestech.user.User)
	 */
	public void save(User u) {
		userDao.save(u);
	}
		
	/* (non-Javadoc)
	 * @see org.yestech.user.UserService#loadById(long)
	 */
	public User loadById(long id) {
		return userDao.loadById(id);
	}
	
	public List<User> search(String query) {
		return userDao.search(query);
	}

}
