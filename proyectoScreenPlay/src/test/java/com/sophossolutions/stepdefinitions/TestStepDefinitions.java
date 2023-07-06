package com.sophossolutions.stepdefinitions;

import com.sophossolutions.task.SetTest;
import com.sophossolutions.utils.Constants;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class TestStepDefinitions {
	
	@Before
	public void setup() {
		OnStage.setTheStage(new OnlineCast());
	}

	@Given("Debe ingresar en la pagina de newTours {string}")
	public void debeIngresarEnLaPaginaDeNewTours(String string) {
		System.out.println("Estoy en el Given...");
		OnStage.theActorCalled("Tomas").wasAbleTo(Open.url(Constants.getData(string)));
	}
	@When("Ingresar credenciales {string} y {string}")
	public void ingresarCredencialesY(String string, String string2) {
		OnStage.theActorInTheSpotlight().wasAbleTo(SetTest.forNewTours(string, string2));
	}
	@Then("Validar mensaje del home de la pagina")
	public void validarMensajeDelHomeDeLaPagina() {
	    
	}
}
