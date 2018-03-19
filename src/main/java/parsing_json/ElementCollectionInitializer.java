package parsing_json;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ElementCollectionInitializer {

    public ElementCollectionInitializer() {
    }

    private ArrayList<String> list = new ArrayList<String>();
    String json = new Gson().toJson(list);

    public static ElementCollection generate() {

        return null;
    }

    public void testOnly() {
        JsonParser parser = new JsonParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("periodic_table.json");
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        String rootObjectString = rootElement.getAsString();
        System.out.println(rootObjectString);
    }

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("periodic_table.json"));
        return result;
    }

    public List<Element> convertJsonToArrayList(String jsonString) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<List<Element>>() {}.getType();
        List<Element> elements = gson.fromJson(jsonString, collectionType);
        return elements;
    }

    public static void main(String[] args) throws Exception {

        ElementCollectionInitializer eci = new ElementCollectionInitializer();
//        eci.testOnly();

        String periodic_table = eci.readRawDataToString();
//        System.out.println(periodic_table);
        List<Element> elements = eci.convertJsonToArrayList(periodic_table);


    }
}
