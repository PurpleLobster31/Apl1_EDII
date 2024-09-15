package ArvoreBinariaExpArit;

import java.util.Stack;

public class ArvoreBinaria {
	TreeNode raiz;
	
	public void construirArvore(String expressao) {
		Stack <TreeNode> pilhaNode = new Stack<>();
		Stack<Character> pilhaOperadores = new Stack<>();
		
		for (int i=0; i < expressao.length(); i++) {
			char c = expressao.charAt(i);
			
			if(c==' ') continue;
			
			if(!isOperator(c) && c!='(' && c!=')') {
				StringBuilder operando = new StringBuilder();
				while(i<expressao.length() && (Character.isDigit(expressao.charAt(i)) || expressao.charAt(i)=='.')) {
					operando.append(expressao.charAt(i));
					i++;
				}
				i--;
				float valor = Float.parseFloat(operando.toString());
				NodeOperando nodeOperando = new NodeOperando(valor);
				pilhaNode.push(nodeOperando);
			}
			
			else  {
				if (c == '(') {
                    pilhaOperadores.push(c);
                } 
				else if (c == ')') {
                    while (!pilhaOperadores.isEmpty() && pilhaOperadores.peek() != '(') {
                        char op = pilhaOperadores.pop();
                        TreeNode right = pilhaNode.pop();
                        TreeNode left = pilhaNode.pop();
                        NodeOperador nodeOperador = new NodeOperador(op, left, right);
                        pilhaNode.push(nodeOperador);
                    }
                    pilhaOperadores.pop(); 
                } else {
                    while (!pilhaOperadores.empty() && precedencia(pilhaOperadores.peek()) >= precedencia(c)) {
                        char op = pilhaOperadores.pop();
                        TreeNode right = pilhaNode.pop();
                        TreeNode left = pilhaNode.pop();
                        NodeOperador nodeOperador = new NodeOperador(op, left, right);
                        pilhaNode.push(nodeOperador);
                    }
                    pilhaOperadores.push(c);
                }
			}
		}
		
		while(!pilhaOperadores.empty())
		{
			char operador = pilhaOperadores.pop();
			TreeNode right = pilhaNode.pop();
			TreeNode left = pilhaNode.pop();
			NodeOperador nodeOperador = new NodeOperador(operador, left, right);
			pilhaNode.push(nodeOperador);
		}
		
		raiz = pilhaNode.peek();
	}
	
	public void preOrder() {
        if (raiz != null) {
            raiz.preOrder();
        }
    }

    public void inOrder() {
        if (raiz != null) {
            raiz.inOrder();
        }
    }

    public void postOrder() {
        if (raiz != null) {
            raiz.postOrder();
        }
    }
	
    public float obterExpressao() {
    	if(raiz==null) return 0;
    	return raiz.visitar();
    }
    
	public int precedencia(char operador) {
		switch(operador) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}
	
	public boolean isOperator(char c) {
		return (c=='+' || c=='-' || c=='*' || c=='/');
	}
}
