package view;

import controller.TaskController;
import database.entities.Task;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskView {
    private final TaskController taskController;
    private final Scanner scanner;

    public TaskView(TaskController taskController) {
        this.taskController = taskController;
        this.scanner = new Scanner(System.in);
    }

    public void createTask() {
        System.out.println("== Criando tarefa ==");

        System.out.println("Digite o título da tarefa:");
        String title = scanner.nextLine();

        boolean result = this.taskController.createTask(new Task(title, false));

        if (result) {
            System.out.println("Tarefa criada com sucesso!");
        } else {
            System.out.println("Erro ao criar tarefa.");
        }
    }

    public void listAllTasks() {
        System.out.println("== Listando tarefas ==");

        ArrayList<Task> tasks = this.taskController.listAll();

        for (Task task : tasks) {
            System.out.println("========");
            System.out.println("ID: " + task.getId());
            System.out.println("Título: " + task.getTitle());
            System.out.println("Completada: " + task.getFinished());
        }
    }

    public void deleteTask() {
        System.out.println("=== Deletar Tarefa ===");
        System.out.println("Digite o ID da tarefa que queira deletar:");
        int id = this.scanner.nextInt();

        boolean result = this.taskController.deleteTask(id);

        if (result) {
            System.out.println("Tarefa deletada com sucesso!");
        } else {
            System.out.println("Erro ao deletar tarefa.");
        }
    }

    public void updateTask() {
        System.out.println("=== Atualizar Tarefa ===");

        System.out.println("Digite o ID da tarefa que queira atualizar:");
        int id = this.scanner.nextInt();

        Task task = this.taskController.getById(id);

        System.out.println("=====");
        System.out.println("ID: " + task.getId());
        System.out.println("Título: " + task.getTitle());
        System.out.println("Completada: " + task.getFinished());
        System.out.println("=====");

        System.out.println("Completada? [S/N]: ");
        char finished = this.scanner.next().charAt(0);

        boolean result = this.taskController.updateTask(id, finished == 'S');

        if (result) {
            System.out.println("Tarefa atualizada com sucesso!");
        } else {
            System.out.println("Erro ao atualizar tarefa.");
        }
    }
}
