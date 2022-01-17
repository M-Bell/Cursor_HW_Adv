package HW_3.model;

import lombok.Data;

@Data
public class Bands {
    private int id;
    private String name;
    private Integer creationDate;

    public Bands(int id, String name, int creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }
}
