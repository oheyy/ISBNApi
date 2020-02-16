package com.daniel.isbntool;

public class StockManagement {
    private ExternalISBNDataService webService;
    private ExternalISBNDataService dataService;

    public void setWebService(ExternalISBNDataService webService) {
        this.webService = webService;
    }

    public void setDataService(ExternalISBNDataService dataService) {
        this.dataService = dataService;
    }

    public String getLocatorCode(String isbn) {
        BookDetails book = dataService.retrieveBookDetails(isbn);
        if(null == book){
            book = webService.retrieveBookDetails(isbn);
        }
        return isbn.substring(isbn.length()-4, isbn.length()) + book.getBookAuthor().charAt(0) + book.getBookTitle().split(" ").length;
    }
}
