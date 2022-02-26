package model;

import java.util.ArrayList;

// Represents a group of challenges having challenges
public class ChallengesGroup {
    private ArrayList<Challenge> challenges;

    // EFFECTS: construct a group of challenges with no challenge
    public ChallengesGroup() {
        challenges = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds given challenge to the end of challenges
    public void addChallenge(Challenge challenge) {
        this.challenges.add(challenge);
    }

    // REQUIRES: challenges contains given challenge
    // MODIFIES: this
    // EFFECTS: removes given challenge from challenges
    public void removeChallenge(Challenge challenge) {
        this.challenges.remove(challenge);
    }

    // REQUIRES: challenges contains given challenge and
    // 0 <= new index < size of challenges
    // MODIFIES: this
    // EFFECTS: moves the given challenge to given position
    // in challenges with other challenges still having the same arrangement
    public void changePosition(int oldIndex, int newIndex) {
        Challenge toBeMoved = this.challenges.get(oldIndex);
        this.challenges.remove(oldIndex);

        ArrayList<Challenge> newArray = new ArrayList<>();
        for (int i = 0; i < this.challenges.size(); i++) {
            if (i == newIndex) {
                newArray.add(toBeMoved);
            }
            newArray.add(this.challenges.get(i));
        }

        this.challenges = newArray;
    }

    public ArrayList<Challenge> getChallenges() {
        return this.challenges;
    }

}
