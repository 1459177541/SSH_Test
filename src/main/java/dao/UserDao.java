package dao;

import entity.user.User;

public interface UserDao extends Dao<User>{

    User login(User user);

    default User login(int id, String password){
        return login(new User()
                .setId(id)
                .setPassword(password)
        );
    }

    boolean register(User user);

    default boolean register(int id, String password){
        return register(new User()
                .setId(id)
                .setPassword(password)
        );
    }

    User get(int id);

}
