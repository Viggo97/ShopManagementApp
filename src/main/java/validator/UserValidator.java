package validator;

import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;

public class UserValidator {

    private final int MIN_LOGIN_LENGTH = 4;
    private final int MIN_PASSWORD_LENGTH = 6;

    private static UserValidator instance = null;
    private UserDaoImpl userDao = UserDaoImpl.getInstance();

    private UserValidator () throws IOException {
    }

    public static UserValidator getInstance() throws IOException {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserLoginAlreadyExistException, UserShortLengthLoginException,
            UserShortLengthPasswordException {
        if(isLoginAlreadyExist(user.getLogin()))
            throw new UserLoginAlreadyExistException("User with this login already exists.");
        if(isLoginLengthEnough(user.getLogin()))
            throw new UserShortLengthLoginException("Login is too short.");
        if(isPasswordLengthEnough(user.getPassword()))
            throw new UserShortLengthPasswordException("Password is too short.");

        return true;
    }

    private boolean isLoginLengthEnough(String login) {
        return login.length() < MIN_LOGIN_LENGTH;
    }

    private boolean isPasswordLengthEnough(String password) {
        return password.length() < MIN_PASSWORD_LENGTH;
    }

    private boolean isLoginAlreadyExist(String login) {
        User user = null;
        try {
            user = userDao.gerUserByLogin(login);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user != null;
    }
}
