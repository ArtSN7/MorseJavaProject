import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; // import for scanning input


public class add_morse {

    // function which will add new coded symbols in the MorseCode.txt
    public static void adding_morse_function(){

        System.out.println("\nADDING NEW VALUES\n--------"); // sending what we do

        // printing rules
        System.out.println("\nBefore inputting your value, PLEASE, make sure that you have read text below!\n");
        System.out.println("*You will have to input values twice. First input is the symbol ( plain text ) and the second one is a morse code for this symbol.\nYour mistake might have letal effect for the file, so add new symbols carefully!*\n");
        // finishing printing rules

        Scanner input = new Scanner(System.in); // creating input scanner

        System.out.print("\nInput symbol: "); // input symbol

        String symbol = input.nextLine(); // variable to store symbol

        System.out.print("\nInput code: "); // input code

        String code = input.nextLine(); // variable to store code

        Map<String, String> words = creating_morse_map(); // getting all the symbols from the file

        if (words.get(symbol.toUpperCase()) !=  null){ // if this symbol is in the file already

            System.out.println("\nSorry, this symbol is already in the file! Try another symbol later. Bye."); // I print thios

        }
        else{

            adding_new_code_function(symbol, code); // function which will put these values to the file

            System.out.println("\nAdded!"); // printing that we have done this job

        }


    }

    // function which adds new code to the MorseCode.txt
    public static void adding_new_code_function(String symbol, String code){

        try {
            FileWriter myWriter = new FileWriter("MorseCode.txt", true);    
            // false for overwriting and true for adding to the existing text

            myWriter.write("\n");
            myWriter.write(symbol.strip());
            myWriter.write(" : ");
            myWriter.write(code.strip());

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred while working with the file");
            e.printStackTrace();

        }

    }



    // function which will read a file and then put all the values into the map
    public static Map<String, String> creating_morse_map(){

        String[] parts; // for splitting value and code

        Map<String, String> result = new HashMap<String, String>(); // creating MAP to store symbols and their morse codes for the return

        try { // trying to catch errors while working with files

            File myObj = new File("MorseCode.txt");

            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) { // going through the file's lines

              String data = myReader.nextLine(); // reading line

              parts = data.split(" : "); // getting values of this line into array [ value , code ]

              result.put(parts[0], parts[1]);

            }

            myReader.close();

            return result;

          } catch (FileNotFoundException e) { // catching errors

            // sending a message about an error
            System.out.println("\nSorry, there is mistake while reading file. Try again later, please!");
            System.exit(0); // terminating program

            return result;
            
          }

    }
    
}
