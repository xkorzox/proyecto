package questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import ui.EvalarAutomationTestPage;
import utils.FormatXPath;
public class GetEmojiSequenceText implements Question <String> {
    
    public static String  strEmojiSequenceText;
    String [] listStrValues;
    TargetBuilder<Target> EMOJI_SEQUENCE_TEXT_BUILDER;
    String  XPath_EMOJI_SEQUENCE_TEXT;
    Target EMOJI_SEQUENCE_TEXT ;

    public GetEmojiSequenceText(String  XPath_EMOJI_SEQUENCE_TEXT,
    TargetBuilder<Target> EMOJI_SEQUENCE_TEXT_BUILDER,
    String ... listStrValues) {
		this. XPath_EMOJI_SEQUENCE_TEXT = XPath_EMOJI_SEQUENCE_TEXT;
    this.EMOJI_SEQUENCE_TEXT_BUILDER=EMOJI_SEQUENCE_TEXT_BUILDER;
    this.listStrValues = listStrValues;
	}

    @Override
    public String answeredBy(Actor actor) {
        

      actor.attemptsTo(
        FormatXPath.withGeneral(XPath_EMOJI_SEQUENCE_TEXT, 
        EMOJI_SEQUENCE_TEXT_BUILDER, 
        listStrValues));

      EMOJI_SEQUENCE_TEXT = FormatXPath.GENERAL_OPTION_TARGET;
      strEmojiSequenceText =EMOJI_SEQUENCE_TEXT
      .resolveFor(actor).getText();
     
      return "";
    
    }


    public static GetEmojiSequenceText make(String ... listStrValues) {
		return new GetEmojiSequenceText(
      EvalarAutomationTestPage.XPath_EMOJI_SEQUENCE_TEXT,
      EvalarAutomationTestPage.EMOJI_SEQUENCE_TEXT_BUILDER,
      listStrValues);
	  }
}
