package controller;

import database.entities.Task;
import model.TaskModel;

import java.util.ArrayList;

public class TaskController {
    private TaskModel taskModel;

    public TaskController(TaskModel taskModel) {
        this.taskModel = taskModel;
    }

    public void createTask(Task task) {
        this.taskModel.create(task);
    }

    public ArrayList<Task> listAll() {
        return this.taskModel.listAll();
    }
}
