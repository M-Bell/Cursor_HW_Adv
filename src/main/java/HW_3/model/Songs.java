package HW_3.model;

import lombok.Data;

@Data
public class Songs {
    private final int id;
    private final String name;
    private final String genre;

    public Songs(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public Songs(int id, String name) {
        this.id = id;
        this.name = name;
        genre = null;
    }
}
