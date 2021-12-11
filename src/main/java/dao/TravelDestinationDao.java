package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.TravelDestination;

public class TravelDestinationDao extends BaseDao<TravelDestination> {
    @Override protected TravelDestination map(ResultSet resultSet) throws SQLException {
        return new TravelDestination(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
    }

    @Override protected String getTableName() {
        return "travel_destination";
    }

    public void addVisitedCountries(String userName, String[] countryIds) {
        try {
            Connection connection = createConnection();
            Statement statement = connection.createStatement();
            for (String countryId : countryIds) {
                statement.execute(
                    String.format(
                        "INSERT INTO %s (benutzer, country_id) VALUES ('%s', '%s');",
                        getTableName(),
                        userName,
                        countryId
                    )
                );
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
