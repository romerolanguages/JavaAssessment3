package user_management;

import user_management.security.Password;

public class User {

    protected String email;
    protected String id;
    protected String name;
    protected String passwordAsString;
    protected Password passwordAsPassword;

    public User() {
    }

    public User(String email, String id, String name, Password password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.passwordAsPassword = password;
    }

    public User(String email, String id, String name, String password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.passwordAsString = password;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
