package service;

import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import validator.UserValidator;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance = null;
    private UserDaoImpl userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl() throws IOException {
    }

   public static UserServiceImpl getInstance() throws IOException {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
   }

    @Override
    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUser();
    }

    @Override
    public void addUser(User user) throws UserShortLengthPasswordException, UserLoginAlreadyExistException, UserShortLengthLoginException, IOException {
        if (userValidator.isValidate(user)) {
            userDao.saveUser(user);
        }
    }

    @Override
    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }
}
