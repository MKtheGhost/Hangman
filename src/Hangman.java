package src;

import java.util.ArrayList;
import java.util.Arrays;

public class Hangman {
    static final int MAX_ERROR_COUNT = 10;
    String word;
    boolean lettersFound[];
    int errorCount;
    ArrayList<String> lettersGuessed;

    //initialize game data in order to play
    public Hangman(String mot){
        this.word = mot;
        errorCount = 0;
        lettersFound = new boolean[mot.length()];
        Arrays.fill(lettersFound, false);
        lettersGuessed = new ArrayList<>();
        
    }

    //check if the letter guessed by the player is present in the word. 
    public boolean play(char lettreSaisie){
        boolean estJouable = false;
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == lettreSaisie){
                estJouable = true;
                lettersFound[i] = true;
            }
        }

        if (!estJouable){
            errorCount += 1;
        }

        return estJouable;
    }

    //check if the game has been won
    public boolean win(){
        for (int i = 0; i < word.length(); i++){
            if (!lettersFound[i]){
                return false;
            }
        }
        return true;
    }

    //check if the game has been lost
    public boolean lose(){
        if (errorCount == MAX_ERROR_COUNT){
            return true;
        }
        return false;
    }

    //return the length of the word
    public int wordLength(){
        return word.length();
    }

    //return the found status of the letter at a specific position
    public boolean letterStatus(int i){
        return lettersFound[i];
    }

    //return the letter at specific position of the word
    public char letterAtIndex(int i){
        return word.charAt(i);
    }

    //return the number of error that has been made
    public int getErrorCount(){
        return errorCount;
    }

    //add a char into the letters guessed array
    public void addChar(String c){
        lettersGuessed.add(c);
    }

    //print out the elements in the list
    public void printList(){
        System.out.print("lettres saisies : ");
        for (int i = 0; i < lettersGuessed.size(); i++){
            System.out.print(lettersGuessed.get(i));
            System.out.print(" ");
        }
        System.out.println("\n");
    }


    
}
