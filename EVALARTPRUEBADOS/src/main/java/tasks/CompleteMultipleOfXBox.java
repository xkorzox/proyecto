package tasks;
import java.util.ArrayList;
import java.util.List;

import interactions.MultyClickDifferentButtons;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import questions.GetCheckBoxesTexts;
import questions.GetMathematicOperationText;
import questions.GetMultipleOfXText;
import questions.GetWriteNTimesXText;
import ui.EvalarAutomationTestPage;
import utils.FormatXPath;
import utils.StringWithLetterRepetedNTimes;
import utils.ListStringToListInteger;
import utils.ObtainMultipleOfX;
import utils.ProcessMathematicOperationText;
import utils.ProcessMultipleOfXText;
import utils.ProcessWriteNTimesXText;


public class CompleteMultipleOfXBox implements Task{

   
    String strValueGetText;
    String strValueGetCheckBoxesText;

    public CompleteMultipleOfXBox(String strValueGetText, String strValueGetCheckBoxesText) {
        this.strValueGetText = strValueGetText;
        this.strValueGetCheckBoxesText = strValueGetCheckBoxesText;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       
        actor.asksFor(

        GetMultipleOfXText.make(strValueGetText));
        String strMultipleOfXText = GetMultipleOfXText.strMultipleOfXText;
        System.out.println("TEXTO MULTLIPO DE SIN PROCESAR "+strMultipleOfXText);

       
        actor.attemptsTo(ProcessMultipleOfXText
        .doTask(strMultipleOfXText));
        Integer intNumber = ProcessMultipleOfXText.intNumber;
        System.out.println("NÚMERO AL CUAL HAY QUE BUSCARLE MULTIPLOS "+ intNumber);

        actor.asksFor(
            GetCheckBoxesTexts.make(strValueGetCheckBoxesText));
        List <String> listCheckBoxexTexts = GetCheckBoxesTexts.listCheckBoxexTexts;
           
        actor.attemptsTo(ListStringToListInteger
        .with(listCheckBoxexTexts));

        List <Integer> listOfNumbers = ListStringToListInteger.listOfNumbers;
        System.out.println("CHECK BOXES NUMBERS "+listOfNumbers.toString());

        actor.attemptsTo(ObtainMultipleOfX.with(listOfNumbers, 
        intNumber));

       
        List <Integer> listMultiples = ObtainMultipleOfX.listMultiples;

        System.out.println("MULTIPLOS "+ listMultiples.toString());

        actor.attemptsTo(
            MultyClickDifferentButtons.doTask(strValueGetCheckBoxesText, listMultiples)
        );
       
      
    }

    public static CompleteMultipleOfXBox doTask(String strValueGetText, String strValueGetCheckBoxesText)
    {
        return Tasks.instrumented(CompleteMultipleOfXBox.class,
        strValueGetText,strValueGetCheckBoxesText);
    }
    
}
