package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import ui.EvalarAutomationTestPage;
import utils.FormatXPath;

public class GetMathematicOperationText implements Question <String> {
    
    public static String strMathematicOperationText;
    String [] listStrValues;
    TargetBuilder<Target> MATHEMATIC_OPERATION_TEXT_BUILDER;
    String  XPath_MATHEMATIC_OPERATION_TEXT;
    Target MATHEMATIC_OPERATION_TEXT;


    public GetMathematicOperationText(
      String  XPath_MATHEMATIC_OPERATION_TEXT,
      TargetBuilder<Target> MATHEMATIC_OPERATION_TEXT_BUILDER,
      String ... listStrValues) {

      this.XPath_MATHEMATIC_OPERATION_TEXT = XPath_MATHEMATIC_OPERATION_TEXT;
      this.MATHEMATIC_OPERATION_TEXT_BUILDER = MATHEMATIC_OPERATION_TEXT_BUILDER;
      this.listStrValues = listStrValues;
      
	}

    @Override
    public String answeredBy(Actor actor) {
     
      actor.attemptsTo(FormatXPath.withGeneral(
        XPath_MATHEMATIC_OPERATION_TEXT, 
        MATHEMATIC_OPERATION_TEXT_BUILDER,
        listStrValues));

      MATHEMATIC_OPERATION_TEXT = FormatXPath.GENERAL_OPTION_TARGET;
      
      strMathematicOperationText =MATHEMATIC_OPERATION_TEXT
      .resolveFor(actor).getText();

        return strMathematicOperationText;
    }
      


    public static GetMathematicOperationText make(String ... listStrValues) {
		return new GetMathematicOperationText(
      EvalarAutomationTestPage.XPath_MATHEMATIC_OPERATION_TEXT,
      EvalarAutomationTestPage.MATHEMATIC_OPERATION_TEXT_BUILDER,
      listStrValues);
	}
}
