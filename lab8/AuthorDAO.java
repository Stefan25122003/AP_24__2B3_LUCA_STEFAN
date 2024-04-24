
package mycompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class AuthorDAO {
    private Connection connection;

    public AuthorDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void addAuthor(String name) {
        String query = "INSERT INTO Authors (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}