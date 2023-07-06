package com.sophossolutions.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class) //Enviamos la clase que contiene todas las instrucciones
@CucumberOptions(
		glue = "com.sophossolutions.stepdefinitions", //El paquete de los stepDefinitions
		features = "src/test/resources/com/sophossolutions/features/test_evalart.feature", //ruta del archivo feature
		snippets = SnippetType.CAMELCASE
		)
public class TestEvalart {

}
