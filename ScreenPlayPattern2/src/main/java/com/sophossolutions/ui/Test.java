package com.sophossolutions.ui;

import net.serenitybdd.screenplay.targets.Target;

public class Test {
		
	public static Target inputUser = Target.the("input username").
			locatedBy("//input[@name = 'username']");
	
	public static Target inputPass = Target.the("input password").
			locatedBy("//input[@name = 'password']");
	
	public static Target btnIngresar = Target.the("btn ingresar").
			locatedBy("//button[contains(@class,'bg-white')]");
	
}
