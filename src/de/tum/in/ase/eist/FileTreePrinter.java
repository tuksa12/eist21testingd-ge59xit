package de.tum.in.ase.eist;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FileTreePrinter {

    private HierarchicalPrinter hierarchicalPrinter;

    HierarchicalPrinter getHierarchicalPrinter() {
        return hierarchicalPrinter;
    }

    void setHierarchicalPrinter(HierarchicalPrinter hierarchicalPrinter) {
        this.hierarchicalPrinter = hierarchicalPrinter;
    }

    public boolean printSortedByName(FileTreeElement fileTreeElement) {
        var stack = new ArrayDeque<Iterator<FileTreeElement>>();
        stack.add(List.of(fileTreeElement).iterator());
        while (!stack.isEmpty()) {
            var iterator = stack.peek();
            if (iterator.hasNext()) {
                var element = iterator.next();
                boolean success = hierarchicalPrinter.print(element.getName(), stack.size() - 1);
                if (!success) {
                    return false;
                }
                if (element instanceof Folder) {
                    var children = ((Folder) element).getChildren();
                    var sortedChildrenIterator = children.stream().sorted(Comparator.comparing(FileTreeElement::getName)).iterator();
                    stack.push(sortedChildrenIterator);
                }
            } else {
                stack.pop();
            }
        }
        return true;
    }
}
