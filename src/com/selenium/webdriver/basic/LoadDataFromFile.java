package com.selenium.webdriver.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LoadDataFromFile {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		InputStream input = null;
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			String fileName = "testCase.properties";
			input = LoadDataFromFile.class.getClassLoader().getResourceAsStream(fileName);
			
			if(input == null) {
				System.out.println("Sorry, unable to find " + fileName);
			} else {
				prop.load(input);
				System.out.println("The appUrl is: " + prop.getProperty("appUrl"));
				//map.put("appUrl", prop.getProperty("appUrl"));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
