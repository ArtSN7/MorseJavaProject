// code which will decode function
//-----------------------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; // import for scanning input


public class decode {
    
    public static void decoding_function(){

        //-----------------------------------------------------------------------------
        // FIRST PART - ASKING USER TO INPUT TEXT
        

        String text; // storing input
        ArrayList<String> letters = new ArrayList<>(); // creating array list for storing letters of the input

        Scanner input = new Scanner(System.in); // creating scanner for inputs

        System.out.println("\nDECODING\n--------"); // sending what we do

        System.out.println("You need to input the signals ( they must be sepparated with one space ) which you want to decode."); // asking for the input
        System.out.print("\nInput: "); // field for the input


        try{ // trying to catch any errors

            text = input.nextLine(); // getting text which we need to encode

        
        // END OF THE FIRST PART
        //-----------------------------------------------------------------------------


        //-----------------------------------------------------------------------------
        // SECOND PART - TO ENCODE INPUT

            letters = getting_letter(text); // getting all the symbols from the input

            Map<String, String> morse_code_dictionary = new HashMap<String, String>(); // creating MAP to store morse code and their decoded values 

            morse_code_dictionary = creating_morse_map(); // putting all the values into the map

            String result = getting_result(letters, morse_code_dictionary); // getting decoded string

            System.out.print("\nResult: "); // outputting result

            System.out.println(result); // outputting result

        } catch (Exception e){ // if there is anything that cannot be decoded, error appears 

            // sending a message about an error
            System.out.println("\nSorry, but you have used symbols which are not represented in the MorseCode.txt .\nYou can add them by using command number 3.");
            System.exit(0); // terminating program

        }

        // END OF THE SECOND PART
        //-----------------------------------------------------------------------------
        
    }


    // function which does decoding and returning final result
    public static String getting_result(ArrayList<String> letter_result, Map<String, String> code){

        String result = ""; // returning value 
        String n = ""; // string value to store value from the map

        for (String i : letter_result) {

            n = code.get(i); // getting value from map which has key i

            if (n == null){ // if it is space or unknown element, it will be just space
                n = " "; // declaring space
            }
            
            result += n.toLowerCase(); // adding lower case letter to the final string

        }

        return result; // returning result

    }


    // function get text, then splits it and puts all the symbols to the list, then return this list
    public static ArrayList<String> getting_letter(String txt){

        ArrayList<String> result = new ArrayList<>(); // declaring list that will be returned 
        String[] parts = txt.split(" "); // splited parts in the array ( splitting by space as it is requirement of the input )
    
        int n = parts.length; // length of the parts
    
        for (int i = 0; i < n; i++){ // adding each symbol to the result array
            result.add(parts[i]);
        }
    
        return result; // returning result
    
    
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

              result.put(parts[1], parts[0]); // know key is a coded data

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
