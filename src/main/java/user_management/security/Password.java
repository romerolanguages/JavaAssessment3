package user_management.security;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
    private final static int workload = 12;
    private String hash;

    public Password(String password) {
        // Hash a password for the first time
        this.hash = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt();
        //hash = hasher.hash(password, salt)
        String staticHash = BCrypt.hashpw(password_plaintext, salt);
        // return hash
        return staticHash;
    }

    public boolean matches(String password_plaintext) {
        // Note: normally a match method would include a check to see if the hash is valid but for this exam we will
        //       assume that all the passwords we will check are valid. All of the password hashes in the users.json
        //       file are valid so there should be no worry about this as long as you don't overwrite them manually.

        boolean response = false;
        // hashToCheckAgainst = this.hash

        // Check that an unencrypted password matches one that has
        // previously been hashed
        if (BCrypt.checkpw(password_plaintext, hash)) {
                response = true;
        }
        return response;
    }

    public String getHash() {
        return hash;
    }
}
