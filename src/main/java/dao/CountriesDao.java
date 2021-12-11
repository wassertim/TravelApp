package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Country;

public class CountriesDao extends BaseDao<Country> {
    @Override protected Country map(ResultSet resultSet) throws SQLException {
        return new Country(resultSet.getInt(1), resultSet.getString(2));
    }

    public void add(Country country) {
        try {
            Connection connection = createConnection();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO countries (title) VALUES ('" + country.getTitle() + "');");
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    @Override protected String getTableName() {
        return "countries";
    }

    public void update(int id, String title) {
        try {
            Connection connection = createConnection();
            PreparedStatement statement = connection.prepareStatement(String.format(
                "UPDATE %s SET title=? WHERE id=?;",
                getTableName()
            ));
            statement.setString(1, title);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
