package model;

import java.util.ArrayList;

// Represents a challenge node having challenge name, challenge description, and
// elaborated mini challenges
public class ChallengeNode {
    private String name;
    private String description;
    private ArrayList<ChallengeNode> elaboratedMiniChallenges;

    // EFFECTS: constructs a challenge node with given challenge name, given challenge description,
    // and no elaborated mini challenges.
    public ChallengeNode(String name, String description) {
        this.name = name;
        this.description = description;
        this.elaboratedMiniChallenges = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds given challenge to the end of elaborated mini challenges
    public void addElaboratedMiniChallenge(ChallengeNode challenge) {
        this.elaboratedMiniChallenges.add(challenge);
    }

    // REQUIRES: elaborated mini challenges contains given challenge
    // MODIFIES: this
    // EFFECTS: removes challenge from elaborated mini challenges
    public void removeElaboratedMiniChallenge(ChallengeNode challenge) {
        elaboratedMiniChallenges.remove(challenge);
    }

    // REQUIRES: elaborated mini challenges contains given challenge and
    // 0 <= new index < size of elaborated mini challenges
    // MODIFIES: this
    // EFFECTS: exchanges the position of the given challenge and the challenge
    // in the specified new position
    public void changePosition(ChallengeNode challenge, int newIndex) {
        int oldIndex = this.elaboratedMiniChallenges.indexOf(challenge);
        ChallengeNode toBeReplaced = this.elaboratedMiniChallenges.get(newIndex);

        this.elaboratedMiniChallenges.set(newIndex, challenge);
        this.elaboratedMiniChallenges.set(oldIndex, toBeReplaced);
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

    public ArrayList<ChallengeNode> getElaboratedMiniChallenges() {
        return this.elaboratedMiniChallenges;
    }







}
