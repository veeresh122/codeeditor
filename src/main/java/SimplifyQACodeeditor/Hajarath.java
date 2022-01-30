package SimplifyQACodeeditor;

import com.simplifyqa.customMethod.SqaAutowired; 
import com.simplifyqa.sqadrivers.webdriver;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.simplifyqa.sqadrivers.androiddriver;


import org.json.JSONObject;

public class Hajarath {

@SqaAutowired
public Object web_object;
public boolean DemoMethod(String url, String brname) {
return webdriver.launchapplication(url);
}
public boolean Democlear(){
         return webdriver.cleartext();   
    }

public boolean regularexpression(String str1, String str2){
     Pattern pattern = Pattern.compile(str2, Pattern.CASE_INSENSITIVE);
     Matcher matcher = pattern.matcher(str1);
     boolean matchFound = matcher.find();
     if(matchFound) {
     System.out.println("Match found");
    } else {
      System.out.println("Match not found");
    }
    return true;
  }

   //public static void main(String[] args){
     //CustomWebMethods a = new CustomWebMethods();
    //a.addtionoftwovalues(10, 20, "runtimeparam");
    //a.averageoftwonumbers(20, 30, "runtime");
    //a.regularexpression("Ali&", "ALi");
    //a.isAnagram("keep", "peek");*/
 //}

public boolean addtionoftwovalues(int num1, int num2, String runtimeparam){
    try{
       int sum = num1 + num2;
      //String sum2=Integer.toString(sum);
      
      webdriver.storeruntime(runtimeparam, String.valueOf(sum));
      System.out.println("Sum of these numbers: "+sum);
    
    }
    catch (Exception e){
        e.printStackTrace();
        return false;
    }
return true;
}
public boolean averageoftwonumbers(int num1, int num2){
try{
    int sum = 0;
    int avg = 0;
    sum = num1 + num2;
    avg = sum/2;
    System.out.println("Average: " + avg );
    return true;
}
catch (Exception e){
        e.printStackTrace();
        return false;

}
  }
 public boolean isAnagram(String str1, String str2) {  
      try{
   String s1 = str1.replaceAll("\\s", "");  
        String s2 = str2.replaceAll("\\s", "");  
        boolean status = true;  
       // str1= str2.concat(str1);
        //GeneralMethod obj = new GeneralMethod();
        //obj.storeruntime(runtime, str1);
        if (s1.length() != s2.length()) {  
            status = false;  
        } else {  
            char[] ArrayS1 = s1.toLowerCase().toCharArray();  
            char[] ArrayS2 = s2.toLowerCase().toCharArray();  
            Arrays.sort(ArrayS1);  
            Arrays.sort(ArrayS2);  
            status = Arrays.equals(ArrayS1, ArrayS2);  
        }  
        if (status) {  
            System.out.println(s1 + " and " + s2 + " are anagrams");  
        } else {  
            System.out.println(s1 + " and " + s2 + " are not anagrams");  
        }
        return true;  
    }
    catch (Exception e){
        e.printStackTrace();
        return false;
    }
    }
    public boolean removespaces(String space){
 try{        
        space = space.replaceAll("\\s+", "");       
        System.out.println("String after removing all the white spaces : " + space);
        return true;  
 }catch  (Exception e){
        e.printStackTrace();
        return false;
    } 
    }
    public boolean reversestring(String reverse){
try{     
        String reversedStr = "";    
        for(int i = reverse.length()-1; i >= 0; i--){    
            reversedStr = reversedStr + reverse.charAt(i);    
        }         
        System.out.println("Original string: " + reverse);       
        System.out.println("Reverse of given string: " + reversedStr);
        return true; 
    }catch (Exception e){
        e.printStackTrace();
        return false;
    }  
    }  
    
public boolean isjson(String str, int num){
    try{
    JSONObject obj=new JSONObject();    
  obj.put("name",str);    
  obj.put("age",num);        
   System.out.print(obj);
return true;  
    }catch (Exception e){
        e.printStackTrace();
        return false;
    }  
}
public boolean zoom(String url){
    try{
    webdriver.launchapplication(url);
    webdriver.click("xpath", "//a[contains(text(),'SIGN IN')]");
    webdriver.click("xpath", "//input[@id='email']");
    webdriver.entertext("xpath", "//input[@id='email']", "hazarath552@gmail.com");
    webdriver.click("xpath", "//input[@id='password']");
    webdriver.entertext("xpath", "//input[@id='password']", "Lucky@2328");
    webdriver.click("xpath", "//a[contains(text(),'SCHEDULE A MEETING')]");
    webdriver.click("xpath", "//input[@placeholder='My Meeting']");
    webdriver.entertext("xpath", "//input[@placeholder='My Meeting']", "Demo Metting");
    webdriver.click("xpath", "(//span[contains(text(),'Save')])[2]");
    androiddriver.startapp("us.zoom.videomeetings", "com.zipow.videobox.LauncherActivity");
    androiddriver.Click("xpath", "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.HorizontalScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]");
    androiddriver.Click("xpath", "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/androidx.viewpager.widget.ViewPager[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[3]");
    androiddriver.Click("xpath", "//android.widget.Button[@resource-id=\'us.zoom.videomeetings:id/btnDeleteMeeting\']");
    androiddriver.Click("xpath", "//android.widget.Button[@resource-id=\'us.zoom.videomeetings:id/button1\']");
     } 
     catch(Exception e){
         e.printStackTrace();
         return false;
     }
     return true;
}
}
