package org.cqipc.books.bean;

public class Tb_Books {
    private int id;
    private String ISBN;
    private String book_name;
    private double book_price;
    private String book_author;
    private String published_house;
    private Tb_Books_Type bookCategory;

    public Tb_Books() {
    }

    public Tb_Books(int id, String ISBN, String book_name, double book_price, String book_author, String published_house, Tb_Books_Type bookCategory) {
        this.id = id;
        this.ISBN = ISBN;
        this.book_name = book_name;
        this.book_price = book_price;
        this.book_author = book_author;
        this.published_house = published_house;
        this.bookCategory = bookCategory;
    }

    public Tb_Books(String ISBN, String book_name, double book_price, String book_author, String published_house, Tb_Books_Type bookCategory) {
        this.ISBN = ISBN;
        this.book_name = book_name;
        this.book_price = book_price;
        this.book_author = book_author;
        this.published_house = published_house;
        this.bookCategory = bookCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public double getBook_price() {
        return book_price;
    }

    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getPublished_house() {
        return published_house;
    }

    public void setPublished_house(String published_house) {
        this.published_house = published_house;
    }

    public Tb_Books_Type getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(Tb_Books_Type bookCategory) {
        this.bookCategory = bookCategory;
    }

    @Override
    public String toString() {
        return "Tb_Books [id=" + id + ", ISBN=" + ISBN + ", book_name=" + book_name + ", book_price=" + book_price + ", book_author=" + book_author + ", published_house=" + published_house + ", bookCategory=" + bookCategory + "]";
    }
}
