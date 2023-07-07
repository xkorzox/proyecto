package com.sophossolutions.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sophossolutions.questions.TextOf;
import com.sophossolutions.ui.TestPage;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.targets.Target;

public class SetTest implements Task {

	String strUser;
	String strPassword;

	Target txtUser;
	Target txtPassword;
	Target btnInput;

	Target txtCalMultiplo;
	Target txtCantidadMultiplo;
	Target txtNumMultiplo;

	Target txtCanLetra;
	Target txtArea;

	Target txtOperacionMat;
	Target txtSelect;
	Target txtSelectOption;

	Target txtOpeMatSigno;
	Target txtCantidadRes;
	Target txtResultado;

	Target btnEnviar;

	Target btnFecha;
	Target txtFecha;
	
	Target btnGrillo;
	Target listEmoji;
	Target txtNumber;

	

	public SetTest(String strUser, String strPassword, Target txtUser, Target txtPassword, Target btnInput,
			Target txtCalMultiplo, Target txtCantidadMultiplo, Target txtNumMultiplo, Target txtCanLetra,
			Target txtArea, Target txtOperacionMat, Target txtSelect, Target txtSelectOption, Target txtOpeMatSigno,
			Target txtCantidadRes, Target txtResultado, Target btnEnviar, Target btnFecha, Target txtFecha,
			Target btnGrillo, Target listEmoji, Target txtNumber) {
		super();
		this.strUser = strUser;
		this.strPassword = strPassword;
		this.txtUser = txtUser;
		this.txtPassword = txtPassword;
		this.btnInput = btnInput;
		this.txtCalMultiplo = txtCalMultiplo;
		this.txtCantidadMultiplo = txtCantidadMultiplo;
		this.txtNumMultiplo = txtNumMultiplo;
		this.txtCanLetra = txtCanLetra;
		this.txtArea = txtArea;
		this.txtOperacionMat = txtOperacionMat;
		this.txtSelect = txtSelect;
		this.txtSelectOption = txtSelectOption;
		this.txtOpeMatSigno = txtOpeMatSigno;
		this.txtCantidadRes = txtCantidadRes;
		this.txtResultado = txtResultado;
		this.btnEnviar = btnEnviar;
		this.btnFecha = btnFecha;
		this.txtFecha = txtFecha;
		this.btnGrillo = btnGrillo;
		this.listEmoji = listEmoji;
		this.txtNumber = txtNumber;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Enter.theValue(strUser).into(txtUser), Enter.theValue(strPassword).into(txtPassword),
				Click.on(btnInput));

		for (int j = 0; j < 10; j++) {
			
			boolean isCurrentlyVisible7 = actor.asksFor(CurrentVisibility.of(txtCalMultiplo));
			if (isCurrentlyVisible7 == true) {
			// System.out.println(TextOf.field(txtCalMultiplo).answeredBy(actor));
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
//		__________________________________________________________________
			
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

				String reg2 = "\\\"([a-zA-Z0-9])\\\"";
				pattern1 = Pattern.compile(reg2);
				matcher1 = pattern1.matcher(strLetras);

				String strNLetras = null;

				if (matcher1.find()) {
					strNLetras = (matcher1.group(1));
				}

				System.out.println(strNLetras);
				actor.attemptsTo(Enter.theValue(strNLetras.repeat(intNum1)).into(txtArea));

			}
//_______________________________________________________________________________________
			boolean isCurrentlyVisible2 = actor.asksFor(CurrentVisibility.of(txtOperacionMat));
			if (isCurrentlyVisible2 == true) {

				System.out.println(11+"ddd");
				String formula = TextOf.field(txtOperacionMat).answeredBy(actor);

				Expression e = new ExpressionBuilder(formula).build();

				long result = Double.valueOf(e.evaluate()).longValue();

				System.out.println(result);

				actor.attemptsTo(Click.on(txtSelect), SelectFromOptions.byValue(result + "").from(txtSelect));
			}

//		______________________________________________________________________
			boolean isCurrentlyVisible3 = actor.asksFor(CurrentVisibility.of(txtOpeMatSigno));
			if (isCurrentlyVisible3 == true) {
				System.out.println(22+"ddd");

				System.out.println(TextOf.field(txtOpeMatSigno).answeredBy(actor));

				String strOperacion = TextOf.field(txtOpeMatSigno).answeredBy(actor);

				String strOper = strOperacion.substring(0, strOperacion.length() - 2);
				
				System.out.println(strOper);

				Expression e1 = new ExpressionBuilder(strOper).build();

				long strOperacion1 = Double.valueOf(e1.evaluate()).longValue();

				System.out.println(strOperacion);

				System.out.println(strOperacion1);
				
				actor.attemptsTo(Click.on(txtResultado.of(strOperacion1 + "")));

			}
//_______________________________________________________________________
			
			boolean isCurrentlyVisible4 = actor.asksFor(CurrentVisibility.of(btnFecha));
			if (isCurrentlyVisible4 == true) {
				
				
				System.out.println(TextOf.field(btnFecha).answeredBy(actor));

				String strfecha = TextOf.field(btnFecha).answeredBy(actor);
				System.out.println("--------"+strfecha.length());
				if(strfecha.length()>75) {
				
				String reg4 = "\\d+";
				int intNum4 = 0;

				Pattern pattern4 = Pattern.compile(reg4);
				Matcher matcher4 = pattern4.matcher(strfecha);

				if (matcher4.find()) {
					intNum4 = Integer.parseInt(matcher4.group());
				}
				System.out.println(intNum4);

				Calendar fechaCarta2 = Calendar.getInstance();

				fechaCarta2.add(Calendar.DAY_OF_MONTH, - intNum4);
				Date fecSegCarta = fechaCarta2.getTime();

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				String strFecha = (sdf.format(fecSegCarta));
				System.out.println(sdf.format(fecSegCarta));

				actor.attemptsTo(Enter.theValue(strFecha).into(txtFecha));

			}else {
				
				String reg4 = "\\d+";
				int intNum4 = 0;

				Pattern pattern4 = Pattern.compile(reg4);
				Matcher matcher4 = pattern4.matcher(strfecha);

				if (matcher4.find()) {
					intNum4 = Integer.parseInt(matcher4.group());
				}
				System.out.println(intNum4);

				Calendar fechaCarta2 = Calendar.getInstance();

				fechaCarta2.add(Calendar.DAY_OF_MONTH, intNum4);
				Date fecSegCarta = fechaCarta2.getTime();

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				String strFecha = (sdf.format(fecSegCarta));
				System.out.println(sdf.format(fecSegCarta));

				actor.attemptsTo(Enter.theValue(strFecha).into(txtFecha));
				
				
			}
				
			
			}
			
			
//			_____________________________________________________________________________
			boolean isCurrentlyVisible5 = actor.asksFor(CurrentVisibility.of(btnGrillo));
			if (isCurrentlyVisible5 == true) {
				System.out.println(TextOf.field(btnGrillo).answeredBy(actor));
				System.out.println(TextOf.field(listEmoji).answeredBy(actor));
				String strGrillo = TextOf.field(btnGrillo).answeredBy(actor);
				String strListEmoji = TextOf.field(listEmoji).answeredBy(actor);
			
				
				
				String reg5 = "[\\uD83C-\\uDBFF\\uDC00]";
				String intNum5 = "";

				Pattern pattern5 = Pattern.compile(reg5, Pattern.UNICODE_CASE);
				Matcher matcher5 = pattern5.matcher(strGrillo);

				if (matcher5.find()) {
					intNum5 = (matcher5.group());
				}
				System.out.println(intNum5);
				
				Pattern pattern6 = Pattern.compile(intNum5);
				Matcher matcher6 = pattern6.matcher(strListEmoji);
				
				int conteo = 0;
				while(matcher6.find()) {
					conteo++;
				}
				
				System.out.println(conteo);
				
				actor.attemptsTo(Enter.theValue(conteo+"").into(txtNumber));
				
			}
			actor.attemptsTo( Click.on(btnEnviar));
		}

		

	}


	public static SetTest forNewTours(String strUser, String strPassword) {

		return Tasks.instrumented(SetTest.class, strUser, strPassword, TestPage.txtUser, TestPage.txtPassword,
				TestPage.btnSubmit, TestPage.txtCalMultiplo, TestPage.txtCantidadMultiplo, TestPage.txtNumMultiplo,
				TestPage.txtCanLetra, TestPage.txtArea, TestPage.txtOperacionMat, TestPage.txtSelect,
				TestPage.txtSelectOption, TestPage.txtOpeMatSigno, TestPage.txtCantidadRes, TestPage.txtResultado,
				TestPage.btnEnviar, TestPage.btnFecha, TestPage.txtFecha, TestPage.btnGrillo, 
				TestPage.listEmoji, TestPage.txtNumber);
	}

	public boolean calcularMultiplo(int num1, int num2) {

		return num1 % num2 == 0;
	}

}
