package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.dto.User;
import project.repository.UserRepository;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", user.getName(), user.getAge());
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.queryForList("select * from USER", User.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }

	@SuppressWarnings("unchecked")
	@Override
	public User getByName(String name) {
		return  jdbcTemplate.queryForObject("select * from User where name = ?  limit 1",new Object[] { name }, new BeanPropertyRowMapper(User.class));
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public User getUserbyName(String name){
		return userRepository.findByName(name);
	}
	@Override
	public User getUserbyNameAndAge(String name, Integer age){
		return userRepository.findByNameAndAge(name, age);
	}
	@Override
	public User findUser(String name){
		return userRepository.findUser(name);
	}
}
