public class TreeNode<E>{
    private E data;
    private TreeNode<E> left;
    private TreeNode<E> right;

    public TreeNode(E data){
	this.data = data;
    }

    public String toString(){
	return "" + data;
    }

    public E getData(){
	return data;
    }

    public TreeNode<E> getLeft(){
	return left;
    }

    public TreeNode<E> getRight(){
	return right;
    }

    public void setData(E data){
	this.data = data;
    }

    public void setLeft(TreeNode<E> left){
	this.left = left;
    }

    public void setRight(TreeNode<E> right){
	this.right = right;
    }
}