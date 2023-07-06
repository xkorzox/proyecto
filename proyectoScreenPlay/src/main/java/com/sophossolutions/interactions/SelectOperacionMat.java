package com.sophossolutions.interactions;

import com.sophossolutions.questions.TextOf;
import com.sophossolutions.ui.TestPage;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.targets.Target;

public class SelectOperacionMat implements Interaction {
	
	Target txtOperacionMat;
	Target txtSelect;
	Target txtSelectOption;
	

	public SelectOperacionMat(Target txtOperacionMat, Target txtSelect, Target txtSelectOption) {
		super();
		this.txtOperacionMat = txtOperacionMat;
		this.txtSelect = txtSelect;
		this.txtSelectOption = txtSelectOption;
	}



	@Override
	public <T extends Actor> void performAs(T actor) {
		
		boolean isCurrentlyVisible2 = actor.asksFor(CurrentVisibility.of(txtOperacionMat));
		if (isCurrentlyVisible2 == true) {

			String formula = TextOf.field(txtOperacionMat).answeredBy(actor);

			Expression e = new ExpressionBuilder(formula).build();

			double result = Double.valueOf(e.evaluate()).intValue();

			System.out.println(result);

			actor.attemptsTo(Click.on(txtSelect), SelectFromOptions.byValue(result + "").from(txtSelect));
		}
		
	}
	public static SelectOperacionMat formOperacion() {

		return Tasks.instrumented(SelectOperacionMat.class, TestPage.txtOperacionMat, TestPage.txtSelect,
				TestPage.txtSelectOption);
	}

}
