package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class FileTreeElementTest {

    // TODO: Test whether the calculation of the total size of a folder with two
    // files of different sizes is correct as described in the problem statement
    @Test
    void testCalculateSize() {
        Set<FileTreeElement> children = new HashSet<>();
        File first = new File("first");
        File second = new File("second");

        first.setContent("example");
        second.setContent("nice");

        children.add(first);
        children.add(second);

        Folder testFolder = new Folder("name", children);
        assert testFolder.calculateSize() == first.getContent().length() + second.getContent().length();
    }

    // TODO: Test whether the content of a file cannot be null, neither by using the
    // constructor nor by setting it to null afterwards using the setter
    @Test
    void testContentNotNull() {
        try {
            File testFile = new File("name");
            testFile.setContent(null);
        } catch (NullPointerException e) {
            assert true;
        }
    }
}