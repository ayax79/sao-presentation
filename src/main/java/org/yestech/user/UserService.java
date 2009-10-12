package org.yestech.user;

public interface UserService {

	User save(User u);

	User loadById(long id);

	User loadByName(String name);

}