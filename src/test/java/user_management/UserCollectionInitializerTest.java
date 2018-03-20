package user_management;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserCollectionInitializerTest {

    @Test
    public void generate() throws Exception {
        assertEquals(1000, UserCollectionInitializer.generate().size());
    }
}