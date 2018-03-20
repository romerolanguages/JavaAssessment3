package user_management;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;

import java.lang.reflect.Type;
import java.util.Arrays;

public class UserCollectionInitializer {

    public UserCollectionInitializer() {
    }

    public static UserCollection generate() throws Exception {
        String users = readRawDataToString();
        UserCollection<User> userCollection = convertJsonStringToUserCollection(users);
        return userCollection;
    }

    // Changed to "ElementCollection.class" to be able to read from static method
    public static String readRawDataToString() throws Exception{
        ClassLoader classLoader = UserCollection.class.getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("users.json"));
        return result;
    }

    public static UserCollection<User> convertJsonStringToUserCollection(String jsonString) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<UserCollection<User>>() {}.getType();
        UserCollection<User> elements = gson.fromJson(jsonString, collectionType);
        return elements;
    }

    public static void main(String[] args) throws Exception {

        UserCollectionInitializer eci = new UserCollectionInitializer();
        String users = eci.readRawDataToString();
        UserCollection<User> userCollection = eci.convertJsonStringToUserCollection(users);

        System.out.println(Arrays.toString(userCollection.toArray()));
        System.out.println(userCollection.get(0));

    }

}
