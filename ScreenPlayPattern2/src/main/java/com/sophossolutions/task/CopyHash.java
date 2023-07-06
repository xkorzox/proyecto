package com.sophossolutions.task;

import com.sophossolutions.ui.FinalTest;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class CopyHash implements Task{
	
	String hash;
	
	public CopyHash() {

	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				WaitUntil.the(FinalTest.titleFinal, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()
				);
		copyHash(actor);
		
	}
	
	public void copyHash(Actor actor) {
		
		WebElementFacade hash = FinalTest.hashCopy.resolveFor(actor);
		
		System.out.println("El hash es: "+ hash.getText());
		
		
	}
	
	public static CopyHash porFin() {
		
		return Tasks.instrumented(CopyHash.class);
	}
}
