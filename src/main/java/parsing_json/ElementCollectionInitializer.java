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

    // Removed static to be able to call other methods
    public static ElementCollection<Element> generate() throws Exception {
        String periodic_table = readRawDataToString();
        ElementCollection<Element> elements = convertJsonStringToElementCollection(periodic_table);
        return elements;
    }

    // Changed to "ElementCollection.class" to be able to read from static method
    public static String readRawDataToString() throws Exception{
        ClassLoader classLoader = ElementCollection.class.getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("periodic_table.json"));
        return result;
    }

    public List<Element> convertJsonStringToArrayList(String jsonString) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<List<Element>>() {}.getType();
        List<Element> elements = gson.fromJson(jsonString, collectionType);
        return elements;
    }

    public static ElementCollection<Element> convertJsonStringToElementCollection(String jsonString) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<ElementCollection<Element>>() {}.getType();
        ElementCollection<Element> elements = gson.fromJson(jsonString, collectionType);
        return elements;
    }

    public static void main(String[] args) throws Exception {

        ElementCollectionInitializer eci = new ElementCollectionInitializer();
        String periodic_table = eci.readRawDataToString();
        ElementCollection<Element> elements = eci.convertJsonStringToElementCollection(periodic_table);

        System.out.println(Arrays.toString(elements.toArray()));
        System.out.println(elements.get(0).getMelt());

    }
}
