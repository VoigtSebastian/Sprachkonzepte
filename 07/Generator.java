import java.util.HashMap;
import java.util.LinkedList;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

public final class Generator {
    public static void main(String[] args) throws Exception {
        var list = new LinkedList<ClassInfo>();
        list.add(new ClassInfo(Class.forName("java.lang.String")));

        ST template = new STGroupFile("aufgabe7.stg").getInstanceOf("aufgabe7");
        template.add("list", list);

        String result = template.render();
        System.out.println(result);
    }
}

final class ClassInfo {
    public final String name;
    public LinkedList<InterfaceInfo> interfaces;

    public ClassInfo(Class<?> c) {
        this.name = c.getName();
        this.interfaces = new LinkedList<>();
        for (var i : c.getInterfaces()) {
            var currentInterface = new InterfaceInfo(i.getName());

            for (var m : i.getMethods()) {
                currentInterface.methods.add(m.getReturnType().getName() + " " + m.getName());
            }
            this.interfaces.add(currentInterface);
        }
    }
}

final class InterfaceInfo {
    public final String name;
    public final LinkedList<String> methods;

    public InterfaceInfo(String name) {
        this.name = name;
        this.methods = new LinkedList<>();
    }
}
