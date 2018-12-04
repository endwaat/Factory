package Database;

import com.sun.java.accessibility.util.GUIInitializedListener;

import java.io.Serializable;
import java.sql.*;
import java.sql.Date;
import java.util.*;

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
    private static String SQL_INSERT_INGREDIENT_TYPE = "INSERT INTO ingredient_type (name,allergens_id) VALUES (?,?)";
    private static String SQL_UPDATE_INGREDIENT_TYPE = "UPDATE ingredient_type SET name = ?, allergens_id = ? WHERE id = ?";
    private static String SQL_SELECT_INGREDIENT_TYPE_LIST = "SELECT id,name FROM ingredient_type WHERE deleted = 'f' ORDER BY name";
    private static String SQL_SELECT_INGREDIENT_TYPE = "SELECT id,name,allergens_id FROM ingredient_type WHERE id = ? AND deleted = 'f'";
    private static String SQL_DELETE_INGREDIENT_TYPE = "DELETE FROM ingredient_type WHERE id = ?";
    private static String SQL_INSERT_INGREDIENT = "INSERT INTO ingredient (name,ingredient_type_id,arrived,expire,weight,source,value) VALUES (?,?,?,?,?,?,?)";
    private static String SQL_UPDATE_INGREDIENT = "UPDATE ingredient SET name = ?, ingredient_type_id = ?, arrived = ?, expire = ?, weight = ?, source = ?, value = ?  WHERE id = ?";
    private static String SQL_SELECT_INGREDIENT_LIST = "SELECT id,name,ingredient_type_id,arrived,expire,weight FROM ingredient WHERE deleted = 'f' ORDER BY name";
    private static String SQL_SELECT_INGREDIENT = "SELECT id,name,ingredient_type_id,arrived,expire,weight,source,value FROM ingredient WHERE id = ? AND deleted = 'f'";
    private static String SQL_DELETE_INGREDIENT = "UPDATE ingredient SET deleted = 't' WHERE id = ?";
    private static String SQL_INSERT_SUPPLIER = "INSERT INTO supplier (name,phone,zip,town,address) VALUES (?,?,?,?,?)";
    private static String SQL_UPDATE_SUPPLIER = "UPDATE supplier SET name = ?, phone = ?, zip = ?, town = ?, address = ? WHERE id = ?";
    private static String SQL_SELECT_SUPPLIER_LIST = "SELECT id,name,phone FROM supplier WHERE deleted = 'f' ORDER BY name";
    private static String SQL_SELECT_SUPPLIER = "SELECT id,name,phone,zip,town,address FROM supplier WHERE id = ? AND deleted = 'f'";
    private static String SQL_DELETE_SUPPLIER = "UPDATE supplier SET deleted = 't' WHERE id = ?";
    private static String SQL_INSERT_WORKER = "INSERT INTO workers (name,barcode,email,salary,zip,town,address,phone) VALUES (?,?,?,?,?,?,?,?)";
    private static String SQL_UPDATE_WORKER = "UPDATE workers SET name = ?, barcode = ?, email = ?, salary = ?, zip = ?, town = ?, address = ?, phone = ? WHERE id = ?";
    private static String SQL_SELECT_WORKER_LIST = "SELECT id,name,barcode,email,salary,zip,town,address,phone FROM workers WHERE deleted = 'f' ORDER BY name";
    private static String SQL_SELECT_WORKER = "SELECT id,name,barcode,email,salary,zip,town,address,phone FROM workers WHERE id = ? AND deleted = 'f'";
    private static String SQL_DELETE_WORKER = "UPDATE workers SET name = ?, email = ?, address = ?, phone = null, deleted = 't' WHERE id = ?";
    private static String SQL_SELECT_WORKER_BY_BARCODE = "SELECT id FROM workers WHERE barcode = ?";
    private static String SQL_INSERT_WORKLOG = "INSERT INTO worklog (worker_id,date,hour) VALUES (?,?,?)";
    private static String SQL_SELECT_WORKLIG_LIST = "SELECT worklog.id,workers.barcode,workers.name,date,hour " +
            "FROM worklog " +
            "LEFT JOIN workers ON worklog.worker_id = workers.id " +
            "WHERE date BETWEEN ? AND ? " +
            "ORDER BY worklog.id";
    private static String SQL_DELETE_WORKLOG = "DELETE FROM worklog WHERE id = ?";
    private static String SQL_SELECT_WORKLOG_BY_WORKERID = "SELECT date,hour FROM worklog WHERE worker_id = ?";
    private static String SQL_SELECT_TRANSLATE = "SELECT value FROM dict WHERE name = ?";
    private static String SQL_SAVE_PRODUCTTYPE = "INSERT INTO product_type (name,allergens_id,weight,production_time,value,cost) VALUES (?,?,?,?,?,?) RETURNING id";
    private static String SQL_INSERT_RECEIPT = "INSERT INTO receipt (product_type_id,ingredient_type_id,value) VALUES (?,?,?)";
    private static String SQL_INSERT_MACHINE_PRODUCT = "INSERT INTO machine_product (machine_id,product_type_id) VALUES (?,?)";
    private static String SQL_UPDATE_PRODUCTTYPE = "UPDATE product_type SET name = ?, allergens_id = ?, weight = ?, production_time = ?, value = ?, cost = ? WHERE id = ?";
    private static String SQL_CLEAR_RECEIPT = "DELETE FROM receipt WHERE product_type_id = ?";
    private static String SQL_CLEAR_MACHINE_PRODUCT = "DELETE FROM machine_product WHERE product_type_id = ?";
    private static String SQL_SELECT_INGREDIENT_BY_PRODUCT = "SELECT ingredient_type_id, name, value " +
            "FROM receipt " +
            "LEFT JOIN ingredient_type ON receipt.ingredient_type_id = ingredient_type.id " +
            "WHERE receipt.product_type_id = ? ";
    private static String SQL_SELECT_MACHINE_BY_PRODUCT = "SELECT machine_id, machine.name " +
            "FROM machine_product " +
            "LEFT JOIN machine ON machine_product.machine_id = machine.id " +
            "WHERE machine_product.product_type_id = ? ";
    private static String SQL_DELETE_PRODUCTTYPE = "UPDATE product_type SET deleted = 't' WHERE id = ?";
    private static String SQL_SELECT_PRODUCTTYPE = "SELECT id,name,allergens_id,weight,production_time,value,cost FROM product_type WHERE id = ? AND deleted = 'f'";
    private static String SQL_SELECT_PRODUCTTYPE_LIST = "SELECT id,name FROM product_type WHERE deleted = 'f' ORDER BY name";
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

    public boolean saveIngredientType(Map values) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if (0 == (Integer) values.get("id")) {
                preparedStatement = connection.prepareStatement(SQL_INSERT_INGREDIENT_TYPE);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.setInt(2, (Integer) values.get("allergensType"));
                preparedStatement.execute();
                return true;
            } else {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_INGREDIENT_TYPE);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.setInt(2, (Integer) values.get("allergensType"));
                preparedStatement.setInt(3, (Integer) values.get("id"));
                preparedStatement.execute();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Map> getIngredientTypeList() {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Map> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_INGREDIENT_TYPE_LIST);
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

    public Map getIngredientType(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        Map values = new HashMap();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_INGREDIENT_TYPE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
                values.put("allergensType", resultSet.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;
    }

    public void deteleIngredientType(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_INGREDIENT_TYPE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean saveIngredient(Map values) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if (0 == (Integer) values.get("id")) {
                preparedStatement = connection.prepareStatement(SQL_INSERT_INGREDIENT);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.setInt(2, (Integer) values.get("type"));
                preparedStatement.setDate(3, new java.sql.Date(((java.util.Date) values.get("arrived")).getTime()));
                preparedStatement.setDate(4, new java.sql.Date(((java.util.Date) values.get("expire")).getTime()));
                preparedStatement.setDouble(5, Double.parseDouble((String) values.get("weight")));
                preparedStatement.setString(6, (String) values.get("source"));
                preparedStatement.setInt(7, (Integer) values.get("value"));
                preparedStatement.execute();
                return true;
            } else {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_INGREDIENT);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.setInt(2, (Integer) values.get("type"));
                preparedStatement.setDate(3, new java.sql.Date(((java.util.Date) values.get("arrived")).getTime()));
                preparedStatement.setDate(4, new java.sql.Date(((java.util.Date) values.get("expire")).getTime()));
                preparedStatement.setDouble(5, Double.parseDouble((String) values.get("weight")));
                preparedStatement.setString(6, (String) values.get("source"));
                preparedStatement.setInt(7, (Integer) values.get("value"));
                preparedStatement.setInt(8, (Integer) values.get("id"));
                preparedStatement.execute();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Map> getIngredientList() {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Map> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_INGREDIENT_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Map values = new HashMap();
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
                values.put("type", resultSet.getInt(3));
                values.put("arrived", resultSet.getDate(4));
                values.put("expire", resultSet.getDate(5));
                values.put("weight", resultSet.getDouble(6));
                list.add(values);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map getIngredient(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        Map values = new HashMap();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_INGREDIENT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
                values.put("ingredient_type_id", resultSet.getInt(3));
                values.put("arrived", resultSet.getDate(4));
                values.put("expire", resultSet.getDate(5));
                values.put("weight", resultSet.getDouble(6));
                values.put("source", resultSet.getString(7));
                values.put("value", resultSet.getInt(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;
    }

    public void deteleIngredient(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_INGREDIENT);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean saveSupplier(Map values) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if (0 == (Integer) values.get("id")) {
                preparedStatement = connection.prepareStatement(SQL_INSERT_SUPPLIER);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.setInt(2, Integer.valueOf((String) values.get("phone")));
                preparedStatement.setInt(3, Integer.valueOf((String) values.get("zip")));
                preparedStatement.setString(4, (String) values.get("town"));
                preparedStatement.setString(5, (String) values.get("address"));
                preparedStatement.execute();
                return true;
            } else {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_SUPPLIER);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.setInt(2, Integer.valueOf((String) values.get("phone")));
                preparedStatement.setInt(3, Integer.valueOf((String) values.get("zip")));
                preparedStatement.setString(4, (String) values.get("town"));
                preparedStatement.setString(5, (String) values.get("address"));
                preparedStatement.setInt(6, (Integer) values.get("id"));
                preparedStatement.execute();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Map> getSupplierList() {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Map> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_SUPPLIER_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Map values = new HashMap();
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
                values.put("phone", resultSet.getInt(3));
                list.add(values);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map getSupplier(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        Map values = new HashMap();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_SUPPLIER);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
                values.put("phone", resultSet.getInt(3));
                values.put("zip", resultSet.getInt(4));
                values.put("town", resultSet.getString(5));
                values.put("address", resultSet.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;
    }

    public void deteleSupplier(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_SUPPLIER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWorker(Map values) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if (0 == (Integer) values.get("id")) {
                preparedStatement = connection.prepareStatement(SQL_INSERT_WORKER);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.setString(2, (String) values.get("barcode"));
                preparedStatement.setString(3, (String) values.get("email"));
                preparedStatement.setInt(4, Integer.parseInt((String) values.get("salary")));
                preparedStatement.setInt(5, Integer.valueOf((String) values.get("zip")));
                preparedStatement.setString(6, (String) values.get("town"));
                preparedStatement.setString(7, (String) values.get("address"));
                preparedStatement.setInt(8, Integer.valueOf((String) values.get("phone")));
                preparedStatement.execute();
                return true;
            } else {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_WORKER);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.setString(2, (String) values.get("barcode"));
                preparedStatement.setString(3, (String) values.get("email"));
                preparedStatement.setInt(4, Integer.valueOf((String) values.get("salary")));
                preparedStatement.setInt(5, Integer.valueOf((String) values.get("zip")));
                preparedStatement.setString(6, (String) values.get("town"));
                preparedStatement.setString(7, (String) values.get("address"));
                preparedStatement.setInt(8, Integer.valueOf((String) values.get("phone")));
                preparedStatement.setInt(9, (Integer) values.get("id"));
                preparedStatement.execute();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Map> getWorkerList() {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Map> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_WORKER_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Map values = new HashMap();
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
                values.put("barcode", resultSet.getString(3));
                values.put("email", resultSet.getString(4));
                values.put("salary", resultSet.getInt(5));
                values.put("zip", resultSet.getInt(6));
                values.put("town", resultSet.getString(7));
                values.put("address", resultSet.getString(8));
                values.put("phone", resultSet.getInt(9));
                list.add(values);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map getWorker(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        Map values = new HashMap();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_WORKER);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
                values.put("barcode", resultSet.getString(3));
                values.put("email", resultSet.getString(4));
                values.put("salary", resultSet.getInt(5));
                values.put("zip", resultSet.getInt(6));
                values.put("town", resultSet.getString(7));
                values.put("address", resultSet.getString(8));
                values.put("phone", resultSet.getInt(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;
    }

    public void deleteWorker(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_WORKER);
            String uuid = UUID.randomUUID().toString();
            preparedStatement.setString(1, uuid);
            preparedStatement.setString(2, uuid);
            preparedStatement.setString(3, uuid);
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Serializable savePresence(Map values) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_WORKER_BY_BARCODE);
            preparedStatement.setString(1, (String) values.get("barcode"));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                preparedStatement = connection.prepareStatement(SQL_INSERT_WORKLOG);
                preparedStatement.setInt(1, id);
                preparedStatement.setDate(2, new java.sql.Date(((java.util.Date) values.get("date")).getTime()));
                preparedStatement.setInt(3, (Integer) values.get("hour"));
                preparedStatement.execute();
                return "SUCCES";
            } else {
                return "UNKNOWN_BARCODE";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "SAVE_ERROR";
        }
    }

    public List<Map> getPresenceList(Map mapDates) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Map> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_WORKLIG_LIST);
            preparedStatement.setDate(1, new java.sql.Date(((java.util.Date) mapDates.get("from")).getTime()));
            preparedStatement.setDate(2, new java.sql.Date(((java.util.Date) mapDates.get("to")).getTime()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Map values = new HashMap();
                values.put("id", resultSet.getInt(1));
                values.put("barcode", resultSet.getString(2));
                values.put("name", resultSet.getString(3));
                values.put("date", resultSet.getDate(4));
                values.put("hour", resultSet.getInt(5));
                list.add(values);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deletePresence(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_WORKLOG);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Map> getWorkersLog(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Map> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_WORKLOG_BY_WORKERID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Map values = new HashMap();
                values.put("date", resultSet.getDate(1));
                values.put("hour", resultSet.getInt(2));
                list.add(values);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Serializable saveProductType(Map values) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if (0 == (Integer) values.get("id")) {
                preparedStatement = connection.prepareStatement(SQL_SAVE_PRODUCTTYPE);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.setInt(2, (Integer) values.get("allergensType"));
                preparedStatement.setInt(3, Integer.parseInt((String) values.get("weight")));
                preparedStatement.setInt(4, Integer.parseInt((String) values.get("productionTime")));
                preparedStatement.setInt(5, Integer.parseInt((String) values.get("value")));
                preparedStatement.setInt(6, Integer.parseInt((String) values.get("cost")));
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    preparedStatement = connection.prepareStatement(SQL_INSERT_RECEIPT);
                    List ingredients = (List) values.get("ingredients");
                    for (int i = 0; i < ingredients.size(); i++) {
                        preparedStatement.setInt(1, id);
                        preparedStatement.setInt(2, (Integer) ((Map) ingredients.get(i)).get("id"));
                        preparedStatement.setDouble(3, (double) ((Map) ingredients.get(i)).get("value"));
                        preparedStatement.addBatch();
                        preparedStatement.clearParameters();
                    }
                    preparedStatement.executeBatch();
                    preparedStatement = connection.prepareStatement(SQL_INSERT_MACHINE_PRODUCT);
                    List machines = (List) values.get("machines");
                    for (int i = 0; i < machines.size(); i++) {
                        preparedStatement.setInt(1, (Integer) ((Map) ingredients.get(i)).get("id"));
                        preparedStatement.setInt(2, id);
                        preparedStatement.addBatch();
                        preparedStatement.clearParameters();
                    }
                    preparedStatement.executeBatch();
                    return "SUCCES";
                }
            } else {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_PRODUCTTYPE);
                preparedStatement.setString(1, (String) values.get("name"));
                preparedStatement.setInt(2, (Integer) values.get("allergensType"));
                preparedStatement.setInt(3, Integer.parseInt((String) values.get("weight")));
                preparedStatement.setInt(4, Integer.parseInt((String) values.get("productionTime")));
                preparedStatement.setInt(5, Integer.parseInt((String) values.get("value")));
                preparedStatement.setInt(6, Integer.parseInt((String) values.get("cost")));
                preparedStatement.setInt(7, (Integer) values.get("id"));
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement(SQL_CLEAR_RECEIPT);
                preparedStatement.setInt(1, (Integer) values.get("id"));
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement(SQL_CLEAR_MACHINE_PRODUCT);
                preparedStatement.setInt(1, (Integer) values.get("id"));
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement(SQL_INSERT_RECEIPT);
                List ingredients = (List) values.get("ingredients");
                for (int i = 0; i < ingredients.size(); i++) {
                    preparedStatement.setInt(1, (Integer) values.get("id"));
                    preparedStatement.setInt(2, (Integer) ((Map) ingredients.get(i)).get("id"));
                    preparedStatement.setDouble(3, (double) ((Map) ingredients.get(i)).get("value"));
                    preparedStatement.addBatch();
                    preparedStatement.clearParameters();
                }
                preparedStatement.executeBatch();
                preparedStatement = connection.prepareStatement(SQL_INSERT_MACHINE_PRODUCT);
                List machines = (List) values.get("machines");
                for (int i = 0; i < machines.size(); i++) {
                    preparedStatement.setInt(1, (Integer) ((Map) ingredients.get(i)).get("id"));
                    preparedStatement.setInt(2, (Integer) values.get("id"));
                    preparedStatement.addBatch();
                    preparedStatement.clearParameters();
                }
                preparedStatement.executeBatch();
                return "SUCCES";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "SAVE_ERROR";
    }

    public List<Map> getIngredientlistByproductId(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Map> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_INGREDIENT_BY_PRODUCT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Map values = new HashMap();
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
                values.put("value", resultSet.getDouble(3));
                list.add(values);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map> getMachinesByproductId(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Map> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_MACHINE_BY_PRODUCT);
            preparedStatement.setInt(1, id);
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

    public void deleteProductType(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_PRODUCTTYPE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map getProductType(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        Map values = new HashMap();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_PRODUCTTYPE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //id,name,allergens_id,weight,production_time,value,cost
                values.put("id", resultSet.getInt(1));
                values.put("name", resultSet.getString(2));
                values.put("allergensType", resultSet.getInt(3));
                values.put("weight", resultSet.getInt(4));
                values.put("productionTime", resultSet.getInt(5));
                values.put("value", resultSet.getInt(6));
                values.put("cost", resultSet.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;
    }

    public List<Map> getProductTypeList() {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Map> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_PRODUCTTYPE_LIST);
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

    public String translate(String value) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_TRANSLATE);
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }
}
