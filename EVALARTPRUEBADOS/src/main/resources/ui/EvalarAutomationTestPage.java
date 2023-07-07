package ui;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;

public class EvalarAutomationTestPage extends PageObject {
   
    public static Target REPETITIONS_QUANTITY_TEXT = Target.the("Repetitions Quantity Text")
    .locatedBy("//*[@class='text-xl text-center text-green-500']");
    //-------------------------------------Mathematic Operation Radio Buttons----------------------------------------------
    public static TargetBuilder<Target> MATHEMATIC_OPERATION_TEXT_BUILDER =Target.the("Mathematic Operation Text");
    public static String  XPath_MATHEMATIC_OPERATION_TEXT = "(//*[@class='text-center text-xl font-bold'])[%s]"; //1
    public static Target MATHEMATIC_OPERATION_TEXT;


    
    public static TargetBuilder<Target> RADIO_BUTTON_RESULT_BUILDER =Target.the("Radio Button with Result");
    public static String  XPath_RADIO_BUTTON_RESULT = "(//*[@class='grid grid-cols-4 gap-4 mt-4'])[%s]//*[@value='%s']";
 //-------------------------------------Mathematic Operation Select----------------------------------------------

    public static TargetBuilder<Target> SELECT_MATHEMATIC_OPERATION_BUILDER =Target.the("Select Mathematic Operation");
    public static String  XPath_SELECT_MATHEMATIC_OPERATION = "(//*[@name='select'])[%s]";
    
    //-----------------------------------------Write N Times X-------------------------------------------------
    
    public static TargetBuilder<Target> WRITE_N_TIMES_X_TEXT_BUILDER =Target.the("Write N Times X Text");
    public static String  XPath_WRITE_N_TIMES_X_TEXT = "(//*[@class='text-center text-xl'])[%s]";

    
    public static TargetBuilder<Target> TEXTO_TEXT_AREA_BUILDER =Target.the("Texto Text Area");
    public static String  XPath_TEXTO_TEXT_AREA = "(//*[@name='text'])[%s]";

       
    //-----------------------------------------Multiple of X-------------------------------------------------
    public static TargetBuilder<Target> MULTIPLE_OF_X_TEXT_BUILDER =Target.the("Multiple of X Text");
    public static String  XPath_MULTIPLE_OF_X_TEXT = "(//*[@class='text-center text-xl'])[%s]";
    
    
    
    public static TargetBuilder<Target> CHECK_BOXES_LIST_BUILDER =Target.the("CheckBoxes List");
    public static String  XPath_CHECK_BOXES_LIST = "(//*[@class='grid grid-cols-4 gap-4 mt-4'])[%s]//label";
   


    public static TargetBuilder<Target> CHECK_BOX_RESULT_BUILDER =Target.the("Check Box with Result");
    public static String  XPath_CHECK_BOX_RESULT = "(//*[@class='grid grid-cols-4 gap-4 mt-4'])[%s]//*[@value='%s']";

    //-----------------------------------------Emoji Count-------------------------------------------------
  
    
    public static TargetBuilder<Target> EMOJI_SEQUENCE_TEXT_BUILDER =Target.the("Emoji Sequence Text");
    public static String  XPath_EMOJI_SEQUENCE_TEXT = "(//*[@class='text-center text-xl'])[%s]";
 
    
    
    
    public static TargetBuilder<Target> EMOJI_SEARCH_TEXT_BUILDER =Target.the("Emoji Search Text");
    public static String  XPath_EMOJI_SEARCH_TEXT = "(//*[@class='text-center text-xl'])[%s]";
  
    
    
    
    public static Target NUMBER_TEXT_FIELD= Target.the("NumberText Field")
    .locatedBy("//*[@name='number']");

    //-----------------------------------------Date-------------------------------------------------
    public static TargetBuilder<Target> DATE_SEARCH_TEXT_BUILDER =Target.the("Date Search Text");
    public static String  XPath_DATE_SEARCH_TEXT = "(//*[@class='text-center text-xl'])[%s]";
    public static Target DATE_SEARCH_TEXT;

    public static TargetBuilder<Target> DATE_INPUT_BUILDER =Target.the("Date Search Text");
    public static String  XPath_DATE_INPUT = "(//*[@name='date'])[%s]";
    public static Target DATE_INPUT;


    //-------------------------------------------Botón Enviar----------------------------------------
    public static Target ENVIAR_BUTTON= Target.the("Enviar Button")
    .locatedBy("//*[@type='submit']");

}   