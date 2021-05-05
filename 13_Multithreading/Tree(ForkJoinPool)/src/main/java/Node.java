import java.util.HashSet;

public class Node {
    private String parentName;
    private String name;
    private HashSet<String> children;

    public Node(String parentName, String name, HashSet<String> children) {
        this.parentName = parentName;
        this.name = name;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public HashSet<String> getChildren() {
        return this.children;
    }

    public String getParentName() {
        return parentName;
    }
}
