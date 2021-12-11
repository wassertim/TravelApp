package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import model.BaseModel;
import model.Parameter;

public abstract class BaseDao<T extends BaseModel> {
    // JDBC driver name and database URL
    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/m151";

    // Database credentials
    //	final String USER = "root";
    //	final String PASS = "";

    // Database credentials
    final String USER = "user";
    final String PASS = "password";

    protected Connection createConnection() throws ClassNotFoundException, SQLException {
        // Register JDBC driver
        Class.forName(JDBC_DRIVER);

        // Open a connection
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public T getById(int id) {
        T returnableObject = null;

        try {
            Connection connection = createConnection();
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM " + getTableName() + " WHERE id=?;");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                returnableObject = map(resultSet);
            }

        } catch (Exception exception) {
            System.out.println(exception);
        }

        return returnableObject;
    }

    public ArrayList<T> getAll() {
        return getAll(null);
    }

    public ArrayList<T> getAll(Parameter param) {
        ArrayList<T> objectListe = new ArrayList<T>();

        try {
            Connection connection = createConnection();
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM %s", getTableName());
            query = addParam(query, param);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                T listObject = map(resultSet);
                objectListe.add(listObject);
            }

        } catch (Exception exception) {
            System.out.println(exception);
        }

        return objectListe;
    }

    public void deleteById(int id) {
        try {
            Connection connection = createConnection();
            PreparedStatement statement = connection.prepareStatement(String.format(
                "DELETE FROM %s WHERE id=?;",
                getTableName()
            ));
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private String addParam(String query, Parameter param) {
        if (param == null) {
            return query;
        }

        return String.format("%s WHERE `%s`='%s'", query, param.getKey(), param.getValue());
    }

    protected abstract T map(ResultSet resultSet) throws SQLException;

    protected abstract String getTableName();
}
