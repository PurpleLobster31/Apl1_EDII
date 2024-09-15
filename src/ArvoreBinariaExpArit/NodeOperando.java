package ArvoreBinariaExpArit;

public class NodeOperando extends TreeNode {
	public float valor;
	public TreeNode left = null;
	public TreeNode right = null; 
	public NodeOperando(float valor) {
		this.valor = valor;
	}
	
	public void preOrder() {
		System.out.println(valor + "");
	}
	
	public void inOrder() {
		System.out.println(valor + "");
	}
	
	public void postOrder() {
		System.out.println(valor + "");
	}
	
	public float visitar() {
		return valor;
	}
	
}
