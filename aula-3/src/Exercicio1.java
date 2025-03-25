import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        // Capturar o número
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número:");
        int numero = scanner.nextInt();

        // mostrar a tabuada
        // 5 x 1 = 5
        // 5 x 2 = 10
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }
}
