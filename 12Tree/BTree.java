import java.io.*;
import java.util.*;
public class BTree<E> {
    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    public String name(){
	return "gerstein.isaac";
    }
    
    private TreeNode<E> root;
    Random r = new Random();

    public BTree() {
	root = null;
    }
    
    public void add(E d) {
	if (root == null){
	    root = new TreeNode<E>(d);
	}else{
	    add(root, new TreeNode<E>(d));
	}
    }

    private void add(TreeNode<E> curr, TreeNode<E> bn) {
	if (curr.getLeft() == null && curr.getRight() == null){
	    int randomInt = r.nextInt(2);
	    if (randomInt == 0){
		curr.setLeft(bn);
	    }else{
		curr.setRight(bn);
	    }
	}else if (curr.getLeft() == null){
	    curr.setLeft(bn);
	}else if (curr.getRight() == null){
	    curr.setRight(bn);
	}else{
	    int randomInt = r.nextInt(2);
	    if (randomInt == 0){
		add(curr.getLeft(), bn);
	    }else{
		add(curr.getRight(), bn);
	    }
	}
    }
    
    public void traverse(int mode) {
	if (mode == PRE_ORDER){
	    preOrder(root);
	}else if (mode == IN_ORDER){
	    inOrder(root);
	}else{
	    postOrder(root);
	}
	System.out.println();
    }
 
    public void preOrder(TreeNode<E> curr) {
	System.out.println(curr);
	if (curr.getLeft() != null){
	    preOrder(curr.getLeft());
	}
	if (curr.getRight() != null){
	    preOrder(curr.getRight());
	}
    }

    public void inOrder(TreeNode<E> curr) {
	if (curr.getLeft() != null){
	    inOrder(curr.getLeft());
	}
	System.out.println(curr);
	if (curr.getRight() != null){
	    inOrder(curr.getRight());
	}
    }

    public void postOrder(TreeNode<E> curr) {
	if (curr.getLeft() != null){
	    postOrder(curr.getLeft());
	}
	if (curr.getRight() != null){
	    postOrder(curr.getRight());
	}
	System.out.println(curr);
    }

    public int getHeight() {
	return getHeight(root);
    }
 
    public int getHeight(TreeNode<E> curr) {
	if (curr.getLeft() == null && curr.getRight() == null){
	    return 1;
	}else if (curr.getLeft() == null){
	    return 1 + getHeight(curr.getRight());
	}else if (curr.getRight() == null){
	    return 1 + getHeight(curr.getLeft());
	}else{
	    int leftHeight = getHeight(curr.getLeft());
	    int rightHeight = getHeight(curr.getRight());
	    if (leftHeight > rightHeight){
		return 1 + leftHeight;
	    }else{
		return 1 + rightHeight;
	    }
	}
    }

    private String getLevel(TreeNode<E> curr, int level) {
	if (curr != null){
	    if (level == 0){
		return curr.toString() + " ";
	    }else{
		return getLevel(curr.getLeft(), level - 1) + getLevel(curr.getRight(), level - 1);
	    }
	}
	return "";
    }

    public String toString() {
	String ans = "";
	for (int i = 0; i < getHeight(); i++){
	    ans += getLevel(root, i) + "\n";
	}
	return ans.substring(0, ans.length() - 2);
    }
}
