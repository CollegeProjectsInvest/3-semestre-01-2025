package user;

import infra.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepository {
    private final Database database;
    private final String TABLE_NAME = "user";

    public UserRepository(Database database) {
        this.database = database;
    }

    public int insert(UserModel userModel) {
        String insertUserSQL = "INSERT INTO " + this.TABLE_NAME + " (name) VALUES (?);";

        try (Connection connection = this.database.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL);

            preparedStatement.setString(1, userModel.getName());
            preparedStatement.executeUpdate();

            return preparedStatement.getGeneratedKeys().getInt(1);
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao inserir um registro: " + error.getMessage());
        } finally {
            System.out.println("Registro inserido com sucesso.");
        }
    }

    public UserModel selectOne(UserModel userModel) {
        String selectOneUserSQL = "SELECT * FROM " + this.TABLE_NAME + " WHERE id = ?;";

        try (Connection connection = this.database.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectOneUserSQL);

            preparedStatement.setInt(1, userModel.getId());
            ResultSet result = preparedStatement.executeQuery();

            return new UserModel(result.getInt("id"), result.getString("name"));
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao selecionar um registro: " + error.getMessage());
        } finally {
            System.out.println("Registro selecionado com sucesso.");
        }
    }

    public ArrayList<UserModel> selectAll() {
        String selectAllUsersSQL = "SELECT * FROM " + this.TABLE_NAME + ";";

        try (Connection connection = this.database.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectAllUsersSQL);

            ResultSet result = preparedStatement.executeQuery();

            ArrayList<UserModel> users = new ArrayList<>();

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");

                UserModel userModel = new UserModel(id, name);
                users.add(userModel);
            }

            return users;
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao selecionar vários registros: " + error.getMessage());
        } finally {
            System.out.println("Registros selecionados com sucesso.");
        }
    }

    public int updateOne(UserModel userModel) {
        String updateUserSQL = "UPDATE " + this.TABLE_NAME + " SET name = ? WHERE id = ?;";

        try (Connection connection = this.database.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateUserSQL);

            preparedStatement.setString(1, userModel.getName());
            preparedStatement.setInt(2, userModel.getId());

            return preparedStatement.executeUpdate();
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao atualizar um registro: " + error.getMessage());
        } finally {
            System.out.println("Registro atualizado com sucesso.");
        }
    }

    public int deleteOne(UserModel userModel) {
        String updateUserSQL = "DELETE FROM " + this.TABLE_NAME + " WHERE id = ?;";

        try (Connection connection = this.database.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateUserSQL);

            preparedStatement.setInt(1, userModel.getId());

            return preparedStatement.executeUpdate();
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao deletar um registro: " + error.getMessage());
        } finally {
            System.out.println("Registro deletado com sucesso.");
        }
    }
}
