package ms.com.Booktreasure.model.data.transaction.purchase;

import ms.com.Booktreasure.model.data.book.book.Book;

import javax.persistence.*;

@Entity
public class BookPurchaseTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Book book;
    @ManyToOne
    private PurchaseTransaction transaction;

    private int total;

}
