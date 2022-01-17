package HW_3;

import HW_3.model.Bands;
import HW_3.model.Countries;
import HW_3.model.Songs;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryUtil {
    static final String DB_URL = "jdbc:sqlserver://localhost";
    static final String USER = "admin";
    static final String PASS = "admin";

    private Connection connection;

    public QueryUtil() {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Countries> getAllCountries() {
        List<Countries> countryList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT CountryID, CountryName, CountryPopulation from dbo.CountriesTable");
            while (resultSet.next()) {
                countryList.add(new Countries(resultSet.getInt("CountryID"),
                        resultSet.getString("CountryName"), resultSet.getInt("CountryPopulation")));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countryList;
    }

    public List<Songs> getAllSongs() {
        List<Songs> songsList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SongName, SongGenre from dbo.SongsTable");
            while (resultSet.next()) {
                songsList.add(new Songs(0, resultSet.getString("SongName"),
                        resultSet.getString("SongGenre")));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songsList;
    }

    public List<Bands> getBandsContainingE() {
        List<Bands> bandsList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT BandID, BandName, BandCreationDate from dbo.BandsTable WHERE BandName LIKE '%e%'");
            while (resultSet.next()) {
                bandsList.add(new Bands(resultSet.getInt("BandID"),
                        resultSet.getString("BandName"), resultSet.getInt("BandCreationDate")));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bandsList;
    }

    public List<Countries> getCountriesByPopulationAndName(int population, String stringValue) {
        List<Countries> countryList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT CountryName, CountryPopulation FROM dbo.CountriesTable " +
                            "WHERE CountryPopulation<? AND CountryName LIKE ?");
            preparedStatement.setString(2, stringValue);
            preparedStatement.setInt(1, population);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                countryList.add(new Countries(0, resultSet.getString("CountryName"),
                        resultSet.getInt("CountryPopulation")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countryList;
    }

    public List<Songs> getSongsWithEvenID() {
        List<Songs> songsList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SongID, SongName FROM SongsTable WHERE SongID%2=0");
            while (resultSet.next()) {
                songsList.add(new Songs(resultSet.getInt("SongID"),
                        resultSet.getString("SongName")));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songsList;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
