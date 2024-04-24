package mycompany;

import java.sql.ResultSet;
import java.sql.Statement;

public class Lab8 {

    public static void main(String[] args) {
  try {
            AuthorDAO authorDAO = new AuthorDAO();
            authorDAO.addAuthor("Cristopher Nolan");

            Statement statement = DatabaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM authors");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
}
