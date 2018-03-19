package parsing_json;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.junit.Assert.*;

public class ElementCollectionInitializerTest {

//    @Test
//    public void generate() throws IOException {
//        assertEquals(119, ElementCollectionInitializer.generate().size());
//    }

    @Test
    public void testOnlyTest() {
        JsonParser parser = new JsonParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("periodic_table.json");
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        Assert.assertNotNull(rootElement);
    }
}