package org.yestech.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("userService")
public class DefaultUserService implements UserService {
	
	@Resource 
	
	
	/* (non-Javadoc)
	 * @see org.yestech.user.UserService#createUser(org.yestech.user.User)
	 */
	public User save(User u) {
		throw new UnsupportedOperationException("not yet implemented");
	}
		
	/* (non-Javadoc)
	 * @see org.yestech.user.UserService#loadById(long)
	 */
	public User loadById(long id) {
		throw new UnsupportedOperationException("not yet implemented");
	}
	
	/* (non-Javadoc)
	 * @see org.yestech.user.UserService#loadByName(java.lang.String)
	 */
	public User loadByName(String name) {
		throw new UnsupportedOperationException("not yet implemented");
	}

}
