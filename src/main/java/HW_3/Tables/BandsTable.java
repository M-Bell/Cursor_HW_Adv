package HW_3.Tables;

import lombok.Data;

@Data
public class BandsTable {
    private int id;
    private String name;
    private Integer creationDate;

    public BandsTable(int id, String name, int creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }
}
