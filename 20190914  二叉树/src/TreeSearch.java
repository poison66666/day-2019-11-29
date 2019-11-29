public class TreeSearch {
    BinaryTree.Node search1(BinaryTree.Node root,int val) {
        if(root == null){
            return null;
        }
        if(root.val == val) {
            return root;
        }
        BinaryTree.Node left = search1(root.left,val);
        if(left != null){
            return left;
        }
        return search1(root.right,val);
    }

    boolean search2(BinaryTree.Node root, int val) {
        if(root == null) {
            return false;
        }
        if(root.val == val) {
            return true;
        }
        if(search2(root.left,val)){
            return true;
        }
        return search2(root.right,val);
    }

    boolean isSameTree(BinaryTree.Node r,BinaryTree.Node s) {
        if(r== null && s == null) {
        return true;
      }
        if(r == null || s == null) {
        return false;
      }
        return r.val == s.val && isSameTree(r.left,s.left) && isSameTree(r.right,s.right);
    }

    boolean search3(BinaryTree.Node root,BinaryTree.Node subRoot) {
        if(root == null) {
            return false;
        }
        if(isSameTree(root,subRoot)){
            return true;
        }
        if(search3(root.left,subRoot)) {
            return true;
        }

        return search3(root.right,subRoot);
    }

    boolean search4(BinaryTree.Node root,BinaryTree.Node node) {
        if(root == null) {
            return false;
        }
        if(root == node) {
            return true;
        }
        if(search4(root.left,node)) {
            return true;
        }
        return search4(root.right,node);
    }
}
