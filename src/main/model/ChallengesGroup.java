package model;

import org.json.JSONArray;

import java.util.ArrayList;

// Represents a group of challenges having challenges
public class ChallengesGroup {
    private ArrayList<Challenge> challenges;
    private Challenge parentChallenge;

    // EFFECTS: construct a group of challenges with given parentChallenge and with empty challenges
    public ChallengesGroup(Challenge parentChallenge) {
        challenges = new ArrayList<>();
        this.parentChallenge = parentChallenge;
    }

    // MODIFIES: this
    // EFFECTS: adds given challenge to the end of challenges and sets given challenges group to this
    // and sets given challenge checked state to be the same as parent
    public void addChallenge(Challenge challenge) {
        challenge.setChallengesGroup(this);

        if (parentChallenge.isChecked()) {
            challenge.toggleCheck();
        }

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

    // MODIFIES: this
    // EFFECTS: sinks check in each challenge in challenges
    protected void sinkCheck() {
        this.challenges.forEach((challenge) -> challenge.sinkCheck());
    }

    // MODIFIES: this
    // EFFECTS: lifts check to parentChallenge if all challenges are checked.
    // Otherwise, does nothing
    protected void liftCheck() {
        boolean allTrueSoFar = true;

        for (Challenge challenge: this.challenges) {
            allTrueSoFar = (allTrueSoFar && challenge.isChecked());
        }

        boolean allTrue = allTrueSoFar;

        if (allTrue) {
            parentChallenge.liftCheck();
        }
    }

    // MODIFIES: this
    // EFFECTS: sinks uncheck in each challenge in challenges
    protected void sinkUnCheck() {
        this.challenges.forEach((challenge) -> challenge.sinkUnCheck());
    }

    // MODIFIES: this
    // EFFECTS: lifts uncheck to parentChallenge
    protected void liftUnCheck() {
        this.parentChallenge.liftUnCheck();
    }

    public ArrayList<Challenge> getChallenges() {
        return this.challenges;
    }

    public Challenge getParentChallenge() {
        return this.parentChallenge;
    }

    // REQUIRES: challenge group not empty
    // EFFECTS: returns this as JSON array
    protected JSONArray toJson() {
        JSONArray jsonArray = new JSONArray();

        for (Challenge challenge : this.challenges) {
            jsonArray.put(challenge.toJson());
        }

        return jsonArray;
    }
}
