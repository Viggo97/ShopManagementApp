package api;

import entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao {

    void saveUser(User user) throws IOException;
    void saveUsers(List<User> users) throws IOException;

    void removeUserByLogin(String userLogin) throws IOException;
    void removeUserById(Long userId) throws IOException;

    List<User> getAllUser() throws IOException;
    User gerUserByLogin(String userLogin) throws IOException;
    User getUserById(Long userId) throws IOException;
}
