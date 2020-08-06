package service;

import entity.User;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {
    @Test
    public void testGetAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(33L, "admin", "admin"));
        users.add(new User(65L, "record", "1234"));

        UserServiceImpl userService = new UserServiceImpl(users);
        List<User> usersFromTestClass = userService.getAllUsers();

        Assert.assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testAddUser() {
        List<User> users = new ArrayList<>();
        User user = new User(33L, "admin", "admin");
        users.add(user);

        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);
        List<User> usersFromTestClass = userService.getAllUsers();

        Assert.assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testRemoveUser() {
        List<User> users = new ArrayList<>();
        User admin = new User(33L, "admin", "admin");
        User record = new User(65L, "record", "1234");
        users.add(admin);
        users.add(record);

        UserServiceImpl userService = new UserServiceImpl(users);
        userService.removeUserById(33L);
        users.remove(admin);
        List<User> usersFromTestClass = userService.getAllUsers();

        Assert.assertEquals(users, usersFromTestClass);
    }
}
