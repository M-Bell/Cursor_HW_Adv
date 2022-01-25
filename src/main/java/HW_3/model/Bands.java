package HW_3.model;

import lombok.Data;

@Data
public class Bands {
    private final int id;
    private final String name;
    private final Integer creationDate;

    public Bands(int id, String name, int creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }
}
