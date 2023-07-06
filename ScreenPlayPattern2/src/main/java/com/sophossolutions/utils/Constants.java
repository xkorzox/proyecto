package com.sophossolutions.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	
	private static Constants instance;
	private Map<String,String> constantDir = new HashMap<String, String>();

	
	private Constants() {
		constantDir.put("Evalart", "https://tasks.evalartapp.com/automatization/forms/test");
		constantDir.put("user", "639149");
		constantDir.put("clave", "10df2f32286b7120MS00LTk0MTkzNg==30e0c83e6c29f1c3");
	}
	
	public static String getData(String key) {
		if( instance == null) {
			instance = new Constants();
		}
		return instance.constantDir.get(key);
	}
	
}