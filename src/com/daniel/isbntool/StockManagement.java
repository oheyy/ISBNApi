package com.daniel.isbntool;

public class StockManagement {
    private ExternalISBNDataService service;

    public void setService(ExternalISBNDataService service) {
        this.service = service;
    }
    public String getLocatorCode(String isbn) {
        BookDetails book = service.retrieveBookDetails(isbn);
        return isbn.substring(isbn.length()-4, isbn.length()) + book.getBookAuthor().charAt(0) + book.getBookTitle().split(" ").length;
    }
}
