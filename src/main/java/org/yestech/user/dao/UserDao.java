package org.yestech.user.dao;

import java.util.List;

import org.yestech.user.User;

public interface UserDao {

	void save(User user);

	User loadById(long id);

	List<User> search(final String query);

}