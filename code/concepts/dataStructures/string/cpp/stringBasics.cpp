#include <iostream>
#include <string>
#include <algorithm>
#include <sstream>
#include <numeric>
#include <vector>
#include <regex>

// UTF8 support
#include <locale>
#include <codecvt>

using namespace std;

bool isPalindrome(const string& str) {
    string cleaned;
    for (char ch : str) {
        if (isalnum(ch)) {
            cleaned += tolower(ch);  // Ignore non-alphanumeric and lowercase the characters
        }
    }

    string reversed = cleaned;
    reverse(reversed.begin(), reversed.end());
    
    return cleaned == reversed;
}

vector<string> splitString(const string& str, char delimiter) {
    vector<string> tokens;
    string token;
    for (char ch : str) {
        if (ch == delimiter) {
            if (!token.empty()) {
                tokens.push_back(token);
                token.clear();
            }
        } else {
            token += ch;
        }
    }
    if (!token.empty()) {  // Add the last token
        tokens.push_back(token);
    }
    return tokens;
}


string replaceAllChars(string str, char oldChar, char newChar) {
    replace(str.begin(), str.end(), oldChar, newChar);
    return str;
}


// Trim leading spaces
string trimLeft(const string& str) {
    size_t start = str.find_first_not_of(" \t\n\r\f\v");
    return (start == string::npos) ? "" : str.substr(start);
}

// Trim trailing spaces
string trimRight(const string& str) {
    size_t end = str.find_last_not_of(" \t\n\r\f\v");
    return (end == string::npos) ? "" : str.substr(0, end + 1);
}


bool caseInsensitiveCompare(const string& str1, const string& str2) {
    string str1Lower = str1;
    string str2Lower = str2;
    
    transform(str1Lower.begin(), str1Lower.end(), str1Lower.begin(), ::tolower);
    transform(str2Lower.begin(), str2Lower.end(), str2Lower.begin(), ::tolower);
    
    return str1Lower == str2Lower;
}

int compareStrings(const string& str1, const string& str2) {
    if (str1 < str2) return -1;  // str1 is lexicographically smaller than str2
    if (str1 > str2) return 1;   // str1 is lexicographically larger than str2
    return 0;                    // str1 is equal to str2
}

string concatenateStrings(const vector<string>& strings) {
    ostringstream oss;
    for (const auto& str : strings) {
        oss << str;
    }
    return oss.str();
}

size_t findCharPosition(const string& str, char ch) {
    size_t pos = str.find(ch);
    return pos;  // Returns string::npos if not found
}

string escapeString(const string& str) {
    string result;
    for (char ch : str) {
        switch (ch) {
            case '"':  result += "\\\""; break;
            case '\\': result += "\\\\"; break;
            case '\n': result += "\\n"; break;
            case '\t': result += "\\t"; break;
            default:   result += ch; break;
        }
    }
    return result;
}

size_t countSubstringOccurrences(const string& str, const string& subStr) {
    size_t count = 0;
    size_t pos = 0;
    while ((pos = str.find(subStr, pos)) != string::npos) {
        ++count;
        pos += subStr.length();
    }
    return count;
}


bool startsWith(const string& str, const string& prefix) {
    return str.find(prefix) == 0;
}

bool endsWith(const string& str, const string& suffix) {
    return str.size() >= suffix.size() && 
           str.compare(str.size() - suffix.size(), suffix.size(), suffix) == 0;
}



int main() {
    // 1. Initialization
    string mainStr = "Hello, World!";
    cout << "Initial String: " << mainStr << endl;

    // 2. Traversal (loop through characters)
    cout << "Traversal: ";
    for (char ch : mainStr) {
        cout << ch << " "; // Print each character
    }
    cout << endl;

    // 3. Insertion (insert at specific position)
    mainStr.insert(7, "Beautiful "); // Insert at index 7
    cout << "After Insertion: " << mainStr << endl;

    // 4. Deletion (remove part of the string)
    mainStr.erase(7, 10); // Remove 10 characters starting from index 7
    cout << "After Deletion: " << mainStr << endl;

    // 5. Search (find a substring)
    size_t found = mainStr.find("World");
    if (found != string::npos) {
        cout << "'World' found at position: " << found << endl;
    } else {
        cout << "'World' not found!" << endl;
    }

    // 6. Update (modify character at a specific position)
    if (!mainStr.empty()) {
        mainStr[0] = 'h'; // Update the first character to lowercase 'h'
        cout << "After Update: " << mainStr << endl;
    }

    // 7. Access (retrieve a character by index)
    char ch = mainStr[1]; // Access character at index 1
    cout << "Character at index 1: " << ch << endl;

    // 8. Peek/Top (view first and last characters)
    cout << "First character: " << mainStr.front() << endl;
    cout << "Last character: " << mainStr.back() << endl;

    // 9. Push/Enqueue (add character at the end)
    mainStr.push_back('!');
    cout << "After Push: " << mainStr << endl;

    // 10. Pop/Dequeue (remove last character)
    mainStr.pop_back();
    cout << "After Pop: " << mainStr << endl;

    // 11. Sorting (sort the characters in the string)
    string strToSort = "apple";
    sort(strToSort.begin(), strToSort.end()); // Sort alphabetically
    cout << "Sorted String: " << strToSort << endl;

    // 12. Reversing the string
    reverse(mainStr.begin(), mainStr.end());
    cout << "Reversed String: " << mainStr << endl;

    // 13. Finding Minimum/Maximum (alphabetical order)
    char minChar = *min_element(mainStr.begin(), mainStr.end());
    char maxChar = *max_element(mainStr.begin(), mainStr.end());
    cout << "Minimum Character: " << minChar << endl;
    cout << "Maximum Character: " << maxChar << endl;

    // 14. Checking Empty (if the string is empty)
    if (mainStr.empty()) {
        cout << "The string is empty!" << endl;
    } else {
        cout << "The string is not empty!" << endl;
    }

    // 15. Length of the string
    cout << "Length of string: " << mainStr.length() << endl;

    // 16. Substring operation (extract part of the string)
    string subStr = mainStr.substr(0, 5); // Get substring from index 0, with length 5
    cout << "Substring: " << subStr << endl;

    // 17. Concatenation (join two strings)
    string additionalStr = " How are you?";
    string result = mainStr + additionalStr;
    cout << "Concatenated String: " << result << endl;

    // 18. IsPresent/Contains (check if substring exists)
    if (mainStr.find("Hello") != string::npos) {
        cout << "'Hello' is present in the string!" << endl;
    } else {
        cout << "'Hello' is not present in the string!" << endl;
    }

    // 19. Replacing part of the string
    mainStr = "Hello, World!";
    mainStr.replace(7, 5, "C++");
    cout << "After Replace: " << mainStr << endl; // "Hello, C++!"

    // 20. Find first occurrence of a character
    size_t pos = mainStr.find('o');  // Finds the first occurrence of 'o'
    cout << "First occurrence of 'o': " << pos << endl; // Output: 4

    // 21. Find last occurrence of a character
    pos = mainStr.rfind('o');  // Finds the last occurrence of 'o'
    cout << "Last occurrence of 'o': " << pos << endl; // Output: 8

    // 22. Convert string to uppercase
    string strLower = "hello world";
    transform(strLower.begin(), strLower.end(), strLower.begin(), ::toupper);
    cout << "Uppercase: " << strLower << endl; // "HELLO WORLD"

    // 23. Convert string to lowercase
    string strUpper = "HELLO WORLD";
    transform(strUpper.begin(), strUpper.end(), strUpper.begin(), ::tolower);
    cout << "Lowercase: " << strUpper << endl; // "hello world"

    // 24. Trim leading and trailing spaces
    string strWithSpaces = "   Hello, World!   ";
    strWithSpaces.erase(0, strWithSpaces.find_first_not_of(" ")); // Remove leading spaces
    strWithSpaces.erase(strWithSpaces.find_last_not_of(" ") + 1); // Remove trailing spaces
    cout << "Trimmed String: '" << strWithSpaces << "'" << endl; // Output: "Hello, World!"

    // 25. Split string by delimiter
    string str4 = "apple,banana,orange,grape";
    size_t delimiterPos = 0;
    string delimiter = ",";
    while ((delimiterPos = str4.find(delimiter)) != string::npos) {
        cout << str4.substr(0, delimiterPos) << endl; // Print substring before the delimiter
        str4.erase(0, delimiterPos + delimiter.length()); // Remove the part already processed
    }
    cout << str4 << endl; // Print remaining part after the last delimiter

    // 26. Using stringstream for concatenation and parsing
    stringstream ss;
    ss << "The number is: " << 42;  // Writing to stringstream
    string resultStr = ss.str(); // Get string from stringstream
    cout << "Resulting String: " << resultStr << endl; // "The number is: 42"

    // 27. Reading from stringstream
    stringstream ss2("123 456 789");
    int a, b, c;
    ss2 >> a >> b >> c;  // Reading integers from stringstream
    cout << "Values: " << a << ", " << b << ", " << c << endl; // 123 456 789

    // 28. Comparing strings lexicographically
    string compareStr1 = "apple";
    string compareStr2 = "banana";
    if (compareStr1 == compareStr2) {
        cout << "Strings are equal!" << endl;
    } else if (compareStr1 < compareStr2) {
        cout << compareStr1 << " is lexicographically smaller than " << compareStr2 << endl;
    } else {
        cout << compareStr1 << " is lexicographically greater than " << compareStr2 << endl;
    }

    // 29. Palindrome check
    string palindromeStr = "madam";
    string reversedStr = palindromeStr;
    reverse(reversedStr.begin(), reversedStr.end());
    if (palindromeStr == reversedStr) {
        cout << "The string is a palindrome." << endl;
    } else {
        cout << "The string is not a palindrome." << endl;
    }

    // 30. Replacing all occurrences of a substring
    string replaceStr = "I like C++. C++ is great!";
    string target = "C++";
    string replacement = "Java";
    
    size_t pos2 = 0;
    while ((pos2 = replaceStr.find(target, pos2)) != string::npos) {
        replaceStr.replace(pos2, target.length(), replacement);
        pos2 += replacement.length(); // Move past the replacement
    }
    cout << "After replacing: " << replaceStr << endl; // "I like Java. Java is great!"

    // 31. Joining words using accumulate
    vector<string> words = {"I", "love", "C++", "programming"};
    string joinedString = accumulate(words.begin(), words.end(), string(), [](const string& a, const string& b) {
        return a + (a.empty() ? "" : " ") + b; // Adding spaces between words
    });
    
    cout << "Joined String: " << joinedString << endl; // "I love C++ programming"

    // 32. Regex pattern detection
    string regexStr = "I have 2 apples and 3 oranges!";
    regex pattern("\\d+");  // Pattern to find one or more digits
    
    smatch matches;
    if (regex_search(regexStr, matches, pattern)) {
        cout << "First match found: " << matches.str() << endl;
    } else {
        cout << "No match found!" << endl;
    }
    
    // Find all matches
    cout << "All matches: ";
    for (sregex_iterator it(regexStr.begin(), regexStr.end(), pattern), end_it; it != end_it; ++it) {
        cout << it->str() << " ";
    }
    cout << endl;

    // Case-insensitive comparison of strings
    string caseStr1 = "Hello World";
    string caseStr2 = "hello world";
    
    if (caseInsensitiveCompare(caseStr1, caseStr2)) {
        cout << "Strings are equal (case-insensitive)." << endl;
    } else {
        cout << "Strings are not equal." << endl;
    }

    // UTF-8 string and conversion to wstring (UTF-16 on Windows)
    string utf8Str = "Hello, 🌍!"; // Unicode character (🌍)

    // Convert UTF-8 string to wstring
    wstring_convert<codecvt_utf8<wchar_t>> converter;
    wstring wStr = converter.from_bytes(utf8Str);

    // Output the UTF-8 string and the converted wide string
    wcout << L"Original UTF-8 String: " << wStr << endl;

    // Convert it back to UTF-8 (for demonstration)
    string convertedBack = converter.to_bytes(wStr);
    cout << "Converted back to UTF-8: " << convertedBack << endl;
    
    vector<string> tokens = splitString("apple,banana,orange", ',');
    for (const string& token : tokens) {
        cout << token << endl;
    }

    return 0;
}
