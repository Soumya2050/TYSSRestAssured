package com.RMGyantra.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This is used to read the data from the external file like
 * text,properties,Excel,json,dataBase
 * 
 * @author srjen
 *
 */
public class FileUtility {

	/**
	 * It is used to get te filepath from the
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getFilePathFromPropertiesFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/FilePath.properties");
		Properties property = new Properties();
		property.load(fis);
		String value = property.getProperty(key);
		return value;

	}

	/**
	 * This method is used to get the key :value from the any properties based on
	 * the file path parameter
	 * 
	 * @param FilePath
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertiesFile(String FilePath, String key) throws IOException {

		FileInputStream fis = new FileInputStream(FilePath);
		Properties property = new Properties();
		property.load(fis);
		String value = property.getProperty(key);
		return value;

	}

}
