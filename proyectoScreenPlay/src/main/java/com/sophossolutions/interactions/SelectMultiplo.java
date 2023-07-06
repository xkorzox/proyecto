package com.sophossolutions.interactions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sophossolutions.questions.TextOf;
import com.sophossolutions.ui.TestPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SelectMultiplo implements Interaction {

	Target txtCalMultiplo;
	Target txtCantidadMultiplo;
	Target txtNumMultiplo;

	public SelectMultiplo(Target txtCalMultiplo, Target txtCantidadMultiplo, Target txtNumMultiplo) {
		super();
		this.txtCalMultiplo = txtCalMultiplo;
		this.txtCantidadMultiplo = txtCantidadMultiplo;
		this.txtNumMultiplo = txtNumMultiplo;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		String strMultiplo = TextOf.field(txtCalMultiplo).answeredBy(actor);
		String reg = "\\d+";
		int intNum = 0;

		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(strMultiplo);

		if (matcher.find()) {
			intNum = Integer.parseInt(matcher.group());
		}
		System.out.println(intNum);

		List<WebElementFacade> listElement = txtCantidadMultiplo.resolveAllFor(actor);
		System.out.println(listElement.size());

		for (int i = 0; i < listElement.size(); i++) {
			String num = TextOf.field(txtNumMultiplo.of(i + 1 + "")).answeredBy(actor);

			int numValidar = Integer.parseInt(num);

			if (calcularMultiplo(numValidar, intNum)) {

				System.out.println(intNum + " " + numValidar);

				actor.attemptsTo(Click.on(txtNumMultiplo.of(i + 1 + "")));

			}
		}

	}

	public static SelectMultiplo formMultiplo() {

		return Tasks.instrumented(SelectMultiplo.class, TestPage.txtCalMultiplo, TestPage.txtCantidadMultiplo,
				TestPage.txtNumMultiplo);
	}

	public boolean calcularMultiplo(int num1, int num2) {

		return num1 % num2 == 0;
	}

}
