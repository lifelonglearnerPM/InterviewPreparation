#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>  // For std::accumulate
#include <iterator> // For iterators
#include <functional> // For std::greater

using namespace std;

int main() {
    // Initialize Vectors
    vector<int> emptyVector;
    vector<int> exampleVector = {40, 20, 50, 10, 30};
    vector<int> secondVector = {1, 4, 7, 2, 6, 3, 5};
    vector<int> copyVector = secondVector;

    // Reserve capacity to optimize performance
    copyVector.reserve(1000); // Reserving memory for future operations

    // 1. Check if vector is empty
    cout << "Empty status of emptyVector: " << emptyVector.empty() << endl;
    cout << "Empty status of exampleVector: " << exampleVector.empty() << endl;

    // 2. Size and Capacity
    cout << "Size of exampleVector: " << exampleVector.size() << endl;
    cout << "Capacity of exampleVector: " << exampleVector.capacity() << endl;

    // 3. Traverse Vector using different methods
    cout << "Using index to traverse exampleVector: ";
    for (int i = 0; i < exampleVector.size(); i++) {
        cout << exampleVector[i] << " ";
    }
    cout << endl;

    // Using range-based for loop
    cout << "Using range-based for loop to traverse exampleVector: ";
    for (int item : exampleVector) {
        cout << item << " ";
    }
    cout << endl;

    // Forward iteration (iterator)
    cout << "Forward iteration exampleVector: ";
    for (auto it = exampleVector.begin(); it != exampleVector.end(); ++it) {
        cout << *it << " ";
    }
    cout << endl;

    // Reverse iteration (iterator)
    cout << "Reverse iteration exampleVector: ";
    for (auto rIt = exampleVector.rbegin(); rIt != exampleVector.rend(); ++rIt) {
        cout << *rIt << " ";
    }
    cout << endl;

    // 4. Inserting elements into the vector
    exampleVector.insert(exampleVector.begin(), 70); // Insert at the beginning
    exampleVector.insert(exampleVector.begin() + 3, 80); // Insert at position 3
    cout << "After inserting elements, exampleVector: ";
    for (int item : exampleVector) {
        cout << item << " ";
    }
    cout << endl;

    // 5. Insert an element at the end
    exampleVector.push_back(60);
    cout << "After push_back(60), exampleVector: ";
    for (int item : exampleVector) {
        cout << item << " ";
    }
    cout << endl;

    // 6. Erase element at specific position
    exampleVector.erase(exampleVector.begin() + 1); // Erase at position 1
    cout << "After erase at position 1, exampleVector: ";
    for (int item : exampleVector) {
        cout << item << " ";
    }
    cout << endl;

    // 7. Clear all elements from the vector
    exampleVector.clear();
    cout << "After clear(), exampleVector size: " << exampleVector.size() << endl;

    // 8. Copy a vector
    vector<int> duplicateVector = secondVector; // Copy secondVector
    cout << "duplicateVector (copied from secondVector): ";
    for (int item : duplicateVector) {
        cout << item << " ";
    }
    cout << endl;

    // 9. Swap contents between two vectors
    secondVector.pop_back(); // Remove last element
    copyVector.swap(secondVector); // Swap contents of copyVector and secondVector
    cout << "After swap, secondVector: ";
    for (int item : secondVector) {
        cout << item << " ";
    }
    cout << endl;

    // 10. Find an element in vector using `find()`
    int target = 30;
    auto it = find(copyVector.begin(), copyVector.end(), target);
    if (it != copyVector.end()) {
        cout << "Element " << target << " found in copyVector" << endl;
    } else {
        cout << "Element " << target << " not found in copyVector" << endl;
    }

    // 11. Access an element by index using `[]`
    cout << "2nd element in copyVector: " << copyVector[1] << endl;

    // 12. Modify an element by index
    copyVector[1] = 90;  // Modify the 2nd element
    cout << "Modified 2nd element in copyVector: " << copyVector[1] << endl;

    // 13. Accumulate the sum of elements
    int sum = accumulate(copyVector.begin(), copyVector.end(), 0);
    cout << "Sum of elements in copyVector: " << sum << endl;

    // 14. Count occurrences of a specific element
    int count_of_3 = count(copyVector.begin(), copyVector.end(), 3);
    cout << "Count of element 3 in copyVector: " << count_of_3 << endl;

    // 15. Remove duplicates from sorted vector using `unique()` and `erase()`
    sort(copyVector.begin(), copyVector.end()); // Sorting before removing duplicates
    auto last = unique(copyVector.begin(), copyVector.end()); // Remove consecutive duplicates
    copyVector.erase(last, copyVector.end()); // Actually erase duplicates
    cout << "After removing duplicates, copyVector: ";
    for (int item : copyVector) {
        cout << item << " ";
    }
    cout << endl;

    // 16. Transform elements in place (e.g., square each element)
    transform(copyVector.begin(), copyVector.end(), copyVector.begin(), [](int x) { return x * x; });
    cout << "After squaring each element in copyVector: ";
    for (int item : copyVector) {
        cout << item << " ";
    }
    cout << endl;

    // 17. Sort the vector in ascending order
    sort(copyVector.begin(), copyVector.end());
    cout << "After sorting copyVector in ascending order: ";
    for (int item : copyVector) {
        cout << item << " ";
    }
    cout << endl;

    // 18. Reverse the vector
    reverse(copyVector.begin(), copyVector.end());
    cout << "After reversing copyVector: ";
    for (int item : copyVector) {
        cout << item << " ";
    }
    cout << endl;

    // 19. Using `lower_bound()` and `upper_bound()` for binary search
    vector<int> sortedVector = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int targetValue = 5;
    auto lower = lower_bound(sortedVector.begin(), sortedVector.end(), targetValue);
    auto upper = upper_bound(sortedVector.begin(), sortedVector.end(), targetValue);

    if (lower != sortedVector.end()) {
        cout << "Found " << targetValue << " at index: " << distance(sortedVector.begin(), lower) << endl;
    } else {
        cout << targetValue << " not found." << endl;
    }

    // 20. Reserve capacity to optimize performance
    vector<int> largeVector;
    largeVector.reserve(1000); // Reserve space for 1000 elements

    // 21. Using `emplace_back()` to avoid unnecessary copies (direct construction)
    vector<pair<int, string>> pairVector;
    pairVector.emplace_back(1, "One");
    pairVector.emplace_back(2, "Two");
    cout << "Vector of pairs: ";
    for (const auto& p : pairVector) {
        cout << "(" << p.first << ", " << p.second << ") ";
    }
    cout << endl;

    // 22. Using `.at()` to access elements safely
    try {
        cout << "Accessing 5th element: " << copyVector.at(4) << endl; // This will throw an exception if out of range
    } catch (const out_of_range& e) {
        cout << "Exception: " << e.what() << endl;
    }

    return 0;
}
