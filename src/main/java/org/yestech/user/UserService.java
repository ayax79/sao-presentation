package org.yestech.user;

import java.util.List;

public interface UserService {

	void save(User u);

	User loadById(long id);
	
	List<User> search(String query);

}