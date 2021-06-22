package de.tum.in.ase.eist;

public class PenguinResearcher {

    private Camera camera;
    private Notebook notebook = new Notebook();

    public void readNotebook() {
        System.out.println("My notebook contains the following facts:");
        System.out.println("The average wing span of penguins is: " + notebook.calculateAverageWingspan());
        System.out.println("The oldest penguin is: " + notebook.getOldestPenguin());
        System.out
                .println("If I stacked all observed penguins, they would have this height " + notebook.sumAllHeights());
    }

    public void addPenguinToNotebook(Penguin observedPenguin) {
        notebook.addPenguin(observedPenguin);
    }

    public void observePenguin() {
        Penguin identifiedPenguin = camera.identifyPenguin();
        addPenguinToNotebook(identifiedPenguin);

        // Name the penguin after the famous movie Madagascar
        String nickname;
        if (identifiedPenguin.getAge() < 4) {
            nickname = "Private";
        } else if (identifiedPenguin.getAge() < 7) {
            nickname = "Skipper";
        } else if (identifiedPenguin.getAge() < 10) {
            nickname = "Kowalski";
        } else {
            nickname = "Rico";
        }

        identifiedPenguin.setNickname(nickname);
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

}
