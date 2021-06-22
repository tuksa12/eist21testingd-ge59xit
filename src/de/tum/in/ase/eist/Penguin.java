package de.tum.in.ase.eist;

import java.util.Objects;

public class Penguin {

    private int wingspan;
    private int age;
    private int height;

    private String nickname;

    public Penguin(int wingspan, int age, int height) {
        this.wingspan = wingspan;
        this.age = age;
        this.height = height;
    }

    public int getWingspan() {
        return wingspan;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Penguin)) {
            return false;
        }

        Penguin penguin = (Penguin) object;

        if (wingspan != penguin.wingspan) {
            return false;
        }
        if (age != penguin.age) {
            return false;
        }
        if (height != penguin.height) {
            return false;
        }
        return Objects.equals(nickname, penguin.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wingspan, age, height, nickname);
    }

}
