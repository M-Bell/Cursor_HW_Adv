package HW_3;

import HW_3.model.Bands;
import HW_3.model.Countries;
import HW_3.model.Songs;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryUtil {
    private static final String DB_URL = "jdbc:sqlserver://localhost";
    private static final String USER = "admin";
    private static final String PASS = "admin";


    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new SQLServerDriver());
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }


    public List<Countries> getAllCountries() {
        List<Countries> countryList = new ArrayList<>();
        final String sql = "SELECT id, name, population from dbo.CountriesTable";
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                countryList.add(new Countries(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getInt("population")));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countryList;
    }

    public List<Songs> getAllSongs() {
        List<Songs> songsList = new ArrayList<>();
        final String sql = "SELECT name, genre from dbo.SongsTable";
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                songsList.add(new Songs(0, resultSet.getString("name"),
                        resultSet.getString("genre")));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songsList;
    }

    public List<Bands> getBandsContainingE() {
        List<Bands> bandsList = new ArrayList<>();
        final String sql = "SELECT id, name, creation_date from dbo.BandsTable WHERE name LIKE '%e%'";
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                bandsList.add(new Bands(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("creation_date")));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bandsList;
    }

    public List<Countries> getCountriesByPopulationAndName(int population, String countryName) {
        List<Countries> countryList = new ArrayList<>();
        final String sql = "SELECT name, population FROM dbo.CountriesTable WHERE population<? AND name LIKE ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(2, countryName);
            preparedStatement.setInt(1, population);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                countryList.add(new Countries(
                        resultSet.getInt(0),
                        resultSet.getString("name"),
                        resultSet.getInt("population")));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countryList;
    }

    public List<Songs> getSongsWithEvenID() {
        List<Songs> songsList = new ArrayList<>();
        final String sql = "SELECT id, name FROM SongsTable WHERE id%2=0";
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                songsList.add(new Songs(
                        resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songsList;
    }

    public void closeConnection() {
        try {
            getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
