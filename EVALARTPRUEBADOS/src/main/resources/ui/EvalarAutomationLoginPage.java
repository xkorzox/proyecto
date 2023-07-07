package ui;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class EvalarAutomationLoginPage extends PageObject {
    
    public static Target USUARIO_TEXT_FIELD = Target.the("Usuario TextField")
    .locatedBy("//*[@name='username']");
    public static Target PASSWORD_TEXT_FIELD = Target.the("Contraseña TextField")
    .locatedBy("//*[@name='password']");
    public static Target ENVIAR_BUTTON = Target.the("Enviar Button")
    .locatedBy("//*[@type='submit']");
    
    
    
 
    


}
