package com.daniel.isbntool;

public class BookDetails {
    private String isbn;
    public String bookTitle;
    public String bookAuthor;

    public BookDetails(){}

    public BookDetails(String bookTitle, String bookAuthor){
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }



}
