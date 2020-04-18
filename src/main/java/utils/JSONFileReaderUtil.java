package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileReaderUtil {

public String searchKeyWordAN;

public String getSearchKeyWordAN() {
		
	return searchKeyWordAN;
}

public void setSearchKeyWordAN(String searchKeyWordAN) {
	 
	this.searchKeyWordAN = searchKeyWordAN;
}

	@SuppressWarnings("unchecked")
	public void ReadTestDataJSON() 
	{
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader("TestData.json"))
		{
	
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
            
            employeeList.forEach( emp -> parseTestDataObject( (JSONObject) emp ) );

            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

	public void parseTestDataObject(JSONObject testdata) 
	
	{
		JSONObject employeeObject = (JSONObject) testdata.get("amazonETLData");
	    searchKeyWordAN = (String) employeeObject.get("searchKeyWordAN");	
		System.out.println(searchKeyWordAN);
		
	}
	
	
}
