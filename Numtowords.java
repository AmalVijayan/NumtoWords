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


  public static String convert(long number) {
 
    if (number == 0) { return "zero"; }

    String snumber = Long.toString(number);

    // zero padding 
    String zero_padded = "0000";
    DecimalFormat df = new DecimalFormat(zero_padded);
    snumber = df.format(number);
    

   //System.out.println("\nAfter Padding :" + snumber); 

    int limit = Integer.parseInt(snumber.substring(0,4));

    String output;
    output = _convertHundreds(limit) ;
    //String result = tradThousand ;

    // remove extra spaces!
    return output.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
  }





  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Enter a Number between 1 and 1000");
    int num = in.nextInt();
    System.out.println("\nOutput : " + Numtowords.convert(num));

    System.out.println("\n 1 :"+Numtowords.convert(1));
    System.out.println("\n 16 :"+Numtowords.convert(16));
    System.out.println("\n 100 :"+Numtowords.convert(100));
    System.out.println("\n 118 :"+Numtowords.convert(118));
    System.out.println("\n 200 :"+Numtowords.convert(200));
    System.out.println("\n 219 :"+Numtowords.convert(219));
    System.out.println("\n 800 :"+Numtowords.convert(800));
    System.out.println("\n 801 :"+Numtowords.convert(801));
    System.out.println("\n 999 :"+Numtowords.convert(999));
    System.out.println("\n 1316 :"+Numtowords.convert(1316));
    System.out.println("\n 1000 :"+Numtowords.convert(1000));
  }
}

