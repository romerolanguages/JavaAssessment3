package user_management;

import user_management.security.Password;

public class User {

    protected String email;
    protected int id;
    protected String name;
    protected Password password;

    public User() {
    }

    public User(String email, int id, String name, Password password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String email, int id, String name, String passwordAsString) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = new Password(passwordAsString);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

//    public void setPassword(String passwordAsString) {
//        this.password = new Password(passwordAsString);
//    }

    public Password getPassword() {
        return password;
    }

    @Override
    public String toString() {
        String namePlusEmailFormat = name + " - " + email;
        return namePlusEmailFormat;
    }

    @Override
    public boolean equals(Object obj) {
        boolean response = false;
        if (this.equals(obj)) {
            response = true;
        }
        return response;
    }
}
