package com.mycompany.test;
import java.util.Scanner;

public class Test {

    public static String shiftCharacters(String input, int shift) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char shiftedChar = (char) ((c - base + shift + 26) % 26 + base);
                output.append(shiftedChar);
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }

    public static int calculateShift(String text, char targetChar) {
        int[] frequency = new int[26]; 


        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowerChar = Character.toLowerCase(c);
                frequency[lowerChar - 'a']++; 
            }
        }


        int max = 0;
        for (int i = 1; i < frequency.length; i++) {
            if (frequency[i] > frequency[max]) {
                max = i;
            }
        }

        char mostFrequentChar = (char) (max + 'a');

        return (mostFrequentChar - targetChar + 26) % 26;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Entrer le texte : ");
        String text = input.nextLine();

        int shift = calculateShift(text, 'e');

        String result = shiftCharacters(text, -shift); 
        
        System.out.println("Le décalage calculé est : " + shift);
        System.out.println("Le résultat déchiffré est : " + result);
    }
}
