package SimplifyQACodeeditor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class deepika {
     public boolean validatetexts(String str1)
    {
        System.out.println("Enter a String ");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext("[A-Za-z]*")) {
            String input = sc.next();
            System.out.println("You entered a string value "+input);
        }else {
            System.out.println("Please Enter a Valid Value");
        }
        return true;
    }
public boolean writetofiles(String filepath)
 {
    try {
      FileWriter myWriter = new FileWriter(filepath);
      myWriter.write("Files in Java might be tricky, but it is fun enough!");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return true;
  }
}
