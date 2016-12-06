package project.service;

import java.util.List;

import project.dto.User;

public interface UserService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(User user);

    /**
     * 根据name删除一个用户
     * @param name
     */
    void deleteByName(String name);
    
    /**
     * 根据name获取一个用户
     * @param name
     */
    User getByName(String name);

    /**
     * 获取用户总量
     */
    List<User> getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

	void update(User user);

	/**
	 * 使用jpa查找用户
	 * @param name
	 * @return
	 */
	User getUserbyName(String name);

	/**
	 * 使用jpa查找用户
	 * @param name
	 * @param age
	 * @return
	 */
	User getUserbyNameAndAge(String name, Integer age);

	/**
	 * 使用jpa查找用户
	 * @param name
	 * @return
	 */
	User findUser(String name);


}
