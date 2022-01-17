package HW_3;

public class Test {
    public static void main(String[] args) {
        QueryUtil queryUtil = new QueryUtil();
        System.out.println("SELECT * from dbo.CountriesTable");
        System.out.println(queryUtil.getAllCountries());
        System.out.println();
        System.out.println("SELECT SongName, SongGenre from dbo.SongsTable");
        System.out.println(queryUtil.getAllSongs());
        System.out.println();
        System.out.println("SELECT * from dbo.BandsTable WHERE BandName LIKE '%e%'");
        System.out.println(queryUtil.getBandsContainingE());
        System.out.println();
        System.out.println("SELECT CountryName, CountryPopulation FROM dbo.CountriesTable WHERE CountryPopulation<? AND CountryName LIKE ?");
        System.out.println(queryUtil.getCountriesByPopulationAndName(100000000, "%e%"));
        System.out.println();
        System.out.println("SELECT SongID, SongName FROM SongsTable WHERE SongID%2=0");
        System.out.println(queryUtil.getSongsWithOddID());

        queryUtil.closeConnection();
    }
}
