import java.sql.*;

public class Main {
    public static Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch(SQLException e) {
            System.out.println("Erro connection database: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        // Conexão com o Banco
        Connection connect = connect();


        try {
            Statement statement = connect.createStatement();
            String insertTaskSQL = "INSERT INTO tasks (title) VALUES ('" + title + "');";
            boolean result = statement.execute(insertTaskSQL);
            System.out.println(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


//
//        // Criar Tabela
//        try {
//            Statement statement = connect.createStatement();
//            String createTableSQL = "CREATE TABLE IF NOT EXISTS tasks (" +
//                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    "title TEXT" +
//                    ");";
//            boolean result = statement.execute(createTableSQL);
//
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}
