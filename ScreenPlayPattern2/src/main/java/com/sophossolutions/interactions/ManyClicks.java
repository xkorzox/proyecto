package com.sophossolutions.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ManyClicks implements Interaction {
	
	Target target;
	int intCantidad;
	
	
	
	public ManyClicks(Target target, int intCantidad) {
		super();
		this.target = target;
		this.intCantidad = intCantidad;
	}



	@Override
	public <T extends Actor> void performAs(T actor) {
		
		for (int i = 0; i < intCantidad; i++) {
			actor.attemptsTo(Click.on(target));
		}
		
	}
	
	public static ManyClicks to(Target target, int intCantidad) {
		
		return Tasks.instrumented(ManyClicks.class, target, intCantidad);
	}

}
