package utils;
import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ObtainMultipleOfX implements Task {
    
    private List<Integer> listMultipleCandidates;
    private  Integer intNumber;
    public static Integer intMultiple;
    public static List<Integer> listMultiples;

    public ObtainMultipleOfX (List<Integer> listMultipleCandidates, 
    Integer intNumber)
    {
        this.intNumber = intNumber;
        this.listMultipleCandidates = listMultipleCandidates;
        listMultiples = new ArrayList<>();
        
    
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < listMultipleCandidates.size(); i++) {
            
            if((listMultipleCandidates.get(i)%intNumber) ==0)
            {
                intMultiple= listMultipleCandidates.get(i);
                listMultiples.add(intMultiple);
            }
        }
    }

    public static ObtainMultipleOfX with(List<Integer> listMultipleCandidates, 
    Integer intNumber)
    {
        return Tasks.instrumented(ObtainMultipleOfX.class, listMultipleCandidates,
        intNumber);
    }

    
}
