package parsing_json;

import java.lang.reflect.Field;
import java.util.ArrayList;

import parsing_json.Element;

public class ElementCollection<E> extends ArrayList<E>{

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

    public ElementCollection<Element> where(String fieldName, Object value) throws Exception {
        ElementCollection<Element> elementsThatMatch = new ElementCollection<>();

        Class elementClassInQuestion = Element.class;
        Field field = elementClassInQuestion.getDeclaredField(fieldName);
        if (field != null) {
            for (Element element : ElementCollectionInitializer.generate()) {
                if (field.get(element).equals(value)) {
                    elementsThatMatch.add(element);
                }
            }
        }
        return elementsThatMatch;
    }

    public static void main(String[] args) throws Exception {

        ElementCollection ec = new ElementCollection();

        ec.where("name", "Hydrogen");

    }
}
