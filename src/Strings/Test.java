package Strings;

import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String value ="abcdef";
        parenthesis(value);

    }

    private static void parenthesis(String value) {
        // TODO Auto-generated method stub

        char arr[] = value.toCharArray();
        int i=0, j = arr.length-1;
        while(i<j)
        {
            //System.out.print(arr[i]);
            if(!Character.isAlphabetic(arr[i])){
                i++;
            }
            else if(!Character.isAlphabetic(arr[j]))
                    j--;
            else {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;

            }

        }
        for(int k=0;k<value.length();k++)
            System.out.print(arr[k]);
//        String arr2 = arr.toString();
//        for(i=0;i<arr2.length();i++)
//            System.out.print(arr2.charAt(i));


    }

}
