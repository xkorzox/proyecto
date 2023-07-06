package com.sophossolutions.interactions;

import com.sophossolutions.questions.TextOf;
import com.sophossolutions.task.SetTest;
import com.sophossolutions.ui.TestPage;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.targets.Target;

public class SelectOpeMatSigno implements Interaction{
	
	Target txtOpeMatSigno;
	Target txtCantidadRes;
	Target txtResultado;

	public SelectOpeMatSigno(Target txtOpeMatSigno, Target txtCantidadRes, Target txtResultado) {
		super();
		this.txtOpeMatSigno = txtOpeMatSigno;
		this.txtCantidadRes = txtCantidadRes;
		this.txtResultado = txtResultado;
	}



	@Override
	public <T extends Actor> void performAs(T actor) {
	
		boolean isCurrentlyVisible3 = actor.asksFor(CurrentVisibility.of(txtOpeMatSigno));
		if (isCurrentlyVisible3 == true) {

			System.out.println(TextOf.field(txtOpeMatSigno).answeredBy(actor));

			String strOperacion = TextOf.field(txtOpeMatSigno).answeredBy(actor);

			String strOper = strOperacion.substring(0, strOperacion.length() - 2);

			Expression e1 = new ExpressionBuilder(strOper).build();

			int strOperacion1 = Double.valueOf(e1.evaluate()).intValue();

			System.out.println(strOperacion);

			System.out.println(strOperacion1);

			actor.attemptsTo(Click.on(txtResultado.of(strOperacion1 + "")));

		}
	}

	public static SelectOpeMatSigno forOperacion() {

		return Tasks.instrumented(SelectOpeMatSigno.class, TestPage.txtOpeMatSigno, 
				TestPage.txtCantidadRes, TestPage.txtResultado);
	}
}
