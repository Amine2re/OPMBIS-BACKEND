package ms.com.Booktreasure.model.data.transaction.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ms.com.Booktreasure.model.data.Warehouse.supplier.Supplier;
import ms.com.Booktreasure.model.data.Warehouse.warehouse.Warehouse;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class OrderTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    
    
    @ManyToOne
    private Warehouse warehouse;

    private Date orderDate;

    @OneToMany(mappedBy = "transaction")
    @JsonIgnore
    private List<BookOrderTransaction> books;

    @OneToMany(mappedBy = "transaction")
    @JsonIgnore
    private List<GoodOrderTransaction> goods;

    /**
     * 0 = discount int percentage
     * 1 = discount int amount
     */
    private int discountType;
    private int discountValue;

}
