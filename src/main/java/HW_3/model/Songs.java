package HW_3.model;

import lombok.Data;

@Data
public class Songs {
    private int id;
    private String name;
    private String genre;

    public Songs(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public Songs(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
