package user_management;

import user_management.security.Password;

public class User {

    protected String email;
    protected String id;
    protected String name;
    protected Password password;

    public User() {
    }

    public User(String email, String id, String name, Password password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String email, String id, String name, String passwordAsString) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = new Password(passwordAsString);
    }

    public void setPassword(Password password) {
        this.password = password;
    }
    
    public void setPassword(String passwordAsString) {
        this.password = new Password(passwordAsString);
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
