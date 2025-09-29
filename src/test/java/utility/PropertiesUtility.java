package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.ui.constants.Env;

public class PropertiesUtility {

	public static String readProperty(String propertyName,Env env){
		// TODO Auto-generated method stub
		File propFile=new File(System.getProperty("user.dir")+"\\config\\"+Env.PREPROD+".properties");
		FileReader fileReader = null;
		Properties properties=new Properties();;
		try {
			fileReader = new FileReader(propFile);
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		String value=properties.getProperty(propertyName);
		return value;
	}

}
