package com.sophossolutions.interactions;

import java.util.ArrayList;

import com.sophossolutions.questions.TextOf;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ConsoleMessage implements Interaction{
	
	Target diaEntrada;
	Target horaEntrada;
	Target diaSalida;
	Target horaSalida;
	Target semanas;
	Target precio;
	
	public ConsoleMessage(Target diaEntrada, Target horaEntrada, Target diaSalida, Target horaSalida, Target semanas,
			Target precio) {
		super();
		this.diaEntrada = diaEntrada;
		this.horaEntrada = horaEntrada;
		this.diaSalida = diaSalida;
		this.horaSalida = horaSalida;
		this.semanas = semanas;
		this.precio = precio;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		
		actor.attemptsTo(
				WaitUntil.the(diaEntrada,
						WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());
		
			System.out.println("Día entrada "+TextOf.field(diaEntrada).answeredBy(actor));
			System.out.println("Hora de entrada "+TextOf.field(horaEntrada).answeredBy(actor));
			System.out.println("Día de salida "+TextOf.field(diaSalida).answeredBy(actor));	
			System.out.println("Hora de salida "+TextOf.field(horaSalida).answeredBy(actor));
			System.out.println("Duración : "+TextOf.field(semanas).answeredBy(actor));
			System.out.println("Precio "+TextOf.field(precio).answeredBy(actor));
	}
	
	
	public static ConsoleMessage send(Target diaEntrada, Target horaEntrada, Target diaSalida, Target horaSalida,
									Target semanas, Target precio) {
		
		return Tasks.instrumented(ConsoleMessage.class, diaEntrada, horaEntrada, diaSalida, horaSalida, semanas, precio);
	}

}
