package controller;

import database.entities.Task;
import model.TaskModel;
import java.util.ArrayList;

public class TaskController {
    private final TaskModel taskModel;

    public TaskController(TaskModel taskModel) {
        this.taskModel = taskModel;
    }

    public boolean createTask(Task task) {
        return this.taskModel.create(task);
    }

    public ArrayList<Task> listAll() {
        return this.taskModel.listAll();
    }

    public boolean deleteTask(int id) {
        return this.taskModel.deleteTask(id);
    }

    public Task getById(int id) {
        return this.taskModel.getById(id);
    }

    public boolean updateTask(int id, boolean finished) {
        return this.taskModel.updateTask(id, finished);
    }
}
