package Database;

import java.sql.*;

public class DAO {
    private static String SQL_SELECT_PASSWORD = "SELECT password FROM users WHERE username = ?";
    private static String username = null;

    public DAO(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection (){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Factory","postgres", "postinor");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean login(String username, String password) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_PASSWORD);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                if(password.equals(resultSet.getString(1))){
                    this.username = username;
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
