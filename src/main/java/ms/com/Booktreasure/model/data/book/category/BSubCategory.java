package ms.com.Booktreasure.model.data.book.category;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private BCategory category;

    private String name;
    @Lob
    private String description;

    @CreationTimestamp
    private Date created;

}
