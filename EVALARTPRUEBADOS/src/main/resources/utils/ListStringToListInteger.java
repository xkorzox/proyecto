package utils;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;


public class ListStringToListInteger implements Interaction{

    public static List<Integer> listOfNumbers;
    private List<String> listOfStrings;
    
  

    public ListStringToListInteger(List<String> listOfStrings){
        listOfNumbers = new ArrayList<>();
        this.listOfStrings = listOfStrings;
    }

    


    @Override
    public <T extends Actor> void performAs(T actor) {
        
       for (int i = 0; i < listOfStrings.size() ; i++) {
            Integer intNumber = Integer
            .parseInt(listOfStrings.get(i));
            listOfNumbers.add(intNumber);
       }
    }


    
    public static ListStringToListInteger with(List<String> listOfStrings)
    {
        return Tasks.instrumented(ListStringToListInteger.class, listOfStrings);
    }

    
    
  
}