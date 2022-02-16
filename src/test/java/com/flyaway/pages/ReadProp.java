package com.flyaway.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {

	public static void main(String[] args) {
		
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/main/resources/config.properties"));
			System.out.println(prop.getProperty("DEV.URL"));
			prop.setProperty("UN", "SomeName");
			System.out.println(prop.getProperty("UN"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

}
