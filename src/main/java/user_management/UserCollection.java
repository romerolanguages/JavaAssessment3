package user_management;

import java.util.ArrayList;

public class UserCollection<E> extends ArrayList<E> {

    public User findById(int id) throws Exception {
        User userToReturn = null;
        for (user_management.User user : UserCollectionInitializer.generate()) {
            if (id == user.getId()) {
                userToReturn = (User) user;
                break;
            }
        }
        return userToReturn;
    }

    public User findByEmail(String email) throws Exception {
        User userToReturn = null;
        for (user_management.User user : UserCollectionInitializer.generate()) {
            if (email.equals(user.getEmail())) {
                userToReturn = (User) user;
                break;
            }
        }
        return userToReturn;
    }

    public User attemptLogin(String email, String password) {
        return null;
    }

    public int createUser(String name, String email, String password) {
        return 0;
    }
}
