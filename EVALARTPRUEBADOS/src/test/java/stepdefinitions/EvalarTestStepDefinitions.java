package stepdefinitions;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.GetRepetitionsText;
//import questions.GetMathematicOperationText;
//import tasks.ClickCorrectButton;
import tasks.Login;
import tasks.OpenUrl;
import tasks.RepeatAutomationNTimes;


public class EvalarTestStepDefinitions {
    @Before
	public void setup() {
		OnStage.setTheStage(new OnlineCast());
	}
	@Given("Login evalart automation test page {string}")
	public void loginEvalartAutomationTestPage(String strReferenceUrl, DataTable tableAccomodationInfo) {
		OnStage.theActorCalled("QA User").wasAbleTo(OpenUrl.doTask(strReferenceUrl));
		OnStage.theActorInTheSpotlight().wasAbleTo(Login.doTasks(tableAccomodationInfo));
	}
	

	@When("Do ten iterations submiting the forms with correct results")
	public void doTenIterationsSubmitingTheFormsWithCorrectResults(){
		
		
		OnStage.theActorInTheSpotlight()
		.wasAbleTo(RepeatAutomationNTimes.doTask());
		
		/* 
		OnStage.theActorInTheSpotlight().asksFor(GetButtonsValues.make());
		OnStage.theActorInTheSpotlight().wasAbleTo(ClickCorrectButton.doTask(GetButtonsValues.buttonsValues));
		*/

	}

	@Then("Validate success message")
	public void validateSuccessMessage(){
		//OnStage.theActorInTheSpotlight()
		//.wasAbleTo(SelectAvailableAccommodation.doTask());

	}
}
