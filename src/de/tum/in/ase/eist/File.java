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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = Objects.requireNonNull(content);
    }

    @Override
    public int calculateSize() {
        return content.length();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), content);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof File)) {
            return false;
        }
        File other = (File) obj;
        return Objects.equals(getName(), other.getName()) && Objects.equals(content, other.content);
    }
}
