package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;

public class LoginDataProviders {

	@DataProvider(name="loginDataProviders")
	public Iterator<Object[]> readJsonData(){
		Gson gson=new Gson();
		File file=new File(System.getProperty("user.dir")+"//testData/loginData.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		TestData data=gson.fromJson(fileReader, TestData.class);
		
		List<Object[]> dataToReturn=new ArrayList<Object[]>();
		
		for(User user:data.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();
	}
}
