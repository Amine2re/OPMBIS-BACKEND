package ms.com.Booktreasure.model.data.book.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ms.com.Booktreasure.model.data.localization.City;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
    private List<Book> books;

    @CreationTimestamp
    private Date created;


    private LocalDate dateTest;

}
