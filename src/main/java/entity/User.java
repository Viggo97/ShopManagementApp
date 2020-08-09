package entity;

public class User {
    public static final String PRODUCT_SEPARATOR = "#";
    private Long id;
    private String login;
    private String password;

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return  id + PRODUCT_SEPARATOR + login + PRODUCT_SEPARATOR + password;
    }
}