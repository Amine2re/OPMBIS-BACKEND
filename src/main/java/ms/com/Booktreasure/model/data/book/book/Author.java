package ms.com.Booktreasure.model.data.book.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ms.com.Booktreasure.model.data.localization.City;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fName;
    private String lName;

    private String phone;
    private String zip;

    @ManyToOne
    private City city;
    @Lob
    private String address;

    @Lob
    private String contract;

    @OneToMany
    @JoinColumn(name ="id")
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    @CreationTimestamp
    private Date created;

    public Author(String fName, String lName, String phone, String address, String contract) {
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.address = address;
        this.contract = contract;
    }

    public Author() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
