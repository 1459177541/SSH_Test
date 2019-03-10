package dao;

import entity.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findById(String id);

}
