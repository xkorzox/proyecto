package com.sophossolutions.ui;

import net.serenitybdd.screenplay.targets.Target;

public class TestCiclos {
	
	
	public static Target labels = Target.the("labels exercise").
			locatedBy("//div[@class = 'grid grid-cols-4 gap-4 mt-4']");
	
	public static Target boton = Target.the("labels exercise").
			locatedBy("//div[@class = 'bg-white rounded-md shadow-md p-5 flex flex-col items-center my-5 w-2/5 ']//label//input[@value = '{0}']");
	
	public static Target inputDate = Target.the("labels exercise").
			locatedBy("//input[@name = 'date']");
	
	public static Target inputImage = Target.the("imagenes").
			locatedBy("//input[@name='number']");
	
	public static Target selectNum = Target.the("labels exercise").
			locatedBy("//select");
	
	public static Target respuestaOperacionConRadioButton = Target.the("respuesta").
			locatedBy("//label//input[@value = '{0}']");
	
	public static Target buttonEnviar = Target.the("labels exercise").
			locatedBy("//button[@class = ' border-black p-2 border-2 rounded-md mx-auto hover:bg-blue-300']");
	
	public static Target campoTexto = Target.the("labels exercise").
			locatedBy("//textarea[@name = 'text']");
}
