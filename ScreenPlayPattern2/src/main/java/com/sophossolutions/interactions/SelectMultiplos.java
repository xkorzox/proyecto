package com.sophossolutions.interactions;

import java.util.ArrayList;

import com.sophossolutions.ui.TestCiclos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SelectMultiplos implements Interaction{
	
	ArrayList<Integer> lstNumeros = new ArrayList<>();
	int multiplo;

	public SelectMultiplos(ArrayList<Integer> lstNumeros, int multiplo) {
		super();
		this.lstNumeros = lstNumeros;
		this.multiplo = multiplo;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		System.out.println("Ingreso al SelectMultiplo");
		System.out.println("Multiplo: "+multiplo);
		for (Integer num : lstNumeros) {
			if(num % multiplo == 0) {
				actor.attemptsTo(Click.on(TestCiclos.boton.of(num+"")));
			}
		}
	}
	
	public static SelectMultiplos of(ArrayList<Integer> lstNumeros, int multiplo) {
		
		return Tasks.instrumented(SelectMultiplos.class, lstNumeros, multiplo);
	}

}
