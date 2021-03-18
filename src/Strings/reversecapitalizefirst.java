package Strings;

import java.util.Scanner;

public class reversecapitalizefirst {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        System.out.print("Input a Sentence: ");
        String line = in.nextLine();
        String[] words = line.split(" ");
        String reverseString = "";
        String capitalizeWord="";
        for(int i=0;i<words.length;i++)
        {
            String word = words[i];
            String reverseword = "";
            for(int j=word.length()-1;j>=0;j--)
            {
                reverseword = reverseword + word.charAt(j);
            }
            String first=reverseword.substring(0,1);
            String afterfirst=reverseword.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst+ " ";
            reverseString = reverseString + capitalizeWord + " ";
        }


        System.out.println(reverseString);

    }

}
