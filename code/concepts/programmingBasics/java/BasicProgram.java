/******************************************************************************
 * @author : lifelonglearnerPM
 * @link : https://github.com/lifelonglearnerPM
 *
 * Java Programming Basics
 * datatypes
 * for loop
 * operations
 * typecast
 *
 *******************************************************************************/

import java.util.Arrays;

public class Main 
{
    public static final double PI = 3.14159; // declare global constant

    public static void main(String[] args) 
    {
        System.out.print("Message : ");
        System.out.println("Padma Hello Java");
        
        //primitive datatypes : : datatype[] variable_name = initialization;
        byte age = 33; // 1 byte : -128 to 128
        int  income = 387343; // 4 bytes
        float tax = 18.5F; //18.5f;// 4 bytes
        long phone = 91929037832L; // 92903l; // 8 bytes
        double mfReturns = 92903.463646; //8 bytes
        char uniCode = '@'; // 2 bytes
        boolean isTrue = true; // true or flase
        
        final int MAX_VALUE = 100; // declare class level constant
        
        //Non primitive datatypes
        
        //Array : datatype[] variable_name = initialization;
        int[] numbers = {1, 5, 8, 3, 2};
        
        int[] oldNumbers = {1, 4, 3};
        int[] newNumbers = new int[oldNumbers.length + 2]; // Create a new array with bigger size

        System.arraycopy(oldNumbers, 0, newNumbers, 0, oldNumbers.length); // Copy elements
        oldNumbers = newNumbers; // Reassign the reference variable
        
        newNumbers[3] = 8; // modify or access using index
        
        System.out.println("Printing array of size " + newNumbers.length);
        for (int num : newNumbers)
        {
            System.out.print(num +" ");
        }
        System.out.println();
        
        // search elements in Array
        
        
        //sort Array
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.print(numbers[i] +" ");
        }
        System.out.println();
        
        // Array with "new" 
        int[] nums = new int[10]; // Array of 10 integers
        String[] names = new String[5]; // Array of 5 strings
        
        //ArrayList : Dynamic Array
        
        //String
        String name = "Shrilakshmi";
        System.out.println("length of name : "+ name.length());
        String lastName = "ShriKrshna";
        System.out.println("length of last name : "+ lastName.length());
        String fullname = name+lastName; // string concatenation
        System.out.println(fullname);
        System.out.println(fullname.charAt(10));
        String nickNameHome = name; // string assignment
        String example = "apple";
        String nickNamePal = example.replace("le","lication");
        String nickNameBuddy = nickNamePal.replace("lication","");
        System.out.println(nickNameHome);
        System.out.println(nickNamePal);
        System.out.println(nickNameBuddy);
        String funny1 = "Mar Java";
        String funny2 = "Mit Java";
        System.out.println(funny1+" "+funny2);
        
        // extract "Java" substring from a given string
        int left = 4; // start from pos = 4
        int right = 8; // till 7 excludes 8
        String subString1 = funny1.substring(left,right);
        System.out.println(subString1);
        
        //If the substring is found, indexOf() returns the index, otherwise, it returns -1. 
        int index = funny2.indexOf("Java");
        if (index != -1) 
        {
            System.out.println("Java String found at pos "+index);
        }
        else
        {
            System.out.println("Java String not found");
        }
        
        // contains() returns true if the substring is present, and false otherwise
        if (nickNamePal.contains("abc"))
        {
            System.out.println("abc String found");
        }
        else
        {
            System.out.println("abc String not found");
        }
        
        
    }
}