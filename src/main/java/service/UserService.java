package service;

import entity.user.User;

import java.util.Optional;

public interface UserService extends Service<User>{

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

    Optional<User> get(int id);
}
