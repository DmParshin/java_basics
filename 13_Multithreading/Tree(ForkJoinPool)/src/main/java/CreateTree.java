import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.RecursiveTask;

public class CreateTree extends RecursiveTask<Tree> {
    static Tree tree = new Tree("TEST_TREE");
    static int depthCount = 0;
    static int depthTree = 4;

    private String parentName;
    private String selfName;
    private HashSet<String>children;

    Random random = new Random();

    CreateTree(String parentName, String selfName, HashSet<String>children){
        this.parentName = parentName;
        this.selfName = selfName;
        this.children = children;

    }
    @Override
    protected Tree compute() {
        List<CreateTree> taskList = new ArrayList<>();
        Node node = new Node(parentName, selfName, children);
        tree.addNode(node);

        int randomSize = random.nextInt(3) + 1;

        depthCount++;
        if(depthCount < depthTree){
            for(String child:children) {
                HashSet<String> childList = new HashSet();
                for(int i = 0; i < randomSize; i++){
                    childList.add(String.valueOf(random.nextInt(90) + 10));
                }
                String nextName = child;
                String nextParentName = selfName;
                CreateTree task = new CreateTree(nextParentName,nextName,childList);
                task.fork();
                taskList.add(task);
            }
        }

        for(CreateTree task:taskList){
            task.join();
        }
        return tree;
    }
}
