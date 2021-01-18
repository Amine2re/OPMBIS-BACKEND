package ms.com.Booktreasure.model.data.good;

import lombok.Data;
import ms.com.Booktreasure.model.data.Warehouse.warehouse.Warehouse;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Data
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @Lob
    private String description;

    private int price;

    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(name="idW",referencedColumnName = "idWarehouse")
    Warehouse warehouse;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
