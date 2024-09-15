package ArvoreBinariaExpArit;

public class NodeOperador extends TreeNode {
	public char operador;
	TreeNode left, right;
	
	public NodeOperador(char operador, TreeNode left, TreeNode right) {
		this.operador = operador;
		this.left = left;
		this.right = right;
	}
	
	public void preOrder() {
        System.out.println(operador + " ");
        left.preOrder();
        right.preOrder();
    }

    public void inOrder() {
        left.inOrder();
        System.out.println(operador + " ");
        right.inOrder();
    }

    public void postOrder() {
        left.postOrder();
        right.postOrder();
        System.out.println(operador + " ");
    }
    
    public float visitar() {
    	try
    	{
    		float leftValue = left.visitar();
    		float rightValue = right.visitar();
    		
    		switch(operador) {
    		case '+':
    			return leftValue + rightValue;
    		case '-':
    			return leftValue - rightValue;
    		case '*':
    			return leftValue * rightValue;
    		case '/':
    			if(rightValue==0) {
    				throw new Exception("Não é possível realizar divisão por zero.");
    			}
    			return leftValue / rightValue;
    		default:
    			return Float.NaN;
    		}
    	}
    	catch (Exception e){
    		 throw new RuntimeException("Erro ao avaliar a expressão", e);
    	}
    	
    }
}
