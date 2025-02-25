package infra;

import java.sql.*;

public class Database {
    private static final String CONNECTION_URL = "jdbc:sqlite:database.db";

    public Database() {
        this.configuration();
    }

    public Connection connect() {
        try {
            return DriverManager.getConnection(CONNECTION_URL);
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao conectar com o Banco de Dados" + error.getMessage());
        }
    }

    public void configuration() {
        String createTableUserSQL = "CREATE TABLE IF NOT EXISTS user (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL" +
                ");";

        try (Connection connection  = connect()) {
            Statement statement = connection.createStatement();
            statement.execute(createTableUserSQL);

            System.out.println("Banco de Dados configurado com sucesso.");
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao configurar Banco de Dados" + error.getMessage());
        }
    }
}
