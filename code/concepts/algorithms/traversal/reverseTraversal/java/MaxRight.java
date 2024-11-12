/******************************************************************************
 * @author : lifelonglearnerPM
 * @link : https://github.com/lifelonglearnerPM
 *
 * Given an array of integers, the goal is to replace each element with the 
 * maximum value of the elements to its right in the array.
 *
 *******************************************************************************/

public class MaxRight
{
    public static int[] replaceWithMaxRight(int[] input)
    {
        int[] result = input;

        /*
        for (int j : result)
            System.out.print(j+ " ");
            System.out.println();
        */

        int currMax = input[result.length - 1];
        //System.out.println("currMax = "+ currMax);
        for (int i= input.length-2; i >= 0 ; i--) {
            //System.out.println();
            if (currMax < input[i]) {
                currMax = input[i];
                //System.out.println("currMax = "+ currMax);
            }
            result[i] = currMax;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input1 = {-10, 5, -20, 3};
        int[] result1 = replaceWithMaxRight(input1);

        System.out.print("Result : ");
        for (int i : result1)
            System.out.print(i+ " ");
        System.out.println();


        int[] input2 = {5, 6, 9, 2};
        int[] result2 = replaceWithMaxRight(input2);

        System.out.print("Result : ");
        for (int i : result2)
            System.out.print(i+ " ");
        System.out.println();
    }
}