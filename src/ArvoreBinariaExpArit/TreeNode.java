package ArvoreBinariaExpArit;

abstract class TreeNode {
    public TreeNode left, right;
	abstract void preOrder(); 
    abstract void inOrder();  
    abstract void postOrder(); 
    abstract float visitar(); 
}

