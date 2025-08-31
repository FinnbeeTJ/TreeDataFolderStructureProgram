/**
 * Teddy Jones
 * CEN 4025C
 * Professor Walauskis
 * 08/31/2025
 */

import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Main application class to scan a file system directory and represent it as a tree.
 * The program prompts the user for a folder path, recursively scans it,
 * and then prints a hierarchical view of the folder structure.
 */
public class FileSystemScanner {

    /**
     * The main entry point for the application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // 1. Get the folder path from the user via the console.
        try (Scanner userInputScanner = new Scanner(System.in)) {
            System.out.println("Enter the full path to the folder you wish to scan:");
            String folderPath = userInputScanner.nextLine();

            File rootFolder = new File(folderPath);

            // 2. Validate that the provided path exists and is a directory.
            if (!rootFolder.exists() || !rootFolder.isDirectory()) {
                System.err.println("Error: The provided path is not a valid directory.");
                return;
            }

            System.out.println("\nScanning folder: " + rootFolder.getAbsolutePath() + "\n");

            // 3. Start the recursive scan to build the tree data structure.
            FolderNode rootNode = scanFolder(rootFolder);

            // 4. Print the resulting tree structure to the console.
            System.out.println("--- Scanned Folder Tree ---");
            printTree(rootNode, "");
        }
    }

    /**
     * Recursively scans a folder and its subfolders to build a tree of FolderNode objects.
     *
     * @param folder The folder (as a File object) to scan.
     * @return A FolderNode representing the scanned folder and its entire subtree.
     */
    public static FolderNode scanFolder(File folder) {
        // Create a node for the current folder being processed.
        FolderNode node = new FolderNode(folder.getName());

        File[] filesList = folder.listFiles();
        if (filesList == null) {
            // This can happen if the program lacks permissions to read the directory.
            System.err.println("Warning: Could not read contents of " + folder.getAbsolutePath());
            return node;
        }

        long currentFolderFileCount = 0;
        long currentFolderTotalSize = 0;

        for (File file : filesList) {
            if (file.isDirectory()) {
                // If the item is a directory, make a recursive call to scan it.
                FolderNode childNode = scanFolder(file);
                node.addChild(childNode);
            } else {
                // If the item is a file, update the count and size for the current folder node.
                currentFolderFileCount++;
                currentFolderTotalSize += file.length();
            }
        }

        node.setFileCount(currentFolderFileCount);
        node.setTotalSize(currentFolderTotalSize);

        return node;
    }

    /**
     * Recursively prints the tree structure to the console with appropriate indentation.
     *
     * @param node   The current node to print.
     * @param indent The indentation string, which grows with the tree depth.
     */
    public static void printTree(FolderNode node, String indent) {
        // Format the size from bytes to a more readable format (KB, MB, etc.).
        String sizeFormatted = formatSize(node.getTotalSize());

        // Print the details of the current node.
        System.out.printf("%s- %s (%d files, %s)\n",
                indent,
                node.getFolderName(),
                node.getFileCount(),
                sizeFormatted);

        // Make a recursive call for each child node, increasing the indentation.
        for (FolderNode child : node.getChildren()) {
            printTree(child, indent + "  |");
        }
    }

    /**
     * Formats a size in bytes into a human-readable string (e.g., KB, MB, GB).
     *
     * @param size The size in bytes.
     * @return A formatted string representation of the size.
     */
    private static String formatSize(long size) {
        if (size <= 0) return "0 B";
        final String[] units = {"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }
}


