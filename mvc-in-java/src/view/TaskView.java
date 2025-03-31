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

        this.taskController.createTask(new Task(title, false));
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
}
