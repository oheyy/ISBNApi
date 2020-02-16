package com.daniel.isbntool;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StockManagemenTest {
    private StockManagement stockManagement;
    @Mock
    private ExternalISBNDataService dataService;

    @Mock
    private ExternalISBNDataService webService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        stockManagement = new StockManagement();
        stockManagement.setWebService(webService);
        stockManagement.setDataService(dataService);
    }
    @Test
    public void testCanGetACorrectLocatorCodeFromDb(){
        BookDetails bookDetails = new BookDetails("Of Mice and Men", "Josn Steinbeck");
        String ISBN = "0140177396";
        Mockito.when(dataService.retrieveBookDetails(ISBN)).thenReturn(bookDetails);
        String locatorCode = stockManagement.getLocatorCode(ISBN);
        assertEquals("7396J4", locatorCode);
        verify(dataService, times(1)).retrieveBookDetails(ISBN);
        verify(webService, times(0)).retrieveBookDetails(ISBN);
    }
    @Test
    public void testCanGetACorrectLocatorCodeFromWebService(){
        BookDetails bookDetails = new BookDetails("Of Mice and Men", "Josn Steinbeck");
        String ISBN = "0140177396";
        Mockito.when(dataService.retrieveBookDetails(ISBN)).thenReturn(null);
        Mockito.when(webService.retrieveBookDetails(ISBN)).thenReturn(bookDetails);
        String locatorCode = stockManagement.getLocatorCode(ISBN);
        assertEquals("7396J4", locatorCode);
        verify(dataService, times(1)).retrieveBookDetails(ISBN);
        verify(webService, times(1)).retrieveBookDetails(ISBN);
    }
}
