package org.yestech.user.dao;

import org.yestech.user.User;

public interface UserDao {

	void save(User user);

	User loadById(long id);

}