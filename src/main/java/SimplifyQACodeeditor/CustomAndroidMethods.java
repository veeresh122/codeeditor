package SimplifyQACodeeditor;

import com.simplifyqa.customMethod.SqaAutowired;
import com.simplifyqa.sqadrivers.androiddriver;

public class CustomAndroidMethods {

	@SqaAutowired
    public Object andoid_object;
    
    public boolean Android_demo(){
        try{
        String xpath_value=null;
        //Object attributes = androiddriver.getCurrentObject().getAttributes();
        for(com.fasterxml.jackson.databind.JsonNode attr1:androiddriver.getCurrentObject().getAttributes())  {
            if(attr1.get("name").asText().toLowerCase().equals("xpath")){
                xpath_value=attr1.get("value").asText();
            break;
            }
           
        }
        androiddriver.Click("xpath", xpath_value);
        return true;

    }catch(Exception e){
        return false;
    }
    }


    public boolean Android_Entertext(String value_Enter){
        try{
        String xpath_value=null;
        //Object attributes = androiddriver.getCurrentObject().getAttributes();
        for(com.fasterxml.jackson.databind.JsonNode attr1:androiddriver.getCurrentObject().getAttributes())  {
            if(attr1.get("name").asText().toLowerCase().equals("xpath")){
                xpath_value=attr1.get("value").asText();
            break;
            }
           
        }
        androiddriver.Sendkeys("xpath", xpath_value,value_Enter);
        return true;

    }catch(Exception e){
        return false;
    }
    }
    

    


}
