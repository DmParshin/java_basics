import java.util.HashSet;
import java.util.concurrent.ForkJoinPool;

public class Main {

    static Tree tree;

    public static void main(String[] args) {

        HashSet<String>hashSet = new HashSet<>();
        hashSet.add("001");
        hashSet.add("002");

        tree = new ForkJoinPool().invoke(new CreateTree("ROOT", "1_ROOT", hashSet));
        System.out.println(tree.getName());
        printTree();
    }

    public static void printTree (){
        for(Node node: tree.getNodes()) {
            System.out.print("PARENTNAME - " + node.getParentName() + "\tSELFNAME - " + node.getName() + "\tCHILDNAMES:");
            for (String child : node.getChildren()) {
                System.out.print("\t" + child + "\t");
            }
            System.out.println("");
        }
    }
}
