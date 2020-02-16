package com.daniel.isbntool;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class StockManagemenTest {
    private StockManagement stockManagement;
    @Mock
    private ExternalISBNDataService externalISBNDataService;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        stockManagement = new StockManagement();
    }
    @Test
    public void testCanGetACorrectLocatorCode(){
        BookDetails bookDetails = new BookDetails("Of Mice and Men", "Josn Steinbeck");
        String ISBN = "0140177396";
        Mockito.when(externalISBNDataService.retrieveBookDetails(ISBN)).thenReturn(bookDetails);
        stockManagement.setService(externalISBNDataService);
        String locatorCode = stockManagement.getLocatorCode(ISBN);
        assertEquals("7396J4", locatorCode);
    }
}
