package de.tum.in.ase.eist;

public interface HierarchicalPrinter {

    /**
     * Prints the given name with the correct formatting for the given level.
     *
     * @return <code>true</code> if the printing was successful and more lines can
     *         be printed or <code>false</code> if the printing failed, e.g. if the
     *         process was cancelled by the user
     */
    boolean print(String name, int level);
}
