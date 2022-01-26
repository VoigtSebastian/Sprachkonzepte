import java.util.LinkedList;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

public final class Generator {
    public static void main(String[] args) throws Exception {
        var list = new LinkedList<Class<?>>();
        list.add(Class.forName("java.lang.String"));

        ST template = new STGroupFile("aufgabe7.stg").getInstanceOf("classInfo");
        template.add("list", list);
        String result = template.render();
        System.out.println(result);
    }
}
