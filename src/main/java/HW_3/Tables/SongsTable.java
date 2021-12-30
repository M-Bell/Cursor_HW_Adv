package HW_3.Tables;

import lombok.Data;

@Data
public class SongsTable {
    private int id;
    private String name;
    private String genre;

    public SongsTable(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }
}
