package questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import ui.EvalarAutomationTestPage;
import utils.FormatXPath;

public class GetDateBoxText implements Question <String>{
    public static String  strDateText;    
    String [] listStrValues;
    TargetBuilder<Target> DATE_SEARCH_TEXT_BUILDER;
    String  XPath_DATE_SEARCH_TEXT;
    Target DATE_SEARCH_TEXT;

    public GetDateBoxText(String  XPath_DATE_SEARCH_TEXT, 
    TargetBuilder<Target> DATE_SEARCH_TEXT_BUILDER, String ... listStrValues) {
      this.listStrValues = listStrValues;
      this.DATE_SEARCH_TEXT_BUILDER = DATE_SEARCH_TEXT_BUILDER;
      this.XPath_DATE_SEARCH_TEXT = XPath_DATE_SEARCH_TEXT;
	}

    @Override
    public String answeredBy(Actor actor) {

      actor.attemptsTo(
        FormatXPath.withGeneral(XPath_DATE_SEARCH_TEXT, 
        DATE_SEARCH_TEXT_BUILDER,
         listStrValues));

        DATE_SEARCH_TEXT = FormatXPath.GENERAL_OPTION_TARGET;
        
        strDateText = DATE_SEARCH_TEXT.resolveFor(actor).getText();
     
     
 
      return "";
    
    }


    public static GetDateBoxText make(String ... listStrValues) {
		return new GetDateBoxText(
      EvalarAutomationTestPage.XPath_DATE_SEARCH_TEXT, 
      EvalarAutomationTestPage.DATE_SEARCH_TEXT_BUILDER,
      listStrValues);
	  }
    
}
