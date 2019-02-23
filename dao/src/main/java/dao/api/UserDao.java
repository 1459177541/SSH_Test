package dao.api;


import entity.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>,
        LoginDao {

    User findById(String id);



}
