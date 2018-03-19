package parsing_json;

import java.util.ArrayList;

public class ElementCollection<Element> extends ArrayList<Element>{

    public ElementCollection() throws Exception {

    }

    public Element findByAtomicNumber(int atomic_number) throws Exception {
        Element elementToReturn = null;
        for (parsing_json.Element element : ElementCollectionInitializer.generate()) {
            if (atomic_number == element.getNumber()) {
                elementToReturn = (Element) element;
            }
        }
        return elementToReturn;
    }

    public Element findByName(String name) throws Exception {
        Element elementToReturn = null;
        for (parsing_json.Element element : ElementCollectionInitializer.generate()) {
            if (name.equals(element.getName())) {
                elementToReturn = (Element) element;
            }
        }
        return elementToReturn;
    }

    public ElementCollection<Element> where(String fieldName, Object value) {
        return null;
    }
}
