package de.tum.in.ase.eist;

import java.util.Objects;

public final class File extends FileTreeElement {

    private String content;

    public File(String name, String content) {
        super(name);
        this.content = Objects.requireNonNull(content);
    }

    public File(String name) {
        this(name, "");
    }

    String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = Objects.requireNonNull(content);
    }

    @Override
    public int calculateSize() {
        return content.length();
    }
}
