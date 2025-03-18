import java.util.ArrayList;
import java.util.Scanner;

// Connectar Java com SQLite
public class Exercicio3 {
    public static void listarTarefas(ArrayList<String> tarefas) {
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println("[" + i + "] - " + tarefas.get(i));
        }
    }

    public static void main(String[] args) {
        // ["Tarefa 1", "Tarefa 2"]
        ArrayList<String> tarefas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione uma opção:\n" +
                    "[1] Adicionar Tarefa\n" +
                    "[2] Remove Tarefa\n" +
                    "[3] Listar Tarefas\n" +
                    "[0] Sair do programa");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                // Adicionar Tarefa
                System.out.println("Digite o nome da tarefa:");
                String nomeTarefa = scanner.nextLine();
                tarefas.add(nomeTarefa);
            } else if (opcao == 2) {
                // Remover Tarefa
                listarTarefas(tarefas);
                System.out.println("Digite o index da tarefa que queira remover:");
                int indexTarefa = scanner.nextInt();
                tarefas.remove(indexTarefa);
                System.out.println("Tarefa removida!");
            } else if (opcao == 3) {
                listarTarefas(tarefas);
            } else if (opcao == 0) {
                System.out.println("Volte sempre!");
                break;
            }
        }
    }
}
