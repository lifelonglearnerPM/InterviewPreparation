import os  # Importing the os module to interact with the operating system

def print_directory_tree(path, level=0):
    """
    Recursively prints the directory tree structure.

    Parameters:
    - path: The directory path to read.
    - level: The current depth level (used for indentation).
    """
    if os.path.isdir(path):
        # Print the current directory name with appropriate indentation
        print(" " * level * 4 + os.path.basename(path) + "/")
        
        # Increment the depth level for the next level of directory
        level += 1
        
        # Get list of all files and directories in the current directory
        with os.scandir(path) as entries:
            for entry in entries:
                if entry.is_dir():
                    # If the entry is a directory, recursively call the function with the new path
                    print_directory_tree(entry.path, level)
                else:
                    # If the entry is a file, print the file name with appropriate indentation
                    print(" " * level * 4 + entry.name)
    else:
        print(f"{path} is not a directory.")  # If the path is not a directory, print an error message

# Input path (replace with the actual path you want to read)
#input_path = "C:/path/to/your/directory"  # or "C:\\path\\to\\your\\directory" for Windows or "/path/to/your/directory" for linux
input_path = "E:\\myToolsProgrammingPractice\\interviewPreparation"
# Print the directory tree starting from the input path
print_directory_tree(input_path)