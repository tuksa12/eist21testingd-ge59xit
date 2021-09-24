package de.tum.in.ase.eist;

public interface FileServer {

    /**
     * Deletes the given file tree element on the server.
     *
     * @param fileTreeElement the file tree element to delete
     * @return true if the operation was successful, false otherwise
     */
    boolean delete(FileTreeElement fileTreeElement);

}
