package ms.com.Booktreasure.model.data.transaction.order;

import ms.com.Booktreasure.model.data.book.book.Book;

import javax.persistence.*;

@Entity
public class BookOrderTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Book book;
    @ManyToOne
    private OrderTransaction transaction;

    private int total;

}
