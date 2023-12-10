import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class quiz {

    public static void quiz_function(){

        Map<String, String> right_answers = new HashMap<String, String>(); // map with answers for each word

        Map<String, String> user_answers = new HashMap<String, String>(); // answer from user

        int num_of_words = 0; // number of words will be used for quiz

        int int_random; // to store random values

        Scanner input = new Scanner(System.in); // creating scanner for inputs


        System.out.println("\nQUIZ\n--------"); // showing chosen command

        System.out.println("You need to input the number of words you want to get for the quiz."); // asking for the input
        System.out.print("\nInput: "); // field for the input


        try{ // trying to catch any errors

            num_of_words = input.nextInt(); // getting number of words for the quiz

        } catch (Exception e){ // if there is anything that cannot be decoded, error appears 

            // sending a message about an error
            System.out.println("You are not a very smart user! Your input was not an INTEGER. Try again later! Bye!");
            System.exit(0); // terminating program

        }

        Random rand = new Random(); // creating random object

        String[] words = getting_words_from_file(); // putting all the words from the file to this array

        String[] test = new String[num_of_words]; // string of the words for the test


        for (int i = 0; i < num_of_words; i ++){ // adding numbers to the 

            int_random = rand.nextInt(3116); // random number for 

            test[i] = words[int_random]; // adding word to the array

        }

        for(String a : test) { // getting morse code for every word
            right_answers.put(a, encoding_function(a)); // adding right code to the map
        }

        String res; // variable to store input

        for(int j = 0; j < num_of_words; j ++){

            System.out.printf("What is a morse code for word %s\n", test[j]);
            System.out.print("\nInput: ");

            res = input.nextLine();

            user_answers.put(test[j], res); // adding user's answer to the map

        }

        //System.out.println(right_answers);
        //System.out.println(user_answers);


    }

    public static String encoding_function(String text){

        ArrayList<String> letters = new ArrayList<>(); // creating array list for storing letters of the input


        try{ // trying to catch any errors

            letters = getting_letter(text); // getting all the symbols from the input

            Map<String, String> morse_code_dictionary = new HashMap<String, String>(); // creating MAP to store symbols and their morse codes 

            morse_code_dictionary = creating_morse_map(); // putting all the values into the map

            String result = getting_result(letters, morse_code_dictionary); // getting coded string

            return result; // returning result

        } catch (Exception e){ // if there is any error

            // sending a message about an error
            System.out.println("\nSorry, unexpected error appeared.");
            System.exit(0); // terminating program

            return " ";

        }

    }

    // function which does encoding and returning final result
    public static String getting_result(ArrayList<String> letter_result, Map<String, String> code){

        String result = ""; // returning value 
        String n = ""; // string value to store value from the map

        for (String i : letter_result) {

            n = code.get(i.toUpperCase());

            if (n != null){

                result += n;
                result += " ";

            }
            else{
                result += "/ ";
            }

        }

        return result;

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


    // function get texts, then splits it and puts all the symbols to the list, then return this list
    public static ArrayList<String> getting_letter(String txt){

        ArrayList<String> result = new ArrayList<>(); // declaring list that will be returned 
        String[] parts = txt.split(""); // splited parts in the array

        int n = parts.length; // length of the parts

        for (int i = 0; i < n; i++){ // adding each symbol to the result array
            result.add(parts[i]);
        }

        return result;


    }

    
    // function which gets words from the file and returns array with them
    public static String[] getting_words_from_file(){

        String[] result = new String[3116]; // creating array that will be returned

        try {
            
            int count = 0;
            
            File myObj = new File("WordsForMorse.txt"); // creating object
            Scanner myReader = new Scanner(myObj); // creating scanner

            while (myReader.hasNextLine()) {
              String data = myReader.nextLine(); // getting word from the line

              result[count] = data; // adding word to the array

              count += 1; // upgrading index
              
            }

            myReader.close(); // closing reader

            return result; // returning array

          } catch (FileNotFoundException e) {

            System.out.println("An error occurred.");
            System.exit(0); // forcing to quit 
            return result;

          }




    }
    
}
