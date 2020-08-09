package entity.parser;

import entity.User;

public class UserLParser {
    public static User stringToUser(String userStr) {
        String[] userInformation = userStr.split(User.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(userInformation[0]);
        String login = userInformation[1];
        String password = userInformation[2];

        return new User(id, login, password);
    }
}