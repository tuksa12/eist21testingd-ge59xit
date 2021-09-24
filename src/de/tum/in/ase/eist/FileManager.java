package de.tum.in.ase.eist;

public class FileManager {

    private FileServer fileServer;

    public FileServer getFileServer() {
        return fileServer;
    }

    public void setFileServer(FileServer fileServer) {
        this.fileServer = fileServer;
    }

    /**
     * Delete a file or folder by its path from the given file tree.
     *
     * @param fileTree the file tree to search through.
     * @param path     the path in the file tree that should be deleted as array of
     *                 the file tree element names
     * @return true if an element was found for the given path and successfully
     *         deleted both on the file server and in the file tree, false otherwise
     */
    public boolean deleteByPath(FileTree fileTree, String... path) {
        FileTreeElement root = fileTree.getRoot();
        // nothing to delete
        if (root == null || path.length == 0 || !root.getName().equals(path[0])) {
            return false;
        }
        if (path.length == 1) {
            // Try to delete root element
            boolean deletedOnServer = fileServer.delete(root);
            if (deletedOnServer) {
                fileTree.setRoot(null);
            }
            return deletedOnServer;
        }
        // Otherwise descend into the file tree
        return deleteByPath(root, path, 1);
    }

    /**
     * Delete a file tree element based on a path relative to the given parent.
     *
     * @param parent the element at <code>path[index - 1]</code>
     * @param path   the path in the file tree that should be deleted as array of
     *               names
     * @param index  <code>path[index]</code> is the next name to search for. If
     *               this is the last element in the path array, we try to delete it
     *               and remove it from <code>parent</code>. Otherwise we walk
     *               recursively deeper into the file tree.
     * @return true if an element was found for the given path and successfully
     *         deleted on the file server, false otherwise
     */
    private boolean deleteByPath(FileTreeElement parent, String[] path, int index) {
        // If the element is a file and
        if (parent instanceof File) {
            return false;
        }
        Folder folder = (Folder) parent;
        String targetName = path[index];
        // Search in the folder for an element with the target name
        FileTreeElement foundElement = folder.getChildren().stream().filter(element -> element.getName().equals(targetName)).findFirst()
                .orElse(null);
        // If no element with the target name was found, we cannot delete (in) it
        if (foundElement == null) {
            return false;
        }
        // If the path does not end here, descend further
        int remaining = path.length - index;
        if (remaining > 1) {
            return deleteByPath(foundElement, path, index + 1);
        }
        // Otherwise delete the child we found in the folder directly
        boolean deletedOnServer = fileServer.delete(foundElement);
        if (deletedOnServer) {
            folder.getChildren().remove(foundElement);
        }
        return deletedOnServer;
    }
}
