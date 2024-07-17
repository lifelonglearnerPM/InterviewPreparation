/******************************************************************************

Different Questions on Palindrome

*******************************************************************************/
public class Palindrome
{
    public static boolean isPalindrome (String input)
    {
        if (input == null) // if (input.length() == 0)
            return false;
        
        String cleanStr = input.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        
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
    
    
	public static void main(String[] args) {
		System.out.println(isPalindrome("race car"));
	}
}
