package HW_3.model;

import lombok.Data;

@Data
public class Countries {
    private final int id;
    private final String name;
    private final int population;

    public Countries(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }
}
