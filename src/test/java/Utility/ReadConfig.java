package Utility;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {    //constructor
	File src=new File("C:\\Users\\vijay\\eclipse-workspace\\RiddhiHousingSocietyPoject\\Configuration\\config.properties");	
	
	try {
	FileInputStream fis=new FileInputStream(src);
	pro=new Properties();
	pro.load(fis);
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}	
	
public String getBrowserName() 
{
    String browser=pro.getProperty("browser");
    return browser;
}

public String getApplicationURL() {
	String url=pro.getProperty("baseURL");
	return url;
}


public  String getUserName() {
	String username=pro.getProperty("username");
	return username;
}

public String getPassword() {
	String password=pro.getProperty("password");
	return password;
	
}

		
	}
	
	

	


