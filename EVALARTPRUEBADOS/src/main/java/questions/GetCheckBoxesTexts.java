package questions;
import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import ui.EvalarAutomationTestPage;
import utils.FormatXPath;
import net.serenitybdd.screenplay.targets.TargetBuilder;

public class GetCheckBoxesTexts implements Question <String> {
    
    public static List<String>  listCheckBoxexTexts;
    String  XPath_CHECK_BOXES_LIST;
    String [] listStrValues;
    TargetBuilder<Target> CHECK_BOXES_LIST_BUILDER;
    Target CHECK_BOXES_LIST ;

    public GetCheckBoxesTexts(String  XPath_CHECK_BOXES_LIST,
    TargetBuilder<Target> CHECK_BOXES_LIST_BUILDER, 
    String ... listStrValues ) {
        this.XPath_CHECK_BOXES_LIST= XPath_CHECK_BOXES_LIST;
        this.listStrValues = listStrValues;
        this.CHECK_BOXES_LIST_BUILDER = CHECK_BOXES_LIST_BUILDER;
	}

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(

        FormatXPath.withGeneral(XPath_CHECK_BOXES_LIST,
      CHECK_BOXES_LIST_BUILDER,   listStrValues)
        );

        CHECK_BOXES_LIST = FormatXPath.GENERAL_OPTION_TARGET;
        listCheckBoxexTexts =CHECK_BOXES_LIST.resolveAllFor(actor).texts();
     
        return "";
    }


    public static GetCheckBoxesTexts make(String ... listStrValues) {
		return new GetCheckBoxesTexts(EvalarAutomationTestPage.XPath_CHECK_BOXES_LIST,
        EvalarAutomationTestPage.CHECK_BOXES_LIST_BUILDER, listStrValues);
	  }
}
