package de.tum.in.ase.eist;

import java.util.Objects;

public class FileTree {

    private FileTreeElement root;

    public FileTree(FileTreeElement root) {
        this.root = root;
    }

    public FileTreeElement getRoot() {
        return root;
    }

    public void setRoot(FileTreeElement root) {
        this.root = root;
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileTree)) {
            return false;
        }
        FileTree other = (FileTree) obj;
        return Objects.equals(root, other.root);
    }
}
