package com.sophossolutions.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class TextOf implements Question<String> {
	
	Target txtSalida;
	
	public TextOf(Target txtSalida) {
		super();
		this.txtSalida = txtSalida;
	}

	@Override
	public String answeredBy(Actor actor) {
		
		actor.wasAbleTo(WaitUntil.the(txtSalida,WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());
		
		return Text.of(txtSalida).answeredBy(actor);
	}
	
	public static TextOf field(Target txtSalida) {
		return new TextOf(txtSalida);
	}

}
