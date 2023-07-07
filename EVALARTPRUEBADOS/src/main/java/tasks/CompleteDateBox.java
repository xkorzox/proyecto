package tasks;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import questions.GetDateBoxText;
import questions.GetWriteNTimesXText;
import ui.EvalarAutomationTestPage;
import utils.StringWithLetterRepetedNTimes;
import utils.FormatXPath;
import utils.ProcessDateText;
import utils.ProcessWriteNTimesXText;


public class CompleteDateBox implements Task{

    String strValueDateText;
    String  XPath_DATE_INPUT;
    TargetBuilder<Target> DATE_INPUT_BUILDER;
    Target DATE_INPUT;
    
   

    public CompleteDateBox(String strValueDateText,
    String   XPath_DATE_INPUT,
    TargetBuilder<Target> DATE_INPUT_BUILDER) {

        this.strValueDateText = strValueDateText;
        this.XPath_DATE_INPUT = XPath_DATE_INPUT;
        this.DATE_INPUT_BUILDER = DATE_INPUT_BUILDER;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.asksFor(
            GetDateBoxText.make(strValueDateText));
        String strDateText = GetDateBoxText.strDateText;
        System.out.println("DATE TEXT "+strDateText);

        actor.attemptsTo(ProcessDateText
        .doTask(strDateText));
        String strProccecedDateText = ProcessDateText.strProccecedDateText;
        System.out.println("PROCCECED DATE TEXT "+strProccecedDateText);
        /* 
        actor.attemptsTo(ProcessWriteNTimesXText
        .doTask(strWriteNTimesXText));
        Integer intNTimes = ProcessWriteNTimesXText.intNTimes;
        String strXText = ProcessWriteNTimesXText.strXText;
        
        System.out.println("LETRA "+strXText);
        System.out.println("NÚMERO "+intNTimes);
         
        actor.attemptsTo(StringWithLetterRepetedNTimes
        .doTask(intNTimes, strXText));

        String strOfRepetedLetter = StringWithLetterRepetedNTimes.strOfRepetedLetter;
        System.out.println("LETRA REPETIDA "+strOfRepetedLetter);
        System.out.println("TAMAÑO LETRA REPETIDA "+strOfRepetedLetter.length());

        actor.attemptsTo(
            FormatXPath.withGeneral(XPath_TEXTO_TEXT_AREA,
            TEXTO_TEXT_AREA_BUILDER, strValueWriteNTimesTextArea));
        
        TEXTO_TEXT_AREA=FormatXPath.GENERAL_OPTION_TARGET;
       
         actor.attemptsTo(
            Enter.theValue(strOfRepetedLetter)
            .into(TEXTO_TEXT_AREA));
        */
    }

    public static CompleteDateBox doTask(String strValueWriteNTimesText)
    {
        return Tasks.instrumented(CompleteDateBox.class,
        strValueWriteNTimesText,
        EvalarAutomationTestPage.XPath_TEXTO_TEXT_AREA,
        EvalarAutomationTestPage.TEXTO_TEXT_AREA_BUILDER);
    }
    
}
