import controller.TaskController;
import database.Database;
import model.TaskModel;
import view.TaskView;

public class Main {
    public static void main(String[] args) {
        // Connection Database
        Database database = new Database();

        // Factory
        TaskModel taskModel = new TaskModel(database);
        TaskController taskController = new TaskController(taskModel);
        TaskView taskView = new TaskView(taskController);

        taskView.listAllTasks();
    }
}
