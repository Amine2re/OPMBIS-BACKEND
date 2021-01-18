package ms.com.Booktreasure.model.data.transaction.order;

import ms.com.Booktreasure.model.data.good.Good;

import javax.persistence.*;

@Entity
public class GoodOrderTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Good good;
    @ManyToOne
    private OrderTransaction transaction;

    private int total;

}
