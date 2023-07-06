package com.sophossolutions.task;

import com.sophossolutions.ui.Test;
import com.sophossolutions.utils.Constants;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class SetCredentials implements Task {

	String strUser;
	String strPass;
	
	public SetCredentials(String strUser, String strPass) {
		super();
		this.strUser = strUser;
		this.strPass = strPass;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(Constants.getData(strUser)).into(Test.inputUser),
				Enter.theValue(Constants.getData(strPass)).into(Test.inputPass),
				Click.on(Test.btnIngresar)
				);
		
	}
	
	public static SetCredentials intoField(String strUser, String strPass) {
		
		return Tasks.instrumented(SetCredentials.class, strUser, strPass);
	}

}
