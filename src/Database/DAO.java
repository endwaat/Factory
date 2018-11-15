package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO {
    private static String SQL_SELECT_PASSWORD = "SELECT password, id FROM users WHERE username = ? AND deleted = 'f'";
    private static String SQL_UPDATE_USER = "UPDATE users SET username = ?, password = ?, email = ?, zip = ?, town = ?, address = ?, phone = ? WHERE id = ?";
    private static String SQL_INSERT_ALLERGENS = "INSERT INTO allergens (name) VALUES (?)";
    private static String SQL_UPDATE_ALLERGENS = "UPDATE allergens SET name = ? WHERE id = ?";
    private static String SQL_SELECT_USER = "SELECT username, password, email, zip, town, address, phone FROM users WHERE id = ? AND deleted = 'f'";
    private static String SQL_SELECT_ALLERGENS_LIST = "SELECT * FROM allergens WHERE deleted = 'f' ORDER BY name";
    private static String SQL_SELECT_ALLERGENS = "SELECT * FROM allergens WHERE id = ? AND deleted = 'f'";
    private static String SQL_DELETE_ALLERGENS = "DELETE FROM allergens WHERE id = ?";
    private static String SQL_INSERT_USER = "INSERT INTO users (username,password,email,zip,town,address,phone) VALUES (?,?,?,?,?,?,?) RETURNING id";
    private static String SQL_INSERT_AUTHENTICATION = "INSERT INTO authentication (user_id,storage,products,allergen,machines,orders,workers,admin) VALUES (?,?,?,?,?,?,?,?)";
    private static String SQL_UPDATE_AUTHENTICATION = "UPDATE authentication SET storage = ?, products = ?, allergen = ?, machines = ?, orders = ?, workers = ?, admin = ? WHERE user_id = ?";
    private static String SQL_SELECT_USERS_LIST = "SELECT id,username,email,phone FROM users WHERE deleted = 'f' ORDER BY username";
    private static String SQL_SELECT_USER_WITH_AUTHENTICATION = "SELECT users.id,username,password,email,zip,town,address,phone,storage,products,allergen,machines,orders,workers,admin FROM users " +
            "LEFT JOIN authentication ON users.id = authentication.user_id " +
            "WHERE users.id = ? AND users.deleted = 'f'";
    private static String SQL_LOGICAL_DELETE_USER = "UPDATE users SET deleted = 't' WHERE id = ?";
    private static String SQL_INSERT_MACHINE = "INSERT INTO machine (name) VALUES (?)";
    private static String SQL_UPDATE_MACHINE = "UPDATE machine SET name = ? WHERE id = ?";
    private static String SQL_SELECT_MACHINE_LIST = "SELECT id,name FROM machine WHERE deleted = 'f' ORDER BY name";
    private static String SQL_SELECT_MACHINE = "SELECT id,name FROM machine WHERE id = ? AND deleted = 'f'";
    private static String SQL_DELETE_MACHINE = "DELETE FROM machine WHERE id = ?";


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
                    userId = resultSet.getInt(2);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public boolean saveAllergens(HashMap values) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if (0 == (Integer) values.get("id")) {
                preparedStatement = connection.prepareStatement(SQL_INSERT_ALLERGENS);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.execute();
                return true;
            } else {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_ALLERGENS);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.setInt(2, (Integer) values.get("id"));
                preparedStatement.execute();
                return true;
            }
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

    public List<Map> getAllergensList() {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Map> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALLERGENS_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Map values = new HashMap();
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
                list.add(values);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map getAllergen(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        Map values = new HashMap();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALLERGENS);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;
    }

    public void deleteAllergen(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_ALLERGENS);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean saveUser(Map values) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if (0 == (Integer) values.get("id")) {
                preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
                preparedStatement.setString(1, (String) values.get("username"));
                preparedStatement.setString(2, (String) values.get("password"));
                preparedStatement.setString(3, (String) values.get("email"));
                preparedStatement.setInt(4, Integer.valueOf((String) values.get("zip")));
                preparedStatement.setString(5, (String) values.get("town"));
                preparedStatement.setString(6, (String) values.get("address"));
                preparedStatement.setInt(7, Integer.valueOf((String) values.get("phone")));
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    preparedStatement = connection.prepareStatement(SQL_INSERT_AUTHENTICATION);
                    preparedStatement.setInt(1, id);
                    preparedStatement.setBoolean(2, (Boolean) values.get("storage"));
                    preparedStatement.setBoolean(3, (Boolean) values.get("product"));
                    preparedStatement.setBoolean(4, (Boolean) values.get("allergens"));
                    preparedStatement.setBoolean(5, (Boolean) values.get("machine"));
                    preparedStatement.setBoolean(6, (Boolean) values.get("order"));
                    preparedStatement.setBoolean(7, (Boolean) values.get("worker"));
                    preparedStatement.setBoolean(8, (Boolean) values.get("admin"));
                    preparedStatement.execute();
                    return true;
                } else {
                    return false;
                }
            } else {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
                preparedStatement.setString(1, (String) values.get("username"));
                preparedStatement.setString(2, (String) values.get("password"));
                preparedStatement.setString(3, (String) values.get("email"));
                preparedStatement.setInt(4, Integer.valueOf((String) values.get("zip")));
                preparedStatement.setString(5, (String) values.get("town"));
                preparedStatement.setString(6, (String) values.get("address"));
                preparedStatement.setInt(7, Integer.valueOf((String) values.get("phone")));
                preparedStatement.setInt(8, (Integer) values.get("id"));
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement(SQL_UPDATE_AUTHENTICATION);
                preparedStatement.setBoolean(1, (Boolean) values.get("storage"));
                preparedStatement.setBoolean(2, (Boolean) values.get("product"));
                preparedStatement.setBoolean(3, (Boolean) values.get("allergens"));
                preparedStatement.setBoolean(4, (Boolean) values.get("machine"));
                preparedStatement.setBoolean(5, (Boolean) values.get("order"));
                preparedStatement.setBoolean(6, (Boolean) values.get("worker"));
                preparedStatement.setBoolean(7, (Boolean) values.get("admin"));
                preparedStatement.setInt(8, (Integer) values.get("id"));
                preparedStatement.execute();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Map> getUsersList() {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Map> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_USERS_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Map values = new HashMap();
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
                values.put("email", resultSet.getString(3));
                values.put("phone", resultSet.getString(4));
                list.add(values);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map getUser(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        Map values = new HashMap();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_USER_WITH_AUTHENTICATION);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
                values.put("password", resultSet.getString(3));
                values.put("email", resultSet.getString(4));
                values.put("zip", resultSet.getString(5));
                values.put("town", resultSet.getString(6));
                values.put("address", resultSet.getString(7));
                values.put("phone", resultSet.getString(8));
                values.put("storage", resultSet.getString(9));
                values.put("products", resultSet.getString(10));
                values.put("allergen", resultSet.getString(11));
                values.put("machines", resultSet.getString(12));
                values.put("orders", resultSet.getString(13));
                values.put("workers", resultSet.getString(14));
                values.put("admin", resultSet.getString(15));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;
    }

    public void deleteUser(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_LOGICAL_DELETE_USER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean saveMachine(Map values) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if (0 == (Integer) values.get("id")) {
                preparedStatement = connection.prepareStatement(SQL_INSERT_MACHINE);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.execute();
                return true;
            } else {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_MACHINE);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.setInt(2, (Integer) values.get("id"));
                preparedStatement.execute();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Map> getMachineList() {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Map> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_MACHINE_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Map values = new HashMap();
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
                list.add(values);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map getMachine(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        Map values = new HashMap();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_MACHINE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;
    }

    public void deleteMachine(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_MACHINE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
