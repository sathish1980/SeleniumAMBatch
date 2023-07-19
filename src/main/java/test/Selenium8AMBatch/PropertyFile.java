package test.Selenium8AMBatch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	
	String filepath= "C:\\Users\\sathishkumar\\eclipse-workspace\\Selenium8AMBatch\\Input\\env.properties";
	
	public void readProperty() throws IOException
	{
		File F = new File(filepath);
		FileInputStream FS = new FileInputStream(F);
		Properties p = new Properties();
		p.load(FS);
		String actualName = p.getProperty("name");
		System.out.println(actualName);
		System.out.println(p.getProperty("age"));
		p.setProperty("course", "testing");
		System.out.println(p.getProperty("course"));
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertyFile P = new PropertyFile();
		P.readProperty();
	}

}
