import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class Numtowords {

  private static final String[] tensNames = { ""," ten"," twenty"," thirty"," forty"," fifty"," sixty"," seventy"," eighty"," ninety"};

  private static final String[] numNames = {""," one"," two"," three"," four"," five"," six"," seven"," eight"," nine"," ten"," eleven"," twelve"," thirteen"," fourteen"," fifteen"," sixteen"," seventeen"," eighteen"," nineteen"};

  private Numtowords() {}

  private static String _convertHundreds(int number) {
    
    
    String term;     //to store digits in a number 
      
    if (number == 1000){
       return numNames[1] + " thousand ";
       }
       
    if (number > 1000){
       return "Convertion Limit Exceeded !! Please try any number below 1000";
       }

    //Convertion of 3 digit number starts
    if (number % 100 < 20){
      term = numNames[number % 100];
      number /= 100;
    }
    else {
      term = numNames[number % 10];
      number /= 10;

      term =  tensNames[number % 10] + term;
      number /= 10;
    }
    if (number == 0) return term;
    if (term == "")
    return numNames[number] + " hundred " + term;
    else
    return numNames[number] + " hundred and" + term;
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Enter a Number between 1 and 1000\n ");
    int num = in.nextInt();

    if (num == 0) { System.out.println("\n zero"); }

    String snumber = Long.toString(num);

    // zero padding 
    String zero_padded = "0000";
    DecimalFormat df = new DecimalFormat(zero_padded);
    snumber = df.format(num);
    
    //System.out.println("\nAfter Padding :" + snumber); 

    int limit = Integer.parseInt(snumber.substring(0,4));

    String output;
    output = _convertHundreds(limit) ;


    System.out.println("\nOutput :" + output.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " "));


  }
}

