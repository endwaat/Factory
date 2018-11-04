package Database;

import java.sql.*;
import java.util.HashMap;

public class DAO {
    private static String SQL_SELECT_PASSWORD = "SELECT password, id FROM users WHERE username = ?";
    private static String SQL_UPDATE_USER = "UPDATE users SET username = ?, password = ?, email = ?, zip = ?, town = ?, address = ?, phone = ? WHERE id = ?";
    private static String SQL_SELECT_USER = "SELECT username, password, email, zip, town, address, phone FROM users WHERE id = ?";
    private static String username = null;
    private int userId;

    public DAO() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Factory", "postgres", "postinor");
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
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (password.equals(resultSet.getString(1))) {
                    this.username = username;
                    userId = resultSet.getInt(2);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveProfile(HashMap values) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
            preparedStatement.setString(1, (String) values.get("username"));
            preparedStatement.setString(2, (String) values.get("password"));
            preparedStatement.setString(3, (String) values.get("email"));
            preparedStatement.setInt(4, Integer.valueOf((String) values.get("zip")));
            preparedStatement.setString(5, (String) values.get("town"));
            preparedStatement.setString(6, (String) values.get("address"));
            preparedStatement.setInt(7, Integer.valueOf((String) values.get("phone")));
            preparedStatement.setInt(8, userId);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public HashMap getProfile() {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        HashMap values = new HashMap();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_USER);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                values.put("username", resultSet.getString(1));
                values.put("password", resultSet.getString(2));
                values.put("email", resultSet.getString(3));
                values.put("zip", resultSet.getString(4));
                values.put("town", resultSet.getString(5));
                values.put("address", resultSet.getString(6));
                values.put("phone", resultSet.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
