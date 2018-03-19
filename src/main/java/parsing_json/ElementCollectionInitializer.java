package parsing_json;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
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

    public List<Element> convertJsonStringToArrayList(String jsonString) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<List<Element>>() {}.getType();
        List<Element> elements = gson.fromJson(jsonString, collectionType);
        return elements;
    }

    public static void main(String[] args) throws Exception {

        ElementCollectionInitializer eci = new ElementCollectionInitializer();
        String periodic_table = eci.readRawDataToString();
        List<Element> elements1 = eci.convertJsonStringToArrayList(periodic_table);
        System.out.println(Arrays.toString(elements1.toArray()));
        System.out.println(elements1.get(0).getShells().get(0));


    }
}
