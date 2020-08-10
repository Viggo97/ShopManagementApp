package validator;

import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.io.IOException;

public class UserValidator {

    private final int MIN_LOGIN_LENGTH = 4;
    private final int MIN_PASSWORD_LENGTH = 6;

    private static UserValidator instance = null;

    private UserValidator () throws IOException {
    }

    public static UserValidator getInstance() throws IOException {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserShortLengthLoginException, UserShortLengthPasswordException {

        if (isLoginLengthEnough(user.getLogin()))
            throw new UserShortLengthLoginException("Login is too short.");
        if (isPasswordLengthEnough(user.getPassword()))
            throw new UserShortLengthPasswordException("Password is too short.");

        return true;
    }

    private boolean isLoginLengthEnough(String login) {
        return login.length() < MIN_LOGIN_LENGTH;
    }

    private boolean isPasswordLengthEnough(String password) {
        return password.length() < MIN_PASSWORD_LENGTH;
    }


}
