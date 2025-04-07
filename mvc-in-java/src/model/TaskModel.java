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
    public boolean create(Task task) {
        String createTaskSQL = "INSERT INTO tasks (title, finished) VALUES (?, ?);";

        try (Connection connection = this.database.connect()) {
            var statement = connection.prepareStatement(createTaskSQL);

            statement.setString(1, task.getTitle());
            statement.setBoolean(2, task.getFinished());

            var result = statement.executeUpdate();

            return result == 1;
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

    /**
     * Atualiza uma tarefa
     * @param id int
     * @param finished boolean
     * @return boolean
     */
    public boolean updateTask(int id, boolean finished) {
        String updateTaskSQL = "UPDATE tasks SET finished = ? WHERE id = ?;";

        try (Connection connection = this.database.connect()) {
            var statement = connection.prepareStatement(updateTaskSQL);

            statement.setBoolean(1, finished);
            statement.setInt(2, id);

            var result = statement.executeUpdate();
            return result == 1;
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao atualizar tarefa: " + error);
        }
    }

    /**
     * Deletar tarefa
     * @param id int
     */
    public boolean deleteTask(int id) {
        String deleteTasksSQL = "DELETE FROM tasks WHERE id = ?;";

        try (Connection connection = this.database.connect()) {
            var statement = connection.prepareStatement(deleteTasksSQL);

            statement.setInt(1, id);

            var result = statement.executeUpdate();

            return result == 1;
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao deletar tarefa: " + error);
        }
    }

    /**
     * Busca uma tarefa pelo Id
     * @param id int
     * @return Task
     */
    public Task getById(int id) {
        String selectTaskSQL = "SELECT * FROM tasks WHERE id = ?;";

        try (Connection connection = this.database.connect()) {
            var statement = connection.prepareStatement(selectTaskSQL);

            statement.setInt(1, id);

            var resultSet = statement.executeQuery();

            String title = resultSet.getString("title");
            boolean finished = resultSet.getBoolean("finished");

            return new Task(id, title, finished);
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao buscar tarefa: " + error);
        }
    }
}
