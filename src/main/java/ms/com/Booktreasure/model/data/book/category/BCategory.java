package ms.com.Booktreasure.model.data.book.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class BCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    private String name;
    @Lob
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<BSubCategory> subCategories;

    @CreationTimestamp
    private Date created;

}
