package parsing_json;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ElementCollectionInitializer {

    private ArrayList<String> list = new ArrayList<String>();
    String json = new Gson().toJson(list);

    public void testOnly() {
        list.add("test1");
    }

    public static ElementCollection generate() {

        return null;
    }


}
