package questions;
import com.vdurmont.emoji.EmojiParser;
import com.vdurmont.emoji.EmojiParser.FitzpatrickAction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import ui.EvalarAutomationTestPage;
import utils.FormatXPath;

public class GetEmojiSearchText implements Question <String> {
    
    public static String  strEmojiSeacrhText;


    
    String [] listStrValues;
    TargetBuilder<Target> EMOJI_SEARCH_TEXT_BUILDER;
    String  XPath_EMOJI_SEARCH_TEXT;
    Target EMOJI_SEARCH_TEXT ;

    public GetEmojiSearchText(String  XPath_EMOJI_SEARCH_TEXT, 
    TargetBuilder<Target> EMOJI_SEARCH_TEXT_BUILDER, String ... listStrValues) {
      this.listStrValues = listStrValues;
      this.EMOJI_SEARCH_TEXT_BUILDER = EMOJI_SEARCH_TEXT_BUILDER;
      this.XPath_EMOJI_SEARCH_TEXT = XPath_EMOJI_SEARCH_TEXT;
	}

    @Override
    public String answeredBy(Actor actor) {

      actor.attemptsTo(
        FormatXPath.withGeneral(XPath_EMOJI_SEARCH_TEXT, 
        EMOJI_SEARCH_TEXT_BUILDER,
         listStrValues));

      EMOJI_SEARCH_TEXT = FormatXPath.GENERAL_OPTION_TARGET;
        
      strEmojiSeacrhText =EMOJI_SEARCH_TEXT
      .resolveFor(actor).getText();
     
      strEmojiSeacrhText =EmojiParser.parseToAliases(strEmojiSeacrhText, FitzpatrickAction.REMOVE);
      //strEmojiSeacrhText = strEmojiSeacrhText.replaceAll("[\\p{Cf}]", "");
 
      return "";
    
    }


    public static GetEmojiSearchText make(String ... listStrValues) {
		return new GetEmojiSearchText(
      EvalarAutomationTestPage.XPath_EMOJI_SEARCH_TEXT, 
      EvalarAutomationTestPage.EMOJI_SEARCH_TEXT_BUILDER,
      listStrValues);
	  }
}
