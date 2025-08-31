/**
 * Teddy Jones
 * CEN 4025C
 * Professor Walauskis
 * 08/31/2025
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node in the folder tree.
 * Each node corresponds to a folder in the file system and stores its metadata,
 * including its name, the count and total size of the files it directly contains,
 * and a list of its child folders (subdirectories).
 */
public class FolderNode {
    private final String folderName;
    private long fileCount;
    private long totalSize; // Stored in bytes
    private final List<FolderNode> children;

    /**
     * Constructs a new FolderNode.
     *
     * @param folderName The name of the folder this node represents.
     */
    public FolderNode(String folderName) {
        this.folderName = folderName;
        this.fileCount = 0;
        this.totalSize = 0;
        this.children = new ArrayList<>();
    }

    // --- Getters and Setters ---

    public String getFolderName() {
        return folderName;
    }

    public long getFileCount() {
        return fileCount;
    }

    public void setFileCount(long fileCount) {
        this.fileCount = fileCount;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public List<FolderNode> getChildren() {
        return children;
    }

    /**
     * Adds a child node to this node's list of children.
     *
     * @param child The FolderNode representing a subdirectory to be added.
     */
    public void addChild(FolderNode child) {
        this.children.add(child);
    }
}
