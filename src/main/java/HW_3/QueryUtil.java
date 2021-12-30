package HW_3;

import HW_3.Tables.BandsTable;
import HW_3.Tables.CountriesTable;
import HW_3.Tables.SongsTable;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.*;
import java.util.ArrayList;

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

    public ArrayList<CountriesTable> firstQuery() throws SQLException {
        ArrayList<CountriesTable> countryList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from dbo.CountriesTable");
        while (resultSet.next()) {
            countryList.add(new CountriesTable(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
        }
        resultSet.close();
        statement.close();
        return countryList;
    }

    public ArrayList<SongsTable> secondQuery() throws SQLException {
        ArrayList<SongsTable> songsList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT SongName, SongGenre from dbo.SongsTable");
        while (resultSet.next()) {
            songsList.add(new SongsTable(0, resultSet.getString(1), resultSet.getString(2)));
        }
        resultSet.close();
        statement.close();
        return songsList;
    }

    public ArrayList<BandsTable> thirdQuery() throws SQLException {
        ArrayList<BandsTable> bandsList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from dbo.BandsTable WHERE BandName LIKE '%e%'");
        while (resultSet.next()) {
            bandsList.add(new BandsTable(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
        }
        resultSet.close();
        statement.close();
        return bandsList;
    }

    public ArrayList<CountriesTable> fourthQuery(int population, String stringValue) throws SQLException {
        ArrayList<CountriesTable> countryList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT CountryName, CountryPopulation FROM dbo.CountriesTable WHERE CountryPopulation<? AND CountryName LIKE ?");
        preparedStatement.setString(2, "%" + stringValue + "%");
        preparedStatement.setInt(1, population);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            countryList.add(new CountriesTable(0, resultSet.getString(1), resultSet.getInt(2)));
        }
        resultSet.close();
        preparedStatement.close();
        return countryList;
    }

    public ArrayList<SongsTable> fifthQuery() throws SQLException {
        ArrayList<SongsTable> songsList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT SongID, SongName FROM SongsTable WHERE SongID%2=0");
        while (resultSet.next()) {
            songsList.add(new SongsTable(resultSet.getInt(1), resultSet.getString(2), "|none|"));
        }
        resultSet.close();
        statement.close();
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
