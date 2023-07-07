package utils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class ReplaceCharacterOfString implements Interaction{

    public static String strProceced;
    public static String strOriginal;
    String strOldCharacter;
    String strNewCharacter;
    
    public ReplaceCharacterOfString(String strOriginal, 
    String strOldCharacter,String strNewCharacter){
    
        ReplaceCharacterOfString.strOriginal = strOriginal;
        ReplaceCharacterOfString.strProceced = "";
        this.strOldCharacter = strOldCharacter;
        this.strNewCharacter = strNewCharacter;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String strNewString= ReplaceCharacterOfString.strOriginal.replace(strOldCharacter,strNewCharacter);
      
        ReplaceCharacterOfString.strProceced = strNewString;
    }

    public static ReplaceCharacterOfString doTask(String strOriginal, 
    String strOldCharacter,String strNewCharacter)
    {
       
        return Tasks.instrumented(ReplaceCharacterOfString.class, 
        strOriginal, strOldCharacter,strNewCharacter);
    }


    
}
