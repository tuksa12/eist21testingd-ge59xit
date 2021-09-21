package de.tum.in.ase.eist;

import java.util.Objects;

public abstract class FileTreeElement {

    private String name;

    protected FileTreeElement(String name) {
        this.name = Objects.requireNonNull(name);
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public abstract int calculateSize();
}