package model;

import database.Database;
import database.entities.Task;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TaskModel {
    private final Database database;

    public TaskModel(Database database) {
        this.database = database;
    }

    /**
     * Cria tarefa no Banco de Dados
     * @param task Task
     */
    public void create(Task task) {
        String createTaskSQL = "INSERT INTO tasks (title, finished) VALUES ('" + task.getTitle() + "', " + task.getFinished() + ");";

        try (Connection connection = this.database.connect()) {
            Statement statement = connection.createStatement();
            statement.execute(createTaskSQL);

            System.out.println("Tarefa criada com sucesso!");
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao criar nova tarefa: " + error);
        }
    }

    /**
     * Listar todas as Tarefas do Banco de Dados
     * @return Task[]
     */
    public ArrayList<Task> listAll() {
        String selectTasksSQL = "SELECT * FROM tasks;";
        ArrayList<Task> tasks = new ArrayList<>();

        try (Connection connection = this.database.connect()) {
            Statement statement = connection.createStatement();
            var resultSet = statement.executeQuery(selectTasksSQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                boolean finished = resultSet.getBoolean("finished");

                tasks.add(new Task(id, title, finished));
            }

            return tasks;
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao criar nova tarefa: " + error);
        }
    }
}
