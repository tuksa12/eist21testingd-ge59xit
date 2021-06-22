package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Notebook {

    private List<Penguin> observedPenguins = new ArrayList<>();

    public void addPenguin(Penguin observedPenguin) {
        observedPenguins.add(observedPenguin);
    }

    public double calculateAverageWingspan() {
        return observedPenguins.stream().mapToDouble(Penguin::getWingspan).average()
                .orElseThrow(IllegalStateException::new);
    }

    public Penguin getOldestPenguin() {
        return observedPenguins.stream().max(Comparator.comparingInt(Penguin::getAge)).orElse(null);
    }

    public int sumAllHeights() {
        return observedPenguins.stream().mapToInt(Penguin::getHeight).sum();
    }

    public int getNumberOfObservations() {
        return observedPenguins.size();
    }

    public Penguin getLatestObservation() {
        return observedPenguins.isEmpty() ? null : observedPenguins.get(observedPenguins.size() - 1);
    }

}
