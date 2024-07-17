/******************************************************************************
 * @author : lifelonglearnerPM
 * @link : https://github.com/lifelonglearnerPM
 *
 * Different Questions on Palindrome
 *
 *******************************************************************************/

public class Palindrome
{
    public static boolean isPalindrome (String input)
    {
        // Edge case : Empty input
        if (input == null) // if (input.length() == 0)
            return false;
        
        /*
         * replaceAll("[^a-zA-Z0-9]", ""): This method call uses regular expressions (regex) to 
         * replace all characters that are not ([^...]) alphanumeric (a-zA-Z0-9) with an empty string ("").
         */
        String cleanStr = input.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        
        // two-pointer method
        int left = 0;
        int right = cleanStr.length()-1;

        while (left < right)
        {
            if (cleanStr.charAt(left) != cleanStr.charAt(right))
                return false;
            left++;
            right--;
        }
        
        return true;
    }
    
    public static String breakPalindrome (String inPalindrome)
    {
        String err = "Not possible";
        String result = inPalindrome;
        
        return err;
    }
    
    public static void main(String[] args) {
        
        System.out.println(isPalindrome("race car"));
    }
}
