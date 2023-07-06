package com.sophossolutions.interactions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sophossolutions.questions.TextOf;
import com.sophossolutions.ui.TestPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.targets.Target;

public class SelectCantidadLetras implements Interaction {

	Target txtCanLetra;
	Target txtArea;

	public SelectCantidadLetras(Target txtCanLetra, Target txtArea) {
		super();
		this.txtCanLetra = txtCanLetra;
		this.txtArea = txtArea;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		boolean isCurrentlyVisible = actor.asksFor(CurrentVisibility.of(txtCanLetra));
		if (isCurrentlyVisible == true) {

			String strLetras = TextOf.field(txtCanLetra).answeredBy(actor);
			String reg1 = "\\d+";
			int intNum1 = 0;
			Pattern pattern1 = Pattern.compile(reg1);
			Matcher matcher1 = pattern1.matcher(strLetras);

			if (matcher1.find()) {
				intNum1 = Integer.parseInt(matcher1.group());
			}
			System.out.println(intNum1);

			String reg2 = "'([a-zA-Z0-9])'";
			pattern1 = Pattern.compile(reg2);
			matcher1 = pattern1.matcher(strLetras);

			String strNLetras = null;

			if (matcher1.find()) {
				strNLetras = (matcher1.group(1));
			}

			System.out.println(strNLetras);
			actor.attemptsTo(Enter.theValue(strNLetras.repeat(intNum1)).into(txtArea));

		}

	}

	public static SelectCantidadLetras formLetras() {

		return Tasks.instrumented(SelectCantidadLetras.class, TestPage.txtCanLetra, TestPage.txtArea);
	}

}
