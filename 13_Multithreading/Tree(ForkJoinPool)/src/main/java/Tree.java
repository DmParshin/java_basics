import java.util.LinkedList;

public class Tree {

    private String name;
    private LinkedList<Node> nodes;

    public Tree(String name) {
        this.name = name;
        this.nodes = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public LinkedList<Node> getNodes(){
        return nodes;
    }
}
