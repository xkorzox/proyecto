package com.sophossolutions.task;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import com.ibm.icu.util.Calendar;
import com.sophossolutions.interactions.SelectMultiplos;
import com.sophossolutions.ui.TestCiclos;


import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

public class ResolverEjercicios implements Task{

	String strNum;
	
	ArrayList<Integer> posiciones = new ArrayList<>();
	
	
	public ResolverEjercicios() {
		super();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		traerInfo(actor);
		
	}
	
	public void traerInfo(Actor actor) {
		
		for (int i = 0; i < 10; i++) {
			Target questions = Target.the("questions").
					locatedBy("//div[@class = 'flex flex-wrap w-full justify-around my-5']/div//p");
			
			ListOfWebElementFacades lstQuestion = questions.resolveAllFor(actor);
			
			for (WebElementFacade question : lstQuestion) {
				
				if(question.getText().contains("es múltiplo")) {
					
					Target numValorar = Target.the("Numero a valorar")
							.locatedBy("//p[contains(text(), 'es múltiplo')]");
					
					WebElementFacade numero = numValorar.resolveFor(actor);
					
					Target labels = Target.the("labels exercise").
							locatedBy("//div[@class = 'bg-white rounded-md shadow-md p-5 flex flex-col items-center my-5 w-2/5 ']//label");
					
					//Añadir todos los numeros
					ListOfWebElementFacades lstNums = labels.resolveAllFor(actor);
					ArrayList<Integer> lstNumeros = new ArrayList<>();
					for (WebElementFacade element : lstNums) {		
						lstNumeros.add(Integer.parseInt(element.getText()));
					}
					int multiplo = Integer.parseInt(clearString(numero.getText()));
					
					actor.attemptsTo(SelectMultiplos.of(lstNumeros, multiplo));
					
				}else if(question.getText().contains("fecha que corresponde")) {
					Target fechaPage = Target.the("operacion").
							locatedBy("//p[contains(text(), 'Indique la fecha')]");
					WebElementFacade fechaWeb = fechaPage.resolveFor(actor);
					String[] fechaPartida = fechaWeb.getText().split(":");
					int sumDias = Integer.parseInt(clearString(fechaPartida[0].trim()));
					String fechaAEnviar = "";
					if(question.getText().contains("antes de")) {
						fechaAEnviar =  enviarFecha(fechaPartida[1].trim(), sumDias, "restar");
					}else {
						fechaAEnviar =  enviarFecha(fechaPartida[1].trim(), sumDias, "sumar");
					}
					System.out.println("Fecha a enviar: "+ fechaAEnviar);
					actor.attemptsTo(
							Enter.theValue(fechaAEnviar).into(TestCiclos.inputDate)
							);
				}
				else if(question.getText().contains("operación matemática")) {
					Target subQuestion = Target.the("operacion").
							locatedBy("//div[@class = 'flex flex-wrap w-full justify-around my-5']//p");
					
					ListOfWebElementFacades subQuestions = subQuestion.resolveAllFor(actor);
					
					for (WebElementFacade sub : subQuestions) {
						System.out.println(sub.getText());
						if(sub.getText().contains("=?")) {
							System.out.println("Entro al primero");
							Target operacion = Target.the("operacion").
									locatedBy("//p[contains(text(), '=?')]");
							WebElementFacade operacionHacer = operacion.resolveFor(actor);
							int valor = operacionMatematica(operacionHacer.getText());
							actor.attemptsTo(
									Click.on(TestCiclos.respuestaOperacionConRadioButton.of(valor+""))
									);
						}else if(!sub.getText().contains("=?") && sub.getText().contains("*")) {
							System.out.println("Entro al segundo");
							Target operacion = Target.the("operacion").
									locatedBy("//p[not(contains(text(), '=?')) and contains(text(),'*')]");
							WebElementFacade operacionHacer = operacion.resolveFor(actor);
							
							int valor = operacionMatematica(operacionHacer.getText());
							actor.attemptsTo(
									Click.on(TestCiclos.selectNum),
									SelectFromOptions.byValue(valor+"").from(TestCiclos.selectNum)
									);
						}
						
					}
				}
				else if(question.getText().contains("hay en la siguiente secuencia")) {
					
					Target imageToComparar = Target.the("images to comparar").
							locatedBy("(//div[@class = 'flex flex-col items-center p-4 space-y-5 bg-white rounded-md w-2/5 shadow-md my-5']//div//p)[1]");
					
					Target images = Target.the("images").
							locatedBy("(//div[@class = 'flex flex-col items-center p-4 space-y-5 bg-white rounded-md w-2/5 shadow-md my-5']//div//p)[2]");		
					
					WebElementFacade imagesString = images.resolveFor(actor);
					WebElementFacade imagenA = imageToComparar.resolveFor(actor);
					
					String imageBuscar = soloEmoji(imagenA.getText());
					int contador = buscarImagen(imageBuscar, imagesString.getText());
					actor.attemptsTo(
							Enter.theValue(contador+"").into(TestCiclos.inputImage)
							);	
				}
				else if(question.getText().contains("veces la letra")) {
					Target texto = Target.the("Palabra").
							locatedBy("//p[contains(text(), 'Escriba')]");
					
					WebElementFacade textoA = texto.resolveFor(actor);
					String letraAEnviar = textoA.getText().replaceAll(".*?'([^']*)'.*", "$1");
					int numVeces = Integer.parseInt(clearString(textoA.getText()));
					String letra = letrasNveces(letraAEnviar, numVeces);
					actor.attemptsTo(
						Enter.theValue(letra).into(TestCiclos.campoTexto)
					);
				}
				
			}
			
			try {
				Thread.sleep(5*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			actor.attemptsTo(Click.on(TestCiclos.buttonEnviar));

		}
		
	}
	
	public String enviarFecha(String fecha, int dias, String operacion) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendario = Calendar.getInstance();
		String fechaNuevaLimpia = "";
			try {
				Date fechaActual = sdf.parse(fecha);
				calendario.setTime(fechaActual);
				if(operacion == "sumar") {
					calendario.add(Calendar.DATE, dias);
				}else {
					calendario.add(Calendar.DATE, -dias);
				}
				Date fechaNueva = calendario.getTime();
				SimpleDateFormat sdfLimpio = new SimpleDateFormat("ddMMyyyy");
				fechaNuevaLimpia = sdfLimpio.format(fechaNueva);
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		return fechaNuevaLimpia;
	}
	
	public String soloEmoji(String imagen) {

		imagen = imagen.replaceAll("[a-zA-Z\\s:]", "");
		return imagen;
	}
	
	public Integer buscarImagen(String image, String imageBuscar) {
		int contador = 0;
		System.out.println(imageBuscar);
		System.out.println(image);
		int index = imageBuscar.indexOf(image);
		String resultado = "";
		if(index < 0) {
			index = index;
		}else {
			resultado = imageBuscar.substring(index);
			System.out.println(resultado.isEmpty());
		}
		System.out.println("index: "+index);
		
		
		boolean condicion = true;
		int opcion=0;
		
		if(index >= 0) {
			condicion = true;
		}else {
			condicion = false;
		}
		
		while (condicion) {
			contador++;
			index = resultado.indexOf(image);
			if(index >= 0) {
				resultado = resultado.substring(index+1);
				condicion = true;
			}else {
				condicion = false;
			}
			
			System.out.println(resultado);
		}
		 System.out.println(resultado);

		
		System.out.println("Está "+contador+" veces");
		if(contador == 0) {
			contador = 0;
			return contador;
		}else {
			return contador-1;
		}
		
	}
	
	public Integer operacionMatematica(String operacion) {
		System.out.println("Entro a la operacion");
		String[] terminos = operacion.split("(?=[-+])"); // Separar los términos en la operación

		int multiplicacion = 0;
        int resultado = 0;
        for (String termino : terminos) {
        	System.out.println("Termino: "+termino);
        	
        	if(termino.contains("*")) {
        		String[] factores = termino.split("(?=[/*])"); // Separar los factores en cada término
                
                multiplicacion = 1;
                for (String factor : factores) {
                    if (factor.startsWith("*")) {
                        multiplicacion *= Integer.parseInt(clearString(factor.substring(1)));
                    } else if (factor.startsWith("/")) {
                        multiplicacion /= Integer.parseInt(factor.substring(1));
                    } else {
                        multiplicacion *= Integer.parseInt(clearString(factor));
                    }
                }
        	}else {
        		multiplicacion = Integer.parseInt(clearString(termino));
        	}
            
            if (termino.startsWith("+")) {
            	System.out.println(resultado +"+"+multiplicacion);
                resultado += multiplicacion;
                System.out.println("Resultado: "+resultado);
            } else if (termino.startsWith("-")) {
            	System.out.println(resultado +"-"+multiplicacion);
                resultado -= multiplicacion;
                System.out.println("Resultado: "+resultado);
            } else {
            	System.out.println(resultado +"="+multiplicacion);
                resultado = multiplicacion;
                System.out.println("Resultado: "+resultado);
            }
            
            
        }
        
        return resultado;
    }
	
	public String letrasNveces(String letra, int numveces) {
		String letra2 = "";
		for (int i = 0; i < numveces; i++) {
			letra2 += letra;
			
		}
		
		return letra2;
	}
	
	public static String clearString(String source) {
	    return source.replaceAll("[^0-9]+", "");
	}
		
	
	public static ResolverEjercicios with() {
		
		return Tasks.instrumented(ResolverEjercicios.class);
	}

}
