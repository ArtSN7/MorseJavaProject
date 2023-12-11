import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;

public class quiz {

    // function which allow user to do a quiz or to check scoreboard
    public static void quiz_choose_function(){

        Scanner input = new Scanner(System.in); // creating scanner for inputs

        int first_choice = 0; // variable which shows which function was choosen in the first part

        boolean first_choice_try = true; // variable which shows if person tries again

        System.out.println("\nQUIZ\n--------"); // showing chosen command

        System.out.println("Please, input the number of function which you want to do.\n\n1. Quiz\n2. Scoreboard\n"); // asking for the input
        System.out.print("\nInput: "); // field for the input

        while ( first_choice < 1 || first_choice > 2){ // user must input 1, 2 or 3 or 4 to go further 
 
            try{ // catching errors ( wrong input )

                if (first_choice_try != true){ // if it is not the first try, I need to print out another text to the user

                    System.out.print("\nWrong value! Your input must be 1 or 2!\n\nTry again: "); // printing text

                }

                first_choice = input.nextInt(); // getting input from user ( must be integer )
                first_choice_try = false; // declaring that next tries to input value are not the first ones

            } catch ( Exception e){ // catching an error ( if user tries to input not integer )

                System.out.print("\nYou are not a very smart user! Your input was not an INTEGER. Try again later! Bye!"); // sending a message to user

                System.exit(0); // terminating program

            }
        }

        if (first_choice == 1){ // if input is 1 
            quiz_function(); // then it is quiz
        }
        else{ // else
            scoreboard_function(); // then it is scoreboard
        }


    }

    // function which shows all attempts in the decending order
    public static void scoreboard_function(){

        ArrayList<Double> values = new ArrayList<>();

        try {
            File myObj = new File("results.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              values.add(Double.parseDouble(data.split(" ")[0]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while working with the scoreboard. Try again later, please.");
            e.printStackTrace();
        }

        Collections.sort(values); // sorting values from lowest to highest 
        Collections.reverse(values); // reversing list

        System.out.println("\n\nYour results:\n");


        for ( double i : values){ // printing out all the results
            System.out.println(i);
        }
        
    }



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

            num_of_words = Integer.parseInt(input.nextLine()); // getting number of words for the quiz

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

            System.out.printf("\nWhat is a morse code for word %s\n", test[j]);
            System.out.print("\nInput: ");

            res = input.nextLine(); // getting input

            user_answers.put(test[j], res); // adding user's answer to the map

        }

        int score = 0; // variable that stores number of right answers

        for (int j = 0; j < num_of_words; j ++){ // comparing user answers to the right ones

            if (right_answers.get(test[j]).strip().equals(user_answers.get(test[j]).strip())){ // if this is right one

                score += 1; // then we add 1 to the score
            }

        }


        adding_result_file(score / 1.0 / num_of_words * 100.0); // adding results to the file results.txt

    }


    public static void adding_result_file(double score){
        try {
            FileWriter myWriter = new FileWriter("results.txt", true);    
            // false for overwriting and true for adding to the existing text

            myWriter.write(Double.toString(score) + " %");
            myWriter.write("\n");
            
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred while writing result in the file");
            e.printStackTrace();

        }
    }



    // function that encodes string
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
