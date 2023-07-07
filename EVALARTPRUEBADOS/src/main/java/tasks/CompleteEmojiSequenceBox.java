package tasks;

import net.serenitybdd.screenplay.targets.Target;
import questions.GetEmojiSearchText;
import questions.GetEmojiSequenceText;
import ui.EvalarAutomationTestPage;
import utils.CountEmojiSequenceOcurrences;
import utils.ProcessEmojiSequenceText;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;


public class CompleteEmojiSequenceBox implements Task{

    Target NUMBER_TEXT_FIELD;
    String strValueGetEmojiSearchText;
    String strValueGetEmojiSequenceText;

    public CompleteEmojiSequenceBox( Target NUMBER_TEXT_FIELD,
    String strValueGetEmojiSearchText, String strValueGetEmojiSequenceText) {
        this.NUMBER_TEXT_FIELD = NUMBER_TEXT_FIELD;
        this.strValueGetEmojiSearchText= strValueGetEmojiSearchText;
        this.strValueGetEmojiSequenceText = strValueGetEmojiSequenceText;
   
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        
        actor.asksFor(
            GetEmojiSequenceText.make(strValueGetEmojiSequenceText));
        String strEmojiSequenceText = GetEmojiSequenceText.strEmojiSequenceText;
        System.out.println("EMOJI TEXT "+strEmojiSequenceText);
         
        actor.attemptsTo(
            ProcessEmojiSequenceText.doTask(strEmojiSequenceText));
        String strEmojiSequenceToFind = ProcessEmojiSequenceText.strEmojiSequenceToFind;
        System.out.println("EMOJI TEXT PROCECED "+ strEmojiSequenceToFind);
        


        actor.asksFor(
            GetEmojiSearchText.make(strValueGetEmojiSearchText));
        String strEmojiSeacrhText = GetEmojiSearchText.strEmojiSeacrhText;
        System.out.println("EMOJI SEARCH TEXT "+strEmojiSeacrhText);
       
        
        actor.attemptsTo(
            CountEmojiSequenceOcurrences.doTask(strEmojiSequenceToFind, 
            strEmojiSeacrhText));
        
        Integer intEmojiSequenceOcurrences =  CountEmojiSequenceOcurrences.intEmojiSequenceOcurrences;
        System.out.println("OCURRENCIAS "+intEmojiSequenceOcurrences);
    
     
        actor.attemptsTo(
            Enter.theValue(intEmojiSequenceOcurrences+"")
            .into(NUMBER_TEXT_FIELD)
        );
    
    }

    public static CompleteEmojiSequenceBox doTask(String strValueGetEmojiSearchText
    , String strValueGetEmojiSequenceText)
    {
        return Tasks.instrumented(CompleteEmojiSequenceBox.class,
        EvalarAutomationTestPage.NUMBER_TEXT_FIELD, strValueGetEmojiSearchText
        ,strValueGetEmojiSequenceText);
    }
    
}
