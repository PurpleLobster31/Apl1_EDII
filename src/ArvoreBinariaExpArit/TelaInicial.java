package ArvoreBinariaExpArit;

import java.util.Scanner;


public class TelaInicial {
	
	private static Scanner scanner = new Scanner(System.in);
	public static boolean expressaoSalva = false;
	public static ArvoreBinaria arvoreExpressao = new ArvoreBinaria();
	public static String expressaoInfixa = "";
	
	public static void main(String[] args) {
		boolean executando = true;
		
        while (executando) {
        	printMenu();
            int escolha = lerEscolhaUsuario();
            switch (escolha) {
                case 1:
                    enviarExpressao();
                    break;
                case 2:
                    criarArvoreExpressao();
                    break;
                case 3:
                    mostrarArvoreExpressao();
                    break;
                case 4:
                	calcularExpressao();
                    break;
                case 5:
                    executando = false;
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
	}
	
	public static void printMenu() {
		System.out.println("▢▢▢▢▢▢▢▢▢▢ ÁRVORE DE EXPRESSÕES ▢▢▢▢▢▢▢▢▢▢");
        System.out.println("1. Enviar expressão aritmética.");
        System.out.println("2. Criar árvore binária de expressão aritmética.");
        System.out.println("3. Exibir árvore binária de expressão aritmética.");
        System.out.println("4. Calcular expressão.");
        System.out.println("5. Encerrar o programa.");
        System.out.print("Digite sua opção: ");
        
        
	}
	
	public static int lerEscolhaUsuario() {
		int escolha = scanner.nextInt();
        scanner.nextLine();  
        return escolha;
	}
	
	private static void enviarExpressao() {
        System.out.print("Digite a expressão aritmética na notação infixa: ");
		expressaoInfixa = scanner.nextLine();
        boolean expressaoValida = validarExpressao(expressaoInfixa);
        if (expressaoValida) {
            System.out.println("Expressao valida.");
            expressaoSalva = true;
        } else {
            System.out.println("Expressao invalida.");
            expressaoSalva = false;
        }
    }
	
	private static boolean validarExpressao(String expressao) {
		boolean caracteresValidos = expressao.matches("^[0-9+\\-*/().\\s]+$");
		boolean parentesesCorretos = verificaParenteses(expressao);
		boolean operadoresValidos = verificaOperadores(expressao);
		
		return caracteresValidos && parentesesCorretos && operadoresValidos;
	}
	
	private static boolean verificaParenteses(String expressao) {
		int contador = 0;
		for (char c: expressao.toCharArray()) {
			
			if(c=='(') contador++;
			else if (c==')') contador--;
			
			if(contador<0) return false;
		}
		return contador == 0;
	}
	
	private static boolean verificaOperadores(String expressao) {
		if (expressao.matches(".[+\\-/]{2,}.*")) {
            return false;
        }
        if (expressao.matches("^[+\\-/].|.[+\\-/]$")) {
            return false;
        }
        return !expressao.matches(".[^0-9()+\\-/.\\s].*");
	}

    private static void criarArvoreExpressao() {
    	if (expressaoSalva) {
            arvoreExpressao.construirArvore(expressaoInfixa);
            System.out.println("Arvore de expressao binaria criada.");
        } else {
            System.out.println("Insira uma expressao valida primeiro.");
        }
    }

    private static void mostrarArvoreExpressao() {
    	if (arvoreExpressao.raiz != null) {
            System.out.println("\nPre-order traversal:");
            arvoreExpressao.preOrder();
            System.out.println("\n\nIn-order traversal:");
            arvoreExpressao.inOrder();
            System.out.println("\n\nPost-order traversal:");
            arvoreExpressao.postOrder();
            System.out.println("\n\nExibição hierárquica da árvore:");
            printTree(arvoreExpressao.raiz, "");
        } else {
            System.out.println("Crie a arvore primeiro.");
        }
    }
    
    private static void printTree(TreeNode node, String indentacao) {
        if (node == null) return;
        System.out.println(indentacao + node);
        printTree(node.left, indentacao + "   ");
        printTree(node.right, indentacao + "   ");
    }

    private static void calcularExpressao() {
    	if (arvoreExpressao.raiz != null) {
            float result = arvoreExpressao.obterExpressao();
            System.out.println("\n\nResultado da expressao: " + result);
        } else {
            System.out.println("Crie a arvore primeiro.");
        }
    }
}
