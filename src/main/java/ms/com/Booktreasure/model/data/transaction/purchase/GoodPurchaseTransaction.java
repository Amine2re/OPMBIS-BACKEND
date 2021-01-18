package ms.com.Booktreasure.model.data.transaction.purchase;

import ms.com.Booktreasure.model.data.good.Good;

import javax.persistence.*;

@Entity
public class GoodPurchaseTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Good good;
    @ManyToOne
    private PurchaseTransaction transaction;

    private int total;

}
