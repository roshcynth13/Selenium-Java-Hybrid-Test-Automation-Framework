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
 public void ReadTestDataJSON() {
	 
	 /* Reading the TestData.json file and Parsing it */
	 
  JSONParser jsonParser = new JSONParser();

  try (FileReader reader = new FileReader("TestData.json")) {

   Object obj = jsonParser.parse(reader);

   JSONArray testDataList = (JSONArray) obj;
   
   System.out.println(testDataList);

   testDataList.forEach(jsonData -> parseTestDataObject((JSONObject) jsonData));


  } catch (FileNotFoundException e) {
	  
   e.printStackTrace();
   
  } catch (IOException e) {
	  
   e.printStackTrace();
   
  } catch (ParseException e) {
	  
   e.printStackTrace();
   
  }
 }

 public void parseTestDataObject(JSONObject testdata) { 
  
  /* The search keyword is strored in the JSON file */
  JSONObject employeeObject = (JSONObject) testdata.get("amazonETLData");
  searchKeyWordAN = (String) employeeObject.get("searchKeyWordAN");
  System.out.println(searchKeyWordAN);

 }


}