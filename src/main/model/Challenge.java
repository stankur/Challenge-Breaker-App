package model;

import java.util.ArrayList;

// Represents a challenge having challenge name, challenge description, and
// elaborated mini challenges
public class Challenge {
    private String name;
    private String description;
    private ChallengesGroup elaboratedMiniChallenges;

    // EFFECTS: constructs a challenge with given challenge name, given challenge description,
    // and empty elaborated mini challenges.
    public Challenge(String name, String description) {
        this.name = name;
        this.description = description;
        this.elaboratedMiniChallenges = new ChallengesGroup();
    }

    // MODIFIES: this
    // EFFECTS: adds given challenge to the end of elaborated mini challenges
    public void addElaboratedMiniChallenge(Challenge challenge) {
        this.elaboratedMiniChallenges.addChallenge(challenge);
    }

    // REQUIRES: elaborated mini challenges contains given challenge
    // MODIFIES: this
    // EFFECTS: removes challenge from elaborated mini challenges
    public void removeElaboratedMiniChallenge(Challenge challenge) {
        this.elaboratedMiniChallenges.removeChallenge(challenge);
    }

    // REQUIRES: elaborated mini challenges contains given challenge and
    // 0 <= new index < size of elaborated mini challenges
    // MODIFIES: this
    // EFFECTS: moves the given challenge to given position
    // in elaborated mini challenges with other challenges still having the same arrangement
    public void changePosition(int oldIndex, int newIndex) {
        this.elaboratedMiniChallenges.changePosition(oldIndex, newIndex);
    }


    // MODIFIES: this
    // EFFECTS: sets challenge name to given name
    public void editName(String name) {
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS: sets description to given description
    public void editDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    // EFFECTS: gets an ArrayList of challenges in elaborated mini challenges
    public ArrayList<Challenge> getElaboratedMiniChallenges() {
        return this.elaboratedMiniChallenges.getChallenges();
    }
}
