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
        System.out.println("1. Encode a plain text to The Morse Code\n2. Decode The Morse Code to a plain text\n3. Add new specific Morse codes\n4. Quiz\n\n"); // explanation to user
        System.out.print("Input: "); // asking to choose what will program need to do ( MUST BE INTEGER )

        
        while ( first_choice < 1 || first_choice > 4){ // user must input 1, 2 or 3 or 4 to go further 
 
            try{ // catching errors ( wrong input )

                if (first_choice_try != true){ // if it is not the first try, I need to print out another text to the user

                    System.out.print("\nWrong value! Your input must be 1 , 2, 3 or 4!\n\nTry again: "); // printing text

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
        else if ( first_choice == 4){ // Add new specific Morse codes

            quiz.quiz_function(); // calling adding to morse function

        }

        // END OF THE SECOND PART
        //-----------------------------------------------------------------------------



    }
}