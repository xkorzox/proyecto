package com.sophossolutions.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class TextOf implements Question<String>{
	Target tgtTextPage;

	public TextOf(Target tgtTextPage) {
		this.tgtTextPage = tgtTextPage;
	}

	@Override
	public String answeredBy(Actor actor) {
		actor.wasAbleTo(WaitUntil.the(tgtTextPage, WebElementStateMatchers.isVisible()).forNoMoreThan(100).seconds());
		return Text.of(tgtTextPage).answeredBy(actor);
	}

	public static TextOf field(Target tgtTextPage) {

		return new TextOf(tgtTextPage);
	}
}