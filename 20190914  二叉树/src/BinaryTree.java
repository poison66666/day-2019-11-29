import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;


public class BinaryTree {
    public static class Node {
        public char val;
        public Node left = null;
        public Node right = null;
        Node parent;
        public Node(char val) {
            this.val = val;
        }
        @Override
        public String toString(){
            return String.format("{%c}",val);
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
        e.right = h;

        return a;
    }

    //前序遍历
    public static void prevOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root);
        prevOrderTraversal(root.left);
        prevOrderTraversal(root.right);
    }

    //中序遍历
    public static void inOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root);
        inOrderTraversal(root.right);
    }

    //后序遍历
    public static void postOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root);
    }



    //前序遍历（结点个数）
    private static int count = 0;
    public static void getSize(Node root) {

        if(root == null) {
            return;
        }
        count++;
        getSize(root.left);
        getSize(root.right);
    }

    //汇总前序遍历得到结点个数
    public static int getSize2(Node root) {
        if(root == null){
            return 0;
        }
        int left = getSize2(root.left);
        int right = getSize2(root.right);
        return left + right + 1;
    }

    //汇总进行前序遍历List
    public List<Character> preorderTraversal(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Character> left = preorderTraversal(root.left);
        List<Character> right = preorderTraversal(root.right);

        List<Character> list = new ArrayList<>();
        list.add(root.val);
        list.addAll(left);
        list.addAll(right);

        return list;
    }

    //汇总经进行中序遍历
    public List<Character> inorderTraversal(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Character> left = inorderTraversal(root.left);
        List<Character> right = inorderTraversal(root.right);

        List<Character> list = new ArrayList<>();
        list.addAll(left);
        list.add(root.val);
        list.addAll(right);

        return list;
    }

    private static List<Character> inorderList = new ArrayList<>();
    private static void inorderReturnList(Node root) {
        if (root != null) {
            inorderReturnList(root.left);
            inorderList.add(root.val);
            inorderReturnList(root.right);
        }
    }

    private static List<Character> inorderReturnList2(Node root) {
        List<Character> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        list.addAll(inorderReturnList2(root.left));
        list.add(root.val);
        list.addAll(inorderReturnList2(root.right));
        return list;
    }

    //求叶子结点个数
    private static int leafSize = 0;
    private static void getLeafSize(Node root) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize(root.left);
        getLeafSize(root.right);
    }

    //汇总求叶子节点
    private static int getLeafSize2(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int left = getLeafSize2(root.left);
        int right = getLeafSize2(root.right);
        return left+right;
  }

    //求二叉树的高度（只能汇总思想）
    public static int getHeight(Node root) {
        if(root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        int x = Math.max(left,right);
        return x+1;
    }

    //求二叉树第k层的结点个数（汇总）
    public static int getKLevel(Node root,int k) {

        if(root == null) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getKLevel(root.left,k-1) + getKLevel(root.right,k-1);
    }

    //查找val所在结点
    public static Node find(Node root,int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        Node n = find(root.left,val);
        if(n != null) {
            return n;
        }
        n = find(root.right,val);
        if(n != null) {
            return n;
        }
        return null;
    }

    public static boolean find2(Node root,int val) {
        if(root == null) {
            return false;
        }
        if(root.val == val) {
            return true;
        }
        if(find2(root.left,val)){
            return true;
        }
        return find2(root.right,val);
    }

    public static boolean find3(Node root,int val) {
        return root != null &&(root.val == val || find3(root.left,val) || find3(root.right,val));
    }

    //互为镜像的二叉树
    public static boolean isMirrorTree(Node p ,Node q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return p.val == q.val && isMirrorTree(p.left,q.right) && isMirrorTree(p.right,q.left);

    }

    public static Node buildTree(List<Character> preorder,List<Character> inorder) {

        if(preorder.isEmpty()){
            return null;
        }
        char rootValue = preorder.get(0);
        int count;
        for(count = 0;count < inorder.size();count++) {
            if(inorder.get(count) == rootValue) {
                break;
            }
        }
        Node root = new Node(rootValue);
        List<Character> leftpreorder =new ArrayList<>();
        leftpreorder.addAll(preorder.subList(1,1+count));
        List<Character> leftinorder = new ArrayList<>();
        leftinorder.addAll(inorder.subList(0,count));
        root.left = buildTree(leftpreorder,leftinorder);

        List<Character> rightpreorder = new ArrayList<>();
        rightpreorder.addAll(preorder.subList(1+count,preorder.size()));
        List<Character> rightinorder = new ArrayList<>();
        rightinorder.addAll(inorder.subList(count+1,inorder.size()));
        root.right = buildTree(rightpreorder,rightinorder);

        return root;
    }

   public static Node buildTree2(List<Character> inorder,List<Character> postorder) {
        if(inorder.size() == 0) {
            return null;
        }
        char rootValue = postorder.get(postorder.size()-1);
        int count;
        for(count = 0;count < inorder.size();count++) {
            if(inorder.get(count) == rootValue) {
                break;
            }
        }
       Node root = new Node(rootValue);
        List<Character> leftinorder = new ArrayList<>();
        leftinorder.addAll(inorder.subList(0,count));
        List<Character> leftpostorder = new ArrayList<>();
        leftpostorder.addAll(postorder.subList(0,count));
        root.left = buildTree2(leftinorder,leftpostorder);

        List<Character> rightinorder = new ArrayList<>();
        rightinorder.addAll(inorder.subList(count+1,inorder.size()));
        List<Character> rightpostorder = new ArrayList<>();
        rightpostorder.addAll(postorder.subList(count,inorder.size()-1));
        root.right = buildTree2(rightinorder,rightpostorder);

       return root;
   }

   private static class BTRV {
        private Node root;
        private int used;
   }

   BTRV buildTree5(List<Character> preorder){
        BTRV returnValue = new BTRV();
        if(preorder.size() == 0) {
            returnValue.root = null;
            returnValue.used = 0;
            return returnValue;
        }
        char rootValue = preorder.get(0);
        if(rootValue == '#'){
            returnValue.root = null;
            returnValue.used = 1;
            return returnValue;
        }
        BTRV leftReturn = buildTree5(preorder.subList(1,preorder.size()));
        BTRV rightReturn = buildTree5(preorder.subList(1+leftReturn.used,preorder.size()));
        Node root = new Node(rootValue);
        root.left = leftReturn.root;
        root.right = rightReturn.root;
        returnValue.root = root;
        returnValue.used = 1 + leftReturn.used + rightReturn.used;
        return returnValue;

   }

    public static void main(String[] args) {

        //前中后序遍历
        Node root = buildTree();
        System.out.println("success");
        prevOrderTraversal(root);
        System.out.println("------------");
        inOrderTraversal(root);
        System.out.println("------------");
        postOrderTraversal(root);
        System.out.println("------------");

        //获取结点个数
        count = 0;
        getSize(root);
        System.out.println("结点个数："+count);
        System.out.println("结点个数："+getSize2(root));
        System.out.println("------------");

        inorderList.clear();
        inorderReturnList(root);
        System.out.println(inorderList);
        System.out.println(inorderReturnList2(root));
        System.out.println("------------");

        leafSize = 0;
        getLeafSize(root);
        System.out.println("叶子结点个数："+leafSize);
        System.out.println("------------");

        System.out.println(getHeight(root));
        System.out.println("------------");

        System.out.println(getKLevel(root,1));
        System.out.println(getKLevel(root,2));
        System.out.println(getKLevel(root,3));
        System.out.println(getKLevel(root,4));
        System.out.println(getKLevel(root,5));


        System.out.println("-----重现二叉树------");
        ArrayList<Character> l1=new ArrayList<>();
        l1.add('A');
        l1.add('B');
        l1.add('D');
        l1.add('E');
        l1.add('C');
        l1.add('F');
        ArrayList<Character> l2=new ArrayList<>();
        l2.add('D');
        l2.add('B');
        l2.add('E');
        l2.add('A');
        l2.add('C');
        l2.add('F');
        ArrayList<Character> l3=new ArrayList<>();
        l3.add('D');
        l3.add('E');
        l3.add('B');
        l3.add('F');
        l3.add('C');
        l3.add('A');
        Node head=BinaryTree.buildTree2(l2,l3);
       // postOrderTraversal(head);

        prevOrderTraversal(head);

    }
}
