/******************************************************************************
Problem Statement:
You are given an array "input" where "input[i]" represents the height of a line at position i. 
The width of each bar is 1. 
Compute the maximum area of water that can be trapped between the bars after a flood fill.

*******************************************************************************/

public class MaxAreaWaterFill
{
    public static int maxAreaWaterFill (int[] input)
    {
        int left = 0;
        int right = input.length -1;
        
        int maxArea = 0;
        
        while (left < right)
        {
            // input is height array
            //area of rectangle bredth  * height 
            int currArea = (right-left) * Math.min (input[left], input[right]);
            maxArea = Math.max(currArea,maxArea);
            
            if (input[left] < input[right]) left++;
            else right--;
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] data1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] data2 = {5};
        int[] data3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(maxAreaWaterFill(data2));
    }
}