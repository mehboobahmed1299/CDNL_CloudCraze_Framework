package utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.ui.constants.Env;

public class PropertiesUtility {

	public static String readProperty(String propertyName,Env env){
		File propFile=new File(Paths.get(System.getProperty("user.dir"), "config", env + ".properties").toString());
		FileReader fileReader = null;
		Properties properties=new Properties();
		try {
			fileReader = new FileReader(propFile);
			properties.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return properties.getProperty(propertyName);
	}

}
