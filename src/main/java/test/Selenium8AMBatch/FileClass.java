package test.Selenium8AMBatch;

import java.io.File;
import java.io.IOException;

public class FileClass {
	
	String directory=System.getProperty("user.dir");
	String filepath=System.getProperty("user.dir")+"\\Input\\Input.xls";
	
	
	public void fileimplementation() throws IOException
	{
		File f = new File(filepath);
		File f1 = new File(directory);
		boolean value = f1.isDirectory();
		boolean value1 = f.isFile();
		boolean value2 = f.exists();
		String filenames[]=f1.list();  
		 for(String filename:filenames){  
		        System.out.println(filename);  
		    }  
		File path= f1.getAbsoluteFile();
		String path1 = f.getAbsolutePath();
		String path2 = f.getCanonicalPath();
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileClass F = new FileClass();
		F.fileimplementation();
	}

}
