package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFile 
{
	Properties pro;
	
	
    public ConfigFile()
{
	try {
		File source = new File ("./Config.properties");
		
		FileInputStream input = new FileInputStream(source);
		
		pro = new Properties();
		
		pro.load(input);
		
	} catch (Exception exp)
	{
		
		System.out.println("Exception is: ---"+exp.getMessage());
	} 
}
    
    
public String getFilePath()

{
	String fpath = pro.getProperty("TestData_SheetPath");
	
	return fpath;
}

public String getUserName()

{
	String uname = pro.getProperty("UserName");
	
	return uname;
}


	
}
