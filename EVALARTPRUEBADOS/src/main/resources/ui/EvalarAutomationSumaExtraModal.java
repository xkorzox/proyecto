package ui;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class EvalarAutomationSumaExtraModal extends PageObject {
    
    public static Target SUMA_MODAL = Target.the("Suma Modal")
    .locatedBy("//*[@class='modal-content']");
    public static Target SUMA_TOTAL_TEXT_FIELD = Target.the("Suma Total TextField")
    .locatedBy("//*[@placeholder='Suma total']");
    public static Target ENVIAR_BUTTON = Target.the("Enviar Button")
    .locatedBy("//*[@type='submit']");
    
    
    
    


}
