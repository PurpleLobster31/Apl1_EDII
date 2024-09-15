package ArvoreBinariaExpArit;

import java.util.Scanner;

public class TelaInicial {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		boolean executando = true;
        while (executando) {
            limpaConsole();
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
	
	private static void limpaConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
	
	public static int lerEscolhaUsuario() {
		int escolha = scanner.nextInt();
        scanner.nextLine();  
        return escolha;
	}
	
	private static void enviarExpressao() {
        System.out.print("Digite a expressão aritmética: ");
        String expression = scanner.nextLine();
        System.out.println("Você digitou a expressão: " + expression);
    }

    private static void criarArvoreExpressao() {
        System.out.println("Criando árvore de expressão aritmética...");
    }

    private static void mostrarArvoreExpressao() {
        System.out.println("Exibindo árvore de expressão aritmética...");
    }

    private static void calcularExpressao() {
        System.out.println("Calculando a expressão...");
    }
}
