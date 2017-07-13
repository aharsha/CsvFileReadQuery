import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;



 



public class TestQuery {
	
	static QueryParser queryParser;
	static Query query;
	static HeaderRow headerRow;
	static FetchCsvData fetchCsv;
	static String queryString;
	@BeforeClass
	public static void intialise() throws Exception
	{
		
		queryString = "select empid,empname from  d://cn.csv where empid=101 and empname='raju' order by empname";
		fetchCsv = new FetchCsvData();
		queryParser = new QueryParser();

		query = queryParser.parseQuery(queryString);
		headerRow = fetchCsv.getHeaderRow(query);
	}

    @Test  
        public void testCsvFileName(){  
    	assertEquals("File Path is correct","d://cn.csv",query.getFilepath());  
        //assertEquals(16,Calculator.findMax(new int[]{1,16,4,2}));  
        
        //assertEquals(-1,Calculator.findMax(new int[]{-12,-1,-3,-4,-2}));  
    }	

    @Test  
    public void hasOrderBy(){  
		assertEquals("havingOrder By ",true,query.isHasOrderBy());  
    //assertEquals(16,Calculator.findMax(new int[]{1,16,4,2}));  
    
    //assertEquals(-1,Calculator.findMax(new int[]{-12,-1,-3,-4,-2}));  
}	
    @Test
    public void dispRecords() throws Exception
    {
    	
    	headerRow.disp(headerRow);
    	
    }

}

