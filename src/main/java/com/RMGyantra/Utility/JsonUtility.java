 
package com.RMGyantra.Utility;


import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	/**
	 * This method is used to get the key :value from the any properties based on
	 * the file path parameter
	 * 
	 * @param FilePath
	 * @param key
	 * @return
	 * @throws IOException
	 * @throws ParseException 
	 */
	public String getDataFromJSONFile(String FilePath, String key) throws IOException, ParseException {

		JSONParser js=new JSONParser();
		Object obj=js.parse(new FileReader(FilePath));
		/*Create an object to the to the properties class to load all the keys*/
		JSONObject map=(JSONObject)obj;
		String value = (String)map.get(key);
		return value;

	}

}
