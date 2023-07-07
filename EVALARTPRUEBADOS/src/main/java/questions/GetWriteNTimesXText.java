package questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import ui.EvalarAutomationTestPage;
import utils.FormatXPath;
public class GetWriteNTimesXText implements Question <String> {
  
  String strValueWriteNTimesText;
  TargetBuilder<Target> WRITE_N_TIMES_X_TEXT_BUILDER;
  String  XPath_WRITE_N_TIMES_X_TEXT ;//2
  Target WRITE_N_TIMES_X_TEXT;
  public static String  strWriteNTimesXText;
   

    public GetWriteNTimesXText(String strValueWriteNTimesText,
    String  XPath_WRITE_N_TIMES_X_TEXT,
    TargetBuilder<Target> WRITE_N_TIMES_X_TEXT_BUILDER ) {
		this. strValueWriteNTimesText  =  strValueWriteNTimesText;
    this.XPath_WRITE_N_TIMES_X_TEXT = XPath_WRITE_N_TIMES_X_TEXT;
    this.WRITE_N_TIMES_X_TEXT_BUILDER = WRITE_N_TIMES_X_TEXT_BUILDER;
	}

    @Override
    public String answeredBy(Actor actor) {
        
      actor.attemptsTo(
      FormatXPath.withGeneral(XPath_WRITE_N_TIMES_X_TEXT, 
      WRITE_N_TIMES_X_TEXT_BUILDER,
      strValueWriteNTimesText ));

      WRITE_N_TIMES_X_TEXT = FormatXPath.GENERAL_OPTION_TARGET;

      strWriteNTimesXText =WRITE_N_TIMES_X_TEXT
      .resolveFor(actor).getText();
     
        return "";
    }


    public static GetWriteNTimesXText make(String strValueWriteNTimesText) {
		return new GetWriteNTimesXText(strValueWriteNTimesText,
      EvalarAutomationTestPage.XPath_WRITE_N_TIMES_X_TEXT,
      EvalarAutomationTestPage.WRITE_N_TIMES_X_TEXT_BUILDER );
	  }
}
