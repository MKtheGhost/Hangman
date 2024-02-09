import src.Hangman;
import src.Error;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

class App {

    final static int NB_MOT_DICO = 835;

    public static void main(String [] args){

        String mot = "";
        int count = 0;
        Random rand = new Random();
        int randomWord = rand.nextInt(NB_MOT_DICO);

        try{
            BufferedReader br = new BufferedReader(new FileReader("pendu.txt"));

            while (count != randomWord){
                mot = br.readLine();
                count++;
            }
            br.close();
        }
        catch (Exception e){
            System.out.println("error in the exception");
        }

        Hangman game = new Hangman(mot);
        Scanner sc = new Scanner(System.in);

        //while the game is still going on
        while (!game.win() && !game.lose()){

            //ask the player to guess a letter
            System.out.print("Saisissez une lettre >> ");

            //get the letter inputed by the user
            String letter = sc.nextLine();

            //put the letter inputed into the already guessed array
            game.addChar(letter);


            //print out the result of the guess
            if (game.play(letter.charAt(0))){
                System.out.println("*la lettre est présente*");
            }
            else{
                System.out.println("*la lettre n'est pas présente*");
            }

            // print out the state of the game
            switch (game.getErrorCount()){
    
                case 1 : Error.error1();
                break;
    
                case 2 : Error.error2();
                break;
    
                case 3 : Error.error3();
                break;
    
                case 4 : Error.error4();
                break;
    
                case 5 : Error.error5();
                break;
    
                case 6 : Error.error6();
                break;
    
                case 7 : Error.error7();
                break;
    
                case 8 : Error.error8();
                break;
    
                case 9 : Error.error9();
                break;
    
                case 10 : Error.error10();
                break;
    
                default : Error.error0();
    
            }

            System.out.println(System.lineSeparator());

            //print out the current state of the word being guessed
            for (int i = 0; i < game.wordLength(); i++){
                if (game.letterStatus(i)){
                    System.out.print(game.letterAtIndex(i));
                }
                else{
                    System.out.print(" _ ");
                }
            }
            System.out.println("");
            System.out.println(System.lineSeparator());

            //print out the letters that has already been guessed
            game.printList();
        }
        sc.close();

        if (game.win()){
            System.out.println("***Bravo! Vous avez gagné!***");
        }
        if (game.lose()){
            System.out.println("***Bouhhhh... Vous avez perdu...***");
            System.out.println("le mot est : " + mot );
        }
        System.out.println(System.lineSeparator());

        
    }
    
}
