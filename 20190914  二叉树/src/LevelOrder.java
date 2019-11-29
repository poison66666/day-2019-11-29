import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public static class Node {
        char val;
        Node left;
        Node right;
        Node(char val){
            this.val = val;
        }
    }

    public static void levelOrder(Node root){
       if(root == null){
           return;
       }
       Queue<Node> queue = new LinkedList<>();
       queue.offer(root);
       while(!queue.isEmpty()) {
           Node front = queue.poll();//拿出队首元素并删除
           System.out.println(front.val);
           if(front.left != null){
               queue.offer(front.left);
           }
           if(front.right != null){
               queue.offer(front.right);
           }
       }
    }

    public static void levelOrder3(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            System.out.println(tmp.val);
            if(tmp.left != null){
                queue.offer(tmp.left);
            }
            if(tmp.right != null){
                queue.offer(tmp.right);
            }
        }
    }

    public static Node buildTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        e.right =h;
        return a;
    }

    private static class NodeLevel {
        public Node node;
        public int level;

        NodeLevel(Node node,int level){
            this.node = node;
            this.level = level;
        }
    }

    public static void levelOrder2(Node root){
        if(root == null) {
            return;
        }
        Queue<NodeLevel> queue = new LinkedList<>();
        queue.offer(new NodeLevel(root,1));
        while(!queue.isEmpty()) {
            NodeLevel front = queue.poll();
            System.out.println(front.level + ":" + front.node.val);
            if(front.node.left != null) {
                queue.offer(new NodeLevel(front.node.left,front.level+1));
            }
            if(front.node.left != null) {
                queue.offer(new NodeLevel(front.node.right,front.level+1));
            }
        }

    }
    //判断是否为完全二叉树
    public static boolean isCompleteTree(Node root){
        if(root == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(true){
            Node front = queue.poll();
            if(front == null){
                break;
            }
            queue.offer(front.left);
            queue.offer(front.right);
        }
        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(n != null){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
         Node root = buildTree();
         levelOrder2(root);
        System.out.println(isCompleteTree(root));

    }
}
