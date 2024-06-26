package de.tum.in.ase.eist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Folder extends FileTreeElement {

    private Set<FileTreeElement> children;

    public Folder(String name, Set<FileTreeElement> children) {
        super(name);
        this.children = Objects.requireNonNull(children);
    }

    public Folder(String name, FileTreeElement... children) {
        super(name);
        this.children = new HashSet<>(Arrays.asList(children));
    }

    public Folder(String name) {
        this(name, new HashSet<>());
    }

    public Set<FileTreeElement> getChildren() {
        return children;
    }

    public void setChildren(Set<FileTreeElement> children) {
        this.children = Objects.requireNonNull(children);
    }

    @Override
    public int calculateSize() {
        return children.stream().mapToInt(FileTreeElement::calculateSize).sum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), children);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Folder)) {
            return false;
        }
        Folder other = (Folder) obj;
        return Objects.equals(getName(), other.getName()) && Objects.equals(children, other.children);
    }
}