package com.sophossolutions.stepdefinitions;

import com.sophossolutions.task.CopyHash;
import com.sophossolutions.task.ResolverEjercicios;
import com.sophossolutions.task.SetCredentials;
import com.sophossolutions.utils.Constants;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class TestEvalartStepDefinition {
	
	
	@Before
	public void setup() {
		OnStage.setTheStage(new OnlineCast());
	}
	
	@Given("Entro a la página {string} con el usuario {string} y la clave {string}")
	public void entroALaPáginaConElUsuarioYLaClave(String strUrl, String strUser, String strPass) {
	    OnStage.theActorCalled("Automator").wasAbleTo(Open.url(Constants.getData(strUrl)));
	    OnStage.theActorInTheSpotlight().wasAbleTo(SetCredentials.intoField(strUser, strPass));
	}
	@When("Resuelvo todos los ejercicios")
	public void resuelvoTodosLosEjercicios() {
		OnStage.theActorInTheSpotlight().wasAbleTo(ResolverEjercicios.with());
	}
	@Then("Obtengo el hash")
	public void obtengoElHash() {
	    OnStage.theActorInTheSpotlight().wasAbleTo(CopyHash.porFin());
	}
}
