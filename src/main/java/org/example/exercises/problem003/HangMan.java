package org.example.exercises.problem003;

/*
Codigo para jugar el juego del ahorcado en la consola de java
Creado por Jair Chavez Islas
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the game!");

        List<String> words = null;
        //words es un archivo txt que contiene las palabras que se pueden adivinar, se pueden agregar palabras cuantas quieran
        //El archivo los va a lleer y se va a elegir una aleatoriamente
        try{
            words = Files.readAllLines(Path.of("src/main/resources/words.txt"));
        }catch (IOException e){
            System.out.println("File not found! Trying to read: " + Paths.get("../../resources/words.txt").toAbsolutePath());

            System.exit(0);
        }

        Random random = new Random();
        String secretWord = words.get(random.nextInt(words.size()));

        int maxTries = 6;

        char[] guessedWord = new char[secretWord.length()];
        for(int i = 0; i < secretWord.length(); i++){
            guessedWord[i] = '_';
        }

        playGame(maxTries, secretWord, guessedWord, maxTries, scanner);

        scanner.close();


        System.out.println("Hello world!");
    }

    static void playGame(int maxTries, String secretWord, char[] guessedWord, int triesRemaining,Scanner scanner) {
        if (triesRemaining > 0) {
            System.out.println("Word: ");
            for (char letra : guessedWord) {
                System.out.print(letra + " ");
            }
            System.out.println("\nTries remaining: " + triesRemaining);

            char inputLetter = obtainValidLetter(scanner);

            boolean letterFound = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == inputLetter) {
                    guessedWord[i] = inputLetter;
                    letterFound = true;
                }
            }

            if (letterFound) {
                System.out.println("Letter found!");
            } else {
                System.out.println("Letter not found!, you lose a try!");
                triesRemaining--;
            }

            showGameStatus(maxTries - triesRemaining);

            boolean completeWordFound = true;
            for (char letra : guessedWord) {
                if (letra == '_') {
                    completeWordFound = false;
                    break;
                }
            }

            if(completeWordFound){
                System.out.println("You win!, the word was: " + secretWord);
            }else{
                playGame(maxTries, secretWord, guessedWord, triesRemaining, scanner);
            }
        }else
        {
            System.out.println("You lose!, the word was: " + secretWord);
        }
    }

    public static void showGameStatus(int triesRemaining)
    {
        System.out.println("\n hangman status: ");

        switch(triesRemaining)
        {
            case 1:
                System.out.println("  o  ");
                break;
            case 2:
                System.out.println("  o  ");
                System.out.println("  |  ");
                break;
            case 3:
                System.out.println("  o  ");
                System.out.println(" /|  ");
                break;
            case 4:
                System.out.println("  o  ");
                System.out.println(" /|\\ ");
                break;
            case 5:
                System.out.println("  o  ");
                System.out.println(" /|\\ ");
                System.out.println(" /   ");
                break;
            case 6:
                System.out.println("  o  ");
                System.out.println(" /|\\ ");
                System.out.println(" / \\ ");
                break;
            default:
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                break;
        }

    }

    public static char obtainValidLetter(Scanner scanner)
    {
        while(true)
        {
            System.out.println("Enter a letter: ");
            String input = scanner.next().toUpperCase();

            if(input.length() == 1 && Character.isLetter(input.charAt(0)))
            {
                return input.charAt(0);
            }else
            {
                System.out.println("Invalid input, try again!");
            }
        }
    }

}