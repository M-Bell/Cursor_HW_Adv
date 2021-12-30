package HW_3.Tables;

import lombok.Data;

@Data
public class CountriesTable {
    private int id;
    private String name;
    private int population;

    public CountriesTable(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }
}
