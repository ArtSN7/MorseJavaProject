# Morse CS Project

**GIT-HUB LINK:**

[https://github.com/ArtSN7/MorseJavaProject](https://github.com/ArtSN7/MorseJavaProject)

---

**Date - due to the 12th of January** 

START: 9th of December 

END: 12th od December

---

## Notes:

---

[https://www.geeksforgeeks.org/java-program-to-convert-english-text-to-morse-code-and-vice-versa/](https://www.geeksforgeeks.org/java-program-to-convert-english-text-to-morse-code-and-vice-versa/) - morse coding/decoding

[https://stackoverflow.com/questions/13543457/how-do-you-create-a-dictionary-in-java](https://stackoverflow.com/questions/13543457/how-do-you-create-a-dictionary-in-java) - dictionary

for the quiz we can check number of lines of the quiz file and then choose asked number for random ( [https://www.educative.io/answers/how-to-generate-random-numbers-in-java](https://www.educative.io/answers/how-to-generate-random-numbers-in-java) ) 

---

## Plan:

---

### Functions to do:

I) Translate normal input to morse

II) Translate morse input to the normal text

III) Can add new Morse codes ( integers or punctuation and etc ) to the MorseCode.txt 

IV) Quiz for the user to translate plain text to the Morse  and store best results in the new file

**Optional:*

*V) PhoeticAlphabet.txt decode / encode ( PhoeticAlphabet.txt )*

VI) Can add input via file ( so file + console inputs )

### Tasks:

- User’s input where he chooses functions ( need to use try-catch, check previous report about it )
- Make encoding function ( get all letter from the input ; get dictionary with morse value:code ; encode function which will work with these values )
- Make decoding function ( get all the codes from input to the array - they are separated by spaces ; get dictionary with code: morse value ; decode )
- Make quiz ( check notes ) - putting all the words from the file to the array and then pick randomly them ; create a map with word : encoded version ; check encoded version with the input and show results - need to have 2 buttons ( 1 - play , 2 - check result )
- Make adding new morse codes to the file ( tell that user needs to do it in a proper format without - use strip() before adding ; get the input from the user for the word; check if there is already this word in the file; if not ask for the code of this word;)
- Finish documentation
- Pseudocode
- Description of project ( the idea, structure, extensions and etc )
- Feelings ( what did I do well, where did I struggle, what did I do bad , what I can improve )

---

## Documentation:

---

### STARTER:

- **Zero step** was to create the file and a rep in the git. Then I started planning my project step by step as it is always easier to see a clear path to the success. ( my plan and notes can be seen above )

- **First step** was harder, as I was working with TRY-CATCH in Java ( which is always painful btw ). The main goal of the this step is to get user’s input ( which must be integer from 1 to 3 ) and catch any errors, such as inputing STRING instead of INTEGER. So, to achieve it, I used WHILE loop which forces user to input value again and again until user inputs the INTEGER from 1 to 3. However, if the user is “dumb” and inputs STRING or other data-type instead of INTEGER, my program sends a message and then terminates program ( using  ***System.exit(0)*** )

```java
        Scanner input = new Scanner(System.in); // creating input scanner

        int first_choice = 0; // variable which shows which function was choosen in the first part

        boolean first_choice_try = true; // variable which shows if person tries again
    
        //-----------------------------------------------------------------------------
        // FIRST PART - ASKING TO CHOOSE THE FUNCTION 

        System.out.println("-----------\nHello!\nWhat do you want to do?\n"); // explanation to user
        System.out.println("1. Encode a plain text to The Morse Code\n2. Decode The Morse Code to a plain text\n3. Add new specific Morse codes\n\n"); // explanation to user
        System.out.print("Input: "); // asking to choose what will program need to do ( MUST BE INTEGER )

        
        while ( first_choice < 1 || first_choice > 3){ // user must input 1, 2 or 3 to go further 
 
            try{ // catching errors ( wrong input )

                if (first_choice_try != true){ // if it is not the first try, I need to print out another text to the user

                    System.out.print("\nWrong value! Your input must be 1 , 2 or 3 !\n\nTry again: "); // printing text

                }

                first_choice = input.nextInt(); // getting input from user ( must be integer )
                first_choice_try = false; // declaring that next tries to input value are not the first ones

            } catch ( Exception e){ // catching an error ( if user tries to input not integer )

                System.out.print("\nYou are not a very smart user! Your input was not an INTEGER. Try again later! Bye!"); // sending a message to user

                System.exit(0); // terminating program

            }
        
        } // end of the while loop
```

- **Second step** was about to call different function according to the user’s input. In the variable *first_choice* I stores user’s input and then I check it using IF-ELSE structure ( I am just to good to use SWITCH statement instead :D )

```java
        //-----------------------------------------------------------------------------
        // SECOND PART - CALLING FUNCTIONS ACCORDING TO THE USER'S INPUT

        if (first_choice == 1){ // Encode a plain text to The Morse Code

            encode.encoding_function(); // calling encoding function

        }
        else if ( first_choice == 2){ // Decode The Morse Code to a plain text

            decode.decoding_function(); // calling decoding function

        }
        else if ( first_choice == 3){ // Add new specific Morse codes

            add_morse.adding_morse_function(); // calling adding to morse function

        }

        // END OF THE SECOND PART
        //-----------------------------------------------------------------------------
```

These first two steps were written in one file called [*base.java*](http://base.java) which connects all other files and starts the program. 

***Code of the [*base.java](http://base.java)* file:**

```java
// main code that communicates with user and connects other functions
//-----------------------------------------------------------------------------

import java.util.Scanner; // import for scanning input

public class base{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // creating input scanner

        int first_choice = 0; // variable which shows which function was choosen in the first part

        boolean first_choice_try = true; // variable which shows if person tries again
    
        //-----------------------------------------------------------------------------
        // FIRST PART - ASKING TO CHOOSE THE FUNCTION 

        System.out.println("-----------\nHello!\nWhat do you want to do?\n"); // explanation to user
        System.out.println("1. Encode a plain text to The Morse Code\n2. Decode The Morse Code to a plain text\n3. Add new specific Morse codes\n\n"); // explanation to user
        System.out.print("Input: "); // asking to choose what will program need to do ( MUST BE INTEGER )

        
        while ( first_choice < 1 || first_choice > 3){ // user must input 1, 2 or 3 to go further 
 
            try{ // catching errors ( wrong input )

                if (first_choice_try != true){ // if it is not the first try, I need to print out another text to the user

                    System.out.print("\nWrong value! Your input must be 1 , 2 or 3 !\n\nTry again: "); // printing text

                }

                first_choice = input.nextInt(); // getting input from user ( must be integer )
                first_choice_try = false; // declaring that next tries to input value are not the first ones

            } catch ( Exception e){ // catching an error ( if user tries to input not integer )

                System.out.print("\nYou are not a very smart user! Your input was not an INTEGER. Try again later! Bye!"); // sending a message to user

                System.exit(0); // terminating program

            }
        
        } // end of the while loop 

        // END OF THE FIRST PART
        //-----------------------------------------------------------------------------

        System.out.println("------------------------------"); // just printing a line for the better UIX

        //-----------------------------------------------------------------------------
        // SECOND PART - CALLING FUNCTIONS ACCORDING TO THE USER'S INPUT

        if (first_choice == 1){ // Encode a plain text to The Morse Code

            encode.encoding_function(); // calling encoding function

        }
        else if ( first_choice == 2){ // Decode The Morse Code to a plain text

            decode.decoding_function(); // calling decoding function

        }
        else if ( first_choice == 3){ // Add new specific Morse codes

            add_morse.adding_morse_function(); // calling adding to morse function

        }

        // END OF THE SECOND PART
        //-----------------------------------------------------------------------------

    }
}
```

### ENCODING:

- ***First step*** is to get a text from the user. I create two variables - text ( string ) , which will store input, and letters ( Array List of Strings ), which stores every symbol of the input. Then, I create a Scanner and ask user to input a text.

```java
  			//-----------------------------------------------------------------------------
        // FIRST PART - ASKING USER TO INPUT TEXT

        String text; // storing input
        ArrayList<String> letters = new ArrayList<>(); // creating array list for storing letters of the input

        Scanner input = new Scanner(System.in); // creating scanner for inputs

        System.out.println("\nENCODING\n--------"); // sending what we do

        System.out.println("You need to input the text which you want to encode.\n"); // asking for the input
        System.out.print("\nInput: "); // field for the input

        try{ // trying to catch any errors

            text = input.nextLine(); // getting text which we need to encode

        
        // END OF THE FIRST PART
        //-----------------------------------------------------------------------------
```

- **Second part** is all about connecting other functions from this file to get coded string. First of all, I gets all the letters from the input by using function getting letter. Then I collect values from the ***MorseCode.txt*** and put them to the MAP in the format ***“SYMBOL”=”CODDED VERSION”*** . After this I call getting_result function which takes letters and morse map as arguments. It goes through the letter and finds their value in the ***morse_code_dictionary***. If there is coded value for the symbol, then I add it’s coded version to the result, if not - I add just *“ / “* which is space.

```java
     	  try{ // trying to catch any errors

            text = input.nextLine(); // getting text which we need to encode

        
        // END OF THE FIRST PART
        //-----------------------------------------------------------------------------

        //-----------------------------------------------------------------------------
        // SECOND PART - TO ENCODE INPUT

            letters = getting_letter(text); // getting all the symbols from the input

            Map<String, String> morse_code_dictionary = new HashMap<String, String>(); // creating MAP to store symbols and their morse codes 

            morse_code_dictionary = creating_morse_map(); // putting all the values into the map

            String result = getting_result(letters, morse_code_dictionary); // getting coded string

            System.out.print("\nResult: "); // outputting result

            System.out.println(result); // outputting result

        } catch (Exception e){ // if there is anything that cannot be encoded, error appears 

            // sending a message about an error
            System.out.println("\nSorry, but you have used symbols which are not represented in the MorseCode.txt .\nYou can add them by using command number 3.");
            System.exit(0); // terminating program

        }

        // END OF THE SECOND PART
        //-----------------------------------------------------------------------------
```

***Code of the encode.java **file:**

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class encode {
    
    public static void encoding_function(){

        //-----------------------------------------------------------------------------
        // FIRST PART - ASKING USER TO INPUT TEXT

        String text; // storing input
        ArrayList<String> letters = new ArrayList<>(); // creating array list for storing letters of the input

        Scanner input = new Scanner(System.in); // creating scanner for inputs

        System.out.println("\nENCODING\n--------"); // sending what we do

        System.out.println("You need to input the text which you want to encode. ( all the unknown values will be encoded as spaces\n"); // asking for the input
        System.out.print("\nInput: "); // field for the input

        try{ // trying to catch any errors

            text = input.nextLine(); // getting text which we need to encode

        
        // END OF THE FIRST PART
        //-----------------------------------------------------------------------------

        //-----------------------------------------------------------------------------
        // SECOND PART - TO ENCODE INPUT

            letters = getting_letter(text); // getting all the symbols from the input

            Map<String, String> morse_code_dictionary = new HashMap<String, String>(); // creating MAP to store symbols and their morse codes 

            morse_code_dictionary = creating_morse_map(); // putting all the values into the map

            String result = getting_result(letters, morse_code_dictionary); // getting coded string

            System.out.print("\nResult: "); // outputting result

            System.out.println(result); // outputting result

        } catch (Exception e){ // if there is anything that cannot be encoded, error appears 

            // sending a message about an error
            System.out.println("\nSorry, but you have used symbols which are not represented in the MorseCode.txt .\nYou can add them by using command number 3.");
            System.exit(0); // terminating program

        }

        // END OF THE SECOND PART
        //-----------------------------------------------------------------------------
        

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

}
```

### DECODING:

- Basically, the only difference between decoding and encoding appeared to be the Morse Map. So I have made change in the creating_morse_map() - now key is coded data or morse code and value is a letter. Also, I have changed function getting_result as it was impossible for me to catch the code of the space ( / ), so all the null values ( unknown or just space ), will be spaces in the final result.
- It appeared that I had needed to change Morse file a little bit just to delete all the spaces after each coded value.

 

```java
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
```

### QUIZ

- First of all, I made a function that provides opportunity to a user to choose what he wants to do ( 1 - do a quiz or 2 - check scoreboard ). I have copied input request from the starter function ( check above ) and changed some parameters. But the idea is the same.

```java
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
```

- Doing scoreboard was quit easy, first of all I am parsing file called results.txt to get all the user’s results. Then I put all of them into ArrayList with double values ( as always score looks like 1/3 which is 33.3333 ). After this I am using sorting function and then reverse sorted ArrayList as values are from lowest to the highest result in the sorted array. Then I just print every value.

```java
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
```

- Quiz function was much harder to create. The idea of this function is to get user’s input for the randomly chosen words and then compare them to the right answer. For this reasons, I create 2 maps one of which will store randomly chosen word and user’s input and another will store the same word but right encoded version of it.
- Firstly, I asks user how many words does he want to guess , then I creates an array of the words from the file and randomly picks them. After this I go through this words and collect user’s answers.
- Then I compare user’s version with the right one using  STR.equals(STR) as I CANNOT CANNOT CANNOT CANNOT COMPARE LOVELY STRINGS WITH LOVELY =
- After this I calls function which adds score to the results.txt

```java
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
```

- All other functions were taken from the parts above, so explanations to them you can find above.

q[**uiz.jav**a](http://Quiz.java) code:

```java
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
```

### ADDING NEW MORSE CODE

- First of all, I print rules for the user, just to try reduce any dumb mistakes. Then I get “symbol” and “morse code” from the user.
- I get all the symbols from the MorseCode.txt to then check is the symbol which user wants to add already in the file. If it is, I send a message to the user about this. If not, then I calls function which will add value to the file.

```java
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
```

- In this function I just write to the file in the format - *symbol : code*

```java
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
```

- Explanations to the other functions in the file can be found in other parts as they have been already used.

**Full code:**

```java
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
```

---

## Pseudocode:

---

base.java:

```python
DECLARE first_choice : INTEGER
DECLARE first_choice_try : BOOLEAN
first_choice <-- 0
first_choice_try <-- TRUE

REPEAT
   IF first_choice_try <> TRUE THEN
      OUTPUT "WRONG VALUE, TRY AGAIN!"
   INPUT first_choice
   first_choice_try <-- FALSE
UNTIL first_choice < 1 OR first_choice > 4

IF first_choice = 1 THEN
    CALL encode.encoding_function()
ELSE
    IF first_choice = 2 THEN
        CALL decode.decoding_function()
    ENDIF
ELSE
    IF first_choice = 3 THEN
        CALL add_morse.adding_morse_function()
    ENDIF
ELSE
    IF first_choice = 4 THEN
        CALL quiz.quiz_choose_function()
    ENDIF
ENDIF
```

decode.java:

```python
PROCEDURE decoding_function()
    DECLARE text : STRING
    INPUT text
    DECLARE letters : ARRAY[1:LENGTH(text)] OF STRING
    letters <-- getting_letter(text)
    DECLARE morse_code_dictionary : MAP<STRING< STRING>
    morse_code_dictionary <-- creating_morse_map()
    DECLARE result : STRING
    result <-- getting_result(letters, morse_code_dictionary)
    OUTPUT result
ENDPRODCEDURE

FUNCTION getting_result(letter_result : ARRAY[1:] OF STRING, code : Map<String, String>) RETURNS STRING
    DECLARE result : STRING
    DECLARE n : STRING
    FOR i <-- 1 TO LENGTH(letter_result) 
            n <-- code.get(letter_result[i])
            IF n = null THEN
                n <-- " "
            ENDIF
            result = result & n
     NEXT i
     RETURN result;
ENDFUNCTION

FUNCTION getting_letter(txt : STRING) RETURNS ARRAY[:] OF STRING
    DECLARE result : ARRAY[1:LENGTH(txt)] OF STRING
    FOR i <-- 1 TO LENGTH(txt)
        result[i] <-- MID(txt, i, 1)
    NEXT i
    RETURN result
ENDFUNCTION

FUNCTION creating_morse_map() RETURNS MAP<STRING, STRING>
    DECLARE result : MAP<STRING, STRING>
    DECLARE LineOfText : STRING
    OPENFILE "MorseCode.txt" FOR READ
    WHILE NOT EOF("MorseCode.txt")
        READFILE "MorseCode.txt", LineOfText
        result.put(LineOfText.split(" : ")[1], LineOfText.split(" : ")[0])
    ENDWHILE
    CLOSEFILE "MorseCode.txt"
    RETURN result
ENDFUNCTION
```

encode.java:

```python
PROCEDURE encoding_function()
    DECLARE text : STRING
    INPUT text
    DECLARE letters : ARRAY[1:LENGTH(text)] OF STRING
    letters <-- getting_letter(text)
    DECLARE morse_code_dictionary : MAP<STRING< STRING>
    morse_code_dictionary <-- creating_morse_map()
    DECLARE result : STRING
    result <-- getting_result(letters, morse_code_dictionary)
    OUTPUT result
ENDPRODCEDURE

FUNCTION getting_result(letter_result : ARRAY[1:] OF STRING, code : Map<String, String>) RETURNS STRING
    DECLARE result : STRING
    DECLARE n : STRING
    FOR i <-- 1 TO LENGTH(letter_result) 
            n <-- code.get(letter_result[i])
            IF n <> null THEN
                result <-- result & n & " "
            ELSE 
                result <-- result & "/ "
            ENDIF
     NEXT i
     RETURN result;
ENDFUNCTION

FUNCTION getting_letter(txt : STRING) RETURNS ARRAY[:] OF STRING
    DECLARE result : ARRAY[1:LENGTH(txt)] OF STRING
    FOR i <-- 1 TO LENGTH(txt)
        result[i] <-- MID(txt, i, 1)
    NEXT i
    RETURN result
ENDFUNCTION

FUNCTION creating_morse_map() RETURNS MAP<STRING, STRING>
    DECLARE result : MAP<STRING, STRING>
    DECLARE LineOfText : STRING
    OPENFILE "MorseCode.txt" FOR READ
    WHILE NOT EOF("MorseCode.txt")
        READFILE "MorseCode.txt", LineOfText
        result.put(LineOfText.split(" : ")[0], LineOfText.split(" : ")[1])
    ENDWHILE
    CLOSEFILE "MorseCode.txt"
    RETURN result
ENDFUNCTION
```

quiz.java:

```python
PROCEDURE quiz_function()
    DECLARE right_answers : Map<STRING, STRING>
    DECLARE user_answers : Map<STRING, STRING>
    DECLARE num_of_words : INTEGER
    num_of_words <-- 0
    DECLARE int_random : INTEGER
    INPUT num_of_words
    DECLARE words : ARRAY[1:3116] OF STRING
    words <-- getting_words_from_file()
    DECLARE test : ARRAY[1:num_of_words] OF STRING
    FOR i <-- 0 TO num_of_words
        int_random <-- RANDOM_NUMBER_FROM(1, 3116)
        test[i] <-- words[int_random)
    NEXT i
    FOR i <-- 0 TO num_of_words
        right_answer.put(test[i], encoding_function(test[i]))
    NEXT i
    DECLARE res : STRING
    FOR i <-- 0 TO num_of_words
        INPUT res
        user_answer.put(test[i], res))
    NEXT i
    FOR i <-- 0 TO num_of_words
        IF user_answer.get(test[i]) = right_answer.get(test[i]) THEN
            score <-- score + 1
        ENDIF
    NEXT i
    CALL adding_result_file(score / 1.0 / num_of_words * 100.0)
ENDPROCEDURE

PROCEDURE adding_result_file(score : REAL)
		OPENFILE "results.txt" FOR WRITE
		WRITEFILE "FileB.txt", score
		CLOSEFILE "results.txt"
ENDPROCEDURE

FUNCTION getting_words_from_file() RETURNS ARRAY[1:3116] OF STRING
    DECLARE count : INTEGER
    count <-- 1
    DECLARE result : ARRAY[1:3116] OF STRING
		DECLARE LineOfText : STRING
		OPENFILE "WordsForMorse.txt" FOR READ
		WHILE NOT EOF("WordsForMorse.txt")
				READFILE "WordsForMorse.txt", LineOfText
        result[count] <-- LineOfText
        count <-- count + 1
		ENDWHILE
		CLOSEFILE "WordsForMorse.txt"
    RETURN result
ENDFUNCTION

FUNCTION encoding_function(text : STRING) RETURNS STRING
    DECLARE letters : ARRAY[1:LENGTH(text)] OF STRING
    letters <-- getting_letter(text)
    DECLARE morse_code_dictionary : MAP<STRING< STRING>
    morse_code_dictionary <-- creating_morse_map()
    DECLARE result : STRING
    result <-- getting_result(letters, morse_code_dictionary)
    RETURN result
ENDFUNCTION

FUNCTION getting_result(letter_result : ARRAY[1:] OF STRING, code : Map<String, String>) RETURNS STRING
    DECLARE result : STRING
    DECLARE n : STRING
    FOR i <-- 1 TO LENGTH(letter_result) 
            n <-- code.get(letter_result[i])
            IF n <> null THEN
                result <-- result & n & " "
            ELSE 
                result <-- result & "/ "
            ENDIF
     NEXT i
     RETURN result;
ENDFUNCTION

FUNCTION getting_letter(txt : STRING) RETURNS ARRAY[:] OF STRING
    DECLARE result : ARRAY[1:LENGTH(txt)] OF STRING
    FOR i <-- 1 TO LENGTH(txt)
        result[i] <-- MID(txt, i, 1)
    NEXT i
    RETURN result
ENDFUNCTION

FUNCTION creating_morse_map() RETURNS MAP<STRING, STRING>
    DECLARE result : MAP<STRING, STRING>
    DECLARE LineOfText : STRING
    OPENFILE "MorseCode.txt" FOR READ
    WHILE NOT EOF("MorseCode.txt")
        READFILE "MorseCode.txt", LineOfText
        result.put(LineOfText.split(" : ")[0], LineOfText.split(" : ")[1])
    ENDWHILE
    CLOSEFILE "MorseCode.txt"
    RETURN result
ENDFUNCTION
```

add_morse.java:

```python
PROCEDURE adding_morse_function()
    DECLARE symbol : STRING
    DECLARE code : STRING
    INPUT symbol
    INPUT code
    CALL adding_new_code_function(symbol, code)
ENDPROCEDURE

PROCEDURE adding_new_code_function(symbol : STRING, code : STRING)
    DECLARE LineOfText : STRING
    OPENFILE "MorseCode.txt" FOR READ
    OPENFILE "FileB.txt" FOR WRITE
    WHILE NOT EOF("MorseCode.txt")
        READFILE "MorseCode.txt", LineOfText
        WRITEFILE "FileB.txt", LineOfText
    ENDWHILE
    CLOSEFILE "FileA.txt"
    CLOSEFILE "FileB.txt"
    OPENFILE "MorseCode.txt" FOR WRITE
    OPENFILE "FileB.txt" FOR READ
    WHILE NOT EOF("FileB.txt")
        READFILE "FileB.txt", LineOfText
        WRITEFILE "MorseCode.txt", LineOfText
    ENDWHILE
    WRITEFILE "MorseCode.txt", symbol & " : " & code
    CLOSEFILE "FileA.txt"
    CLOSEFILE "FileB.txt"
ENDPROCEDURE
```

---

## Description of the project:

---

![Untitled](Morse%20CS%20Project%20b3a750da0cc44aa1818aec459e26735d/Untitled.png)

Main file of the project is [base.java](http://base.java) ; other java files are made just to make code look better and more readable. In the project I have done new for me things, which are - working with “map” and working with files ( reading and writing ). 

Talking about extensions, I have done :

- A means by which to save high scores for the test to a text file – only the top five high scores should be saved.
- A test, in which users are either presented with 4 letter words, and asked to input the correct morse translation of these, or presented with a 4 letter morse code, and asked to translate it back into a word. These words should be read in from the attached WordsForMorse.txt text file.

Which are being shown in the [quiz.java](http://quiz.java) file.

---

## Feelings:

---

I think this project was not much, but easier than the previous one. However, in the beginning it was really confusing as I had no clue about the Morse Code.

I really believe that I have done this project much better than the previous one as I have analysed previous report and tried to fix all the issues. So, now my documentation looks way better and more complex, as the peaces of code are explained and shown in a good format next to each other, so it is easier to understand all the functions. Also, I have commented EVERY line of code, and at this time they are not as useless as they were before. The structure, in my opinion stays good from project to project and the code is clear. Also, I have improved OUTPUT, so it is more obvious for user what to do. Moreover, number of errors and possible mistakes was reduced, I HOPE SO.

However, on the other hand, some of the functions were used more than one time in the different files, so it is not very good to duplicate the same code as it loads system. Also, my pseudocode is not really decent because it is hard to work with the files  and maps ( which are not even presented in the pseudocode ), so probably the biggest disadvantage of my project is in the heart of pseudocode.

All in all, I think that I did pretty good in this project.