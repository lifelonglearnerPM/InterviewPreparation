/******************************************************************************
 * @author : lifelonglearnerPM
 * @link : https://github.com/lifelonglearnerPM
 *
 * Given an array of integers, the goal is to replace each element with the 
 * maximum value of the elements to its right in the array.
 *
 *******************************************************************************/

def replaceWithMaxRight(arr):
    n = len(arr)
    if n == 0:
        return []

    # Create a result array of the same length
    result = [0] * n

    # Initialize the maximum value as the last element of the array
    max_right = arr[-1]

    # Set the last element of result to the last element of arr
    result[-1] = max_right

    # Traverse the array from second last element to the start
    for i in range(n - 2, -1, -1):
        if arr[i] > max_right:
            max_right = arr[i]
        result[i] = max_right

    return result

# Example usage:
print(replace_with_max_right([-10, 5, -20, 3]))  # Output: [5, 5, 3, 3]
print(replace_with_max_right([5, 6, 9, 2]))      # Output: [9, 9, 9, 2]