package ms.com.Booktreasure.model.data.transaction.purchase;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ms.com.Booktreasure.model.data.Warehouse.warehouse.Warehouse;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class PurchaseTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date purchaseDate;

    @ManyToOne
    private Warehouse warehouse;

    @OneToMany(mappedBy = "transaction")
    @JsonIgnore
    private List<BookPurchaseTransaction> books;

    @OneToMany(mappedBy = "transaction")
    @JsonIgnore
    private List<GoodPurchaseTransaction> goods;

}
