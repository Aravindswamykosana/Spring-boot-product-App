package aravind.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import aravind.dto.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(User user) {
		String insert = "Insert into user(iduser,name,age) values(?,?,?)";
		jdbcTemplate.update(insert, user.getIduser(), user.getName(), user.getAge());
	}

}
