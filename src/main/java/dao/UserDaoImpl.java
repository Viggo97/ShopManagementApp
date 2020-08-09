package dao;

import api.UserDao;
import entity.User;
import entity.parser.UserLParser;
import utils.FileUtils;

import java.io.*;
import java.util.*;

public class UserDaoImpl implements UserDao {

    private final String fileName;

    public UserDaoImpl(String fileName) throws IOException {
        this.fileName = fileName;
        FileUtils.createNewFile(fileName);
    }

    @Override
    public void saveUser(User user) throws IOException {
        List<User> users = getAllUser();
        users.add(user);
        saveUsers(users);
    }

    @Override
    public void saveUsers(List<User> users) throws IOException {
        FileUtils.createNewFile(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        for (User user : users) {
            writer.write(user.toString() + "\n");
        }
        writer.close();
    }

    @Override
    public void removeUserByLogin(String userLogin) throws IOException {
        List<User> users = getAllUser();
        users.removeIf(user -> user.getLogin().equals(userLogin));
        saveUsers(users);
    }

    @Override
    public void removeUserById(Long userId) throws IOException {
        List<User> users = getAllUser();
        users.removeIf(user -> user.getId().equals(userId));
        saveUsers(users);
    }

    @Override
    public List<User> getAllUser() throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String readLine = reader.readLine();

        while(readLine != null) {
            User user = UserLParser.stringToUser(readLine);
            users.add(user);
            readLine = reader.readLine();
        }
        reader.close();

        return users;
    }

    @Override
    public User gerUserByLogin(String userLogin) throws IOException {
        List<User> users = getAllUser();
        for (User user : users) {
            if (user.getLogin().equals(userLogin)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(Long userId) throws IOException {
        List<User> users = getAllUser();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
}
