package tasks;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import questions.GetWriteNTimesXText;
import ui.EvalarAutomationTestPage;
import utils.StringWithLetterRepetedNTimes;
import utils.FormatXPath;
import utils.ProcessWriteNTimesXText;


public class CompleteWriteNTimesXBox implements Task{

    TargetBuilder<Target> TEXTO_TEXT_AREA_BUILDER;
    String  XPath_TEXTO_TEXT_AREA;
    Target TEXTO_TEXT_AREA;
    String strValueWriteNTimesText;
    String strValueWriteNTimesTextArea;

    public CompleteWriteNTimesXBox(String strValueWriteNTimesText,
    String strValueWriteNTimesTextArea,
    String  XPath_TEXTO_TEXT_AREA,
    TargetBuilder<Target> TEXTO_TEXT_AREA_BUILDER) {

        this.strValueWriteNTimesText = strValueWriteNTimesText;
        this.strValueWriteNTimesTextArea = strValueWriteNTimesTextArea;
        this.XPath_TEXTO_TEXT_AREA = XPath_TEXTO_TEXT_AREA;
        this.TEXTO_TEXT_AREA_BUILDER = TEXTO_TEXT_AREA_BUILDER;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.asksFor(
            GetWriteNTimesXText.make(strValueWriteNTimesText));
        String strWriteNTimesXText = GetWriteNTimesXText.strWriteNTimesXText;
        System.out.println("WRITE N TIMES TEXT "+strWriteNTimesXText);
        
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
        
    }

    public static CompleteWriteNTimesXBox doTask(String strValueWriteNTimesText,
    String strValueWriteNTimesTextArea)
    {
        return Tasks.instrumented(CompleteWriteNTimesXBox.class,
        strValueWriteNTimesText,strValueWriteNTimesTextArea,
        EvalarAutomationTestPage.XPath_TEXTO_TEXT_AREA,
        EvalarAutomationTestPage.TEXTO_TEXT_AREA_BUILDER);
    }
    
}
