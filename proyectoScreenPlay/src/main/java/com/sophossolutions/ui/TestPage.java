package com.sophossolutions.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://tasks.evalartapp.com/automatization/")
public class TestPage extends PageObject{
	
	public static Target txtUser = Target.the("Campo de username").locatedBy("//input[@name = 'username']");
	public static Target txtPassword = Target.the("Campo de passWord").locatedBy("//input[@name = 'password']");
	public static Target btnSubmit = Target.the("Boton Submit").locatedBy("//button[@type='submit']");
	

//	
	
	public static Target txtCalMultiplo = Target.the("Calcular Multiplo ").locatedBy("//div[@class='bg-white rounded-md shadow-md p-5 flex flex-col items-center my-5 w-2/5 ']//p");
	public static Target txtCantidadMultiplo = Target.the("Cantidad de Numeros Multiplos ").locatedBy("//div[@class='bg-white rounded-md shadow-md p-5 flex flex-col items-center my-5 w-2/5 ']//div[@class='grid grid-cols-4 gap-4 mt-4' ]//label");
	public static Target txtNumMultiplo = Target.the("Text Numero Multiplo ").locatedBy("//div[@class='bg-white rounded-md shadow-md p-5 flex flex-col items-center my-5 w-2/5 ']//div[@class='grid grid-cols-4 gap-4 mt-4' ]//label[{0}]");
	public static Target txtCanLetra = Target.the("Text Cantidad de letras ").locatedBy("//div[@class='flex flex-col p-4 w-2/5 bg-white rounded-md shadow-md my-5 justify-around']//p");
	
	
	public static Target txtArea = Target.the("Campo de area").locatedBy("//textarea[@name='text']");
	
	
	public static Target txtOperacionMat = Target.the("Calcular operacion matematica").locatedBy("//div[@class=' flex flex-col items-center bg-white rounded-md shadow-md p-5 space-y-4 my-5 w-2/5 ']//p[@class='text-center text-xl font-bold' ]");
	public static Target txtSelect = Target.the("Campo de Select").locatedBy("//select[@name='select']");
	public static Target txtSelectOption = Target.the("Seleccionar Opcion").locatedBy("//option[@value='{0}']");
	
	public static Target txtOpeMatSigno = Target.the("Calcular operacion matematica").locatedBy("//div[@class='bg-white rounded-md shadow-md p-5  flex flex-col items-center my-5 w-2/5 ']//p[@class='text-center text-xl font-bold' ]");
	public static Target txtCantidadRes = Target.the("Cantidad de Resultados ").locatedBy("//div[@class='bg-white rounded-md shadow-md p-5  flex flex-col items-center my-5 w-2/5 ']//div[@class='grid grid-cols-4 gap-4 mt-4' ]//label");
	public static Target txtResultado = Target.the("Campo resultado").locatedBy("//div[@class='bg-white rounded-md shadow-md p-5  flex flex-col items-center my-5 w-2/5 ' ]//input[@value='{0}']");
	
	public static Target btnEnviar = Target.the("Boton Enviar").locatedBy("//button[@type='submit']");
	
	
	public static Target btnFecha = Target.the("Boton Fecha").locatedBy("//div[@class='flex flex-col items-center p-4 space-y-5 bg-white rounded-md w-2/5 shadow-md my-5']/child::p");
	public static Target txtFecha = Target.the("Text Fecha").locatedBy("//input[@name='date']");
	
	
	public static Target btnGrillo = Target.the("Boton Grillo").locatedBy("//div[@class='w-9/12 space-y-4']/child::p[1]");
	public static Target listEmoji = Target.the("Lista de emoji").locatedBy("//div[@class='w-9/12 space-y-4']/child::p[2]");
	public static Target txtNumber = Target.the("Text Numero").locatedBy("//input[@name='number']");
}
