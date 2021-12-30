package HW_3;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        QueryUtil queryUtil = new QueryUtil();
        System.out.println("SELECT * from dbo.CountriesTable");
        System.out.println(queryUtil.firstQuery());
        System.out.println();
        System.out.println("SELECT SongName, SongGenre from dbo.SongsTable");
        System.out.println(queryUtil.secondQuery());
        System.out.println();
        System.out.println("SELECT * from dbo.BandsTable WHERE BandName LIKE '%e%'");
        System.out.println(queryUtil.thirdQuery());
        System.out.println();
        System.out.println("SELECT CountryName, CountryPopulation FROM dbo.CountriesTable WHERE CountryPopulation<? AND CountryName LIKE ?");
        System.out.println(queryUtil.fourthQuery(100000000, "e"));
        System.out.println();
        System.out.println("SELECT SongID, SongName FROM SongsTable WHERE SongID%2=0");
        System.out.println(queryUtil.fifthQuery());

        queryUtil.closeConnection();
    }
}
