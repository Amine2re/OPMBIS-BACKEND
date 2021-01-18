package ms.com.Booktreasure.model.data.book.book;

import lombok.*;
import ms.com.Booktreasure.model.data.Warehouse.warehouse.Warehouse;
import ms.com.Booktreasure.model.data.book.category.BSubCategory;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private String title;

    @ManyToOne
    private BSubCategory subCategory;

    @ManyToOne
    private Author author;
    
    @ManyToOne
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name="idW")
    private Warehouse warehouse;
    
    @Lob
    private String description;

    private int price;

    private LocalDate publicationDate;

    public Book( String title, BSubCategory subCategory, Author author, Publisher publisher, Warehouse warehouse, String description, int price, LocalDate publicationDate) {
        this.title = title;
        this.subCategory = subCategory;
        this.author = author;
        this.publisher = publisher;
        this.warehouse = warehouse;
        this.description = description;
        this.price = price;
        this.publicationDate = publicationDate;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BSubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(BSubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}
