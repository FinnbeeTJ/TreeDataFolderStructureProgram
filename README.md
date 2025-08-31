Java File System Scanner
This is a simple Java console application that scans a specified folder and its subdirectories, builds a tree data structure to represent the folder hierarchy, and then prints this tree to the console.

Each node in the printed tree displays the folder's name, the number of files directly inside it, and the total size of those files.

Project Structure (for IntelliJ IDEA)
The project is structured as follows:

FileSystemScannerProject/
├── .idea/
├── src/
│   └── com/
│       └── filesystemscanner/
│           ├── FileSystemScanner.java   (Main class)
│           └── FolderNode.java          (Data structure class)
└── FileSystemScannerProject.iml

How to Run in IntelliJ IDEA
Open the Project: Open the project folder in IntelliJ IDEA.

Locate the Main Class: In the Project view, navigate to src/com/filesystemscanner/FileSystemScanner.java.

Run the Application: Right-click anywhere inside the FileSystemScanner.java file editor and select "Run 'FileSystemScanner.main()'".

Enter Folder Path: The program will start running, and you will see a prompt in the console at the bottom of the screen asking for a folder path.

Enter the full path to the folder you wish to scan:

Provide Input: Type or paste the full path to the directory you want to analyze (e.g., C:\Users\YourUser\Documents on Windows or /home/youruser/Documents on Linux/macOS) and press Enter.

View Output: The program will then scan the directory and print the hierarchical tree structure directly in the console.

Example Output
If you scan a folder named MyProject with the following structure:

MyProject/

file1.txt (1 KB)

file2.txt (2 KB)

src/

main.java (5 KB)

assets/

logo.png (20 KB)

icon.svg (15 KB)

The output in the console would look like this:

--- Scanned Folder Tree ---
- MyProject (2 files, 3 KB)
  |- src (1 files, 5 KB)
  |- assets (2 files, 35 KB)
