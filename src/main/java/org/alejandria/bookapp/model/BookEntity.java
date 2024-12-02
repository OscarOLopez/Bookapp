package org.alejandria.bookapp.model;

import jakarta.persistence.*;
import org.hibernate.mapping.Set;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "price",nullable = false,precision = 6,scale = 2)
    private BigDecimal price;

    @Column(name = "cost",nullable = false,precision = 6,scale = 2)
    private BigDecimal cost;

    @Column(name ="author",length = 50,nullable = false)
    private String author;

    @Column(name ="isbn",length = 15)
    private String isbn;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "publisher",length = 45, nullable = false)
    private String publisher;

    @Column(name = "date_published")
    private Date datePublished;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "stock",nullable = false)
    private Integer stock = 1;

    @Column(name = "language" )
    private String language = "Español";

    @Column(name = "format")
    private Set format;

    @Column(name = "description")
    private String description;

    @Column(name = "cover_img")
    private String coverImg;
    
    @Column(name = "category")
    private String category;

    public BookEntity(Long bookId, BigDecimal price, BigDecimal cost, String author, String isbn, String title, String publisher, Date datePublished, Integer pageCount, Integer stock, String language, Set format, String description, String coverImg, String category) {
        this.bookId = bookId;
        this.price = price;
        this.cost = cost;
        this.author = author;
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.pageCount = pageCount;
        this.stock = stock;
        this.language = language;
        this.format = format;
        this.description = description;
        this.coverImg = coverImg;
        this.category = category;
    }

    public BookEntity() {

    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Set getFormat() {
        return format;
    }

    public void setFormat(Set format) {
        this.format = format;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "bookId=" + bookId +
                ", price=" + price +
                ", cost=" + cost +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", datePublished=" + datePublished +
                ", pageCount=" + pageCount +
                ", stock=" + stock +
                ", language='" + language + '\'' +
                ", format=" + format +
                ", description='" + description + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
