package dao;

import api.UserDao;
import entity.User;
import entity.parser.UserLParser;
import utils.FileUtils;

import java.io.*;
import java.util.*;

public class UserDaoImpl implements UserDao {

    private static final String fileName = "users.data";
    private static UserDaoImpl instance = null;

    private UserDaoImpl() {
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e) {
            System.err.println("Error with file path.");
            System.exit(-1);
        }
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
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
}
