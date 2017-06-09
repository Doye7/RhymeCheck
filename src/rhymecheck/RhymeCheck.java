/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rhymecheck;
import java.util.*;

/**
 *
 * @author Doye
 */
public class RhymeCheck {

    static String inputWordArray[] = {"Crime","Battle","Fright","Blight","Mat","Running","Punch","Right","Tight"};
    static ArrayList<String> outputWordArrayList = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // outputWordArrayList.add("test");
        //System.out.println(outputWordArrayList);
        arrayComparison();
       
    }
    private static String getRhymeSound(String inputWord){
        // If the last character is a vowel
          if (isVowel(inputWord.toLowerCase().charAt(inputWord.length() -1))){
            // Return the rhyme section of the word
            return getRhymeVowelEnd(inputWord);
        // If the last character is not a vowel
        }else{
            // Return the rhyme section of the word
            return getRhymeConEnd(inputWord);
            
        }  
    }
    
    private static String getRhymeVowelEnd(String wordIn){
        // Find the rhyming part of the word, starting from the last character and moving inwards
        int wordIndex = wordIn.length() - 1;
        String wordBuild = "";
        // Add to the String all vowels at the end of a word, "Terrible" would be "e"
        while (wordIndex > 0 & isVowel(wordIn.toLowerCase().charAt(wordIndex))){
            wordBuild = wordIn.charAt(wordIndex) + wordBuild;
            wordIndex--;
        }
        // Add to the String all consonants after the vowels, "Terrible" would be "bl"
        while (wordIndex > 0 & !isVowel(wordIn.toLowerCase().charAt(wordIndex))){
            wordBuild = wordIn.charAt(wordIndex) + wordBuild;
            wordIndex--;
        }
        // Finally add vowles following the consonants, "Terrible" would be "i"
        while (wordIndex > 0 & isVowel(wordIn.toLowerCase().charAt(wordIndex))){
            wordBuild = wordIn.charAt(wordIndex) + wordBuild;
            wordIndex--;
        }
        // Terrible would return "ible"
        return wordBuild;
    }
    
    private static String getRhymeConEnd(String wordIn){
        // As with getRhymeVowelEnd but starting with consonants instead
        int wordIndex = wordIn.length() - 1;
        String wordBuild = "";
        while (wordIndex > 0 & !isVowel(wordIn.toLowerCase().charAt(wordIndex))){
            wordBuild = wordIn.charAt(wordIndex) + wordBuild;
            wordIndex--;
        }
        while (wordIndex > 0 & isVowel(wordIn.toLowerCase().charAt(wordIndex))){
            wordBuild = wordIn.charAt(wordIndex) + wordBuild;
            wordIndex--;
        }
        // Only executes if the word length > 5 as an approximation of sylable count
        if(wordIn.length() > 6){
            while (wordIndex > 0 & !isVowel(wordIn.toLowerCase().charAt(wordIndex))){
                wordBuild = wordIn.charAt(wordIndex) + wordBuild;
                wordIndex--;
            }
        }
        // "Atlantis" returns "ntis", "Tram" returns "am"
        return wordBuild;
        
    }
        
    
    private static boolean isVowel(char charIn){
        // Test if the character is a vowel
        boolean charIsVowel = (charIn == 'e' || charIn == 'a' || charIn == 'i' || charIn == 'o' || charIn == 'u');
        return charIsVowel;
    }
    
    private static void compareAndPrintTwoInputs(){
        // Takes 2 inputs, and tests if they rhyme
                Scanner input = new Scanner(System.in);
        
        String wordA;
        String wordB;
        
        // Get inputs
        System.out.print("Enter the first word: ");
        wordA = input.next();
        System.out.print("Enter the second word: ");
        wordB = input.next();
        // Compare the 2 Rhyme sections of the words and print the output
        if (getRhymeSound(wordA.toLowerCase()).equals(getRhymeSound(wordB.toLowerCase()))){
            System.out.println("\n" + wordA + " does rhyme with " + wordB);
        }else{
            System.out.println("\n" + wordA + " does not rhyme with " + wordB);
        }
        
    }
    
    private static void createOutputArrayList(String inputWord){
        // For each word in the array, compare its rhyme to the input word
        for (int i = 0; i < inputWordArray.length; i++){
            // If true, add the word to the output
            if (compareToArray(inputWord, i)){
                outputWordArrayList.add(inputWordArray[i]);
            }
        }
    }
    
    private static boolean compareToArray(String inputWord, int index){
        // If the rhyme sound of the input word is equal to the word in the array, return true
       return getRhymeSound(inputWord.toLowerCase()).equals(getRhymeSound(inputWordArray[index].toLowerCase()));
    }
    
    private static void printStringArrayList(){
        System.out.println(outputWordArrayList);
//        for (int i = 0; i < outputWordArrayList.size(); i++){
//            System.out.println(outputWordArrayList.get(i));
//        }       
        
    }
    private static void arrayComparison(){
        System.out.print("Enter a word: ");
        Scanner input = new Scanner(System.in);
        String inputWord = input.next();
        createOutputArrayList(inputWord);
        printStringArrayList();
    }
}
