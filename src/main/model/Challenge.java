package model;

import java.util.ArrayList;
import java.util.Objects;

// Represents a challenge having challenge name, challenge description, and
// elaborated mini challenges
public class Challenge {
    private String name;
    private String description;
    private ChallengesGroup elaboratedMiniChallenges;
    private ChallengesGroup challengesGroup;
    private boolean checked;

    // EFFECTS: constructs an unchecked challenge with no challenges group, given challenge name,
    // given challenge description, and empty elaborated mini challenges with this ar parent challenge.
    public Challenge(String name, String description) {
        this.challengesGroup = null;
        this.name = name;
        this.description = description;
        this.elaboratedMiniChallenges = new ChallengesGroup(this);
        this.checked = false;
    }

    // MODIFIES: this
    // EFFECTS: sets challengesGroup to given challengesGroup
    protected void setChallengesGroup(ChallengesGroup challengesGroup) {
        this.challengesGroup = challengesGroup;
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

    // MODIFIES: this
    // EFFECTS: toggles checked state and sinks new checked state. If challenges group exists,
    // lifts new checked state. otherwise, doesn't lift new checked state
    public void toggleCheck() {
        this.checked = !this.checked;

        System.out.println(this.name + " tried to toggle");
        if (this.checked) {
            System.out.println(this.name + " tried to sink check");
            this.elaboratedMiniChallenges.sinkCheck();
            if (challengesGroupExists()) {
                System.out.println(this.name + " tried to lift check");
                this.challengesGroup.liftCheck();
            }
        } else {
            this.elaboratedMiniChallenges.sinkUnCheck();
            System.out.println(this.name + " tried to sink uncheck");
            if (challengesGroupExists()) {
                System.out.println(this.name + " tried to lift uncheck");
                this.challengesGroup.liftUnCheck();
            }
        }
    }

    // EFFECTS: returns whether challenges group exist
    public boolean challengesGroupExists() {
        return !Objects.isNull(this.challengesGroup);
    }

    // MODIFIES: this
    // EFFECTS: checks challenge and sinks check to elaborated mini challenges
    protected void sinkCheck() {
        System.out.println(this.name + " forced to check and sink check");
        this.checked = !this.checked;
        this.elaboratedMiniChallenges.sinkCheck();
    }

    // MODIFIES: this
    // EFFECTS: If challenges group exists, checks challenge and lifts check to challenges group if currently unchecked.
    // Otherwise, does nothing
    protected void liftCheck() {
        if (!this.checked) {
            if (!Objects.isNull(this.challengesGroup)) {
                System.out.println(this.name + " has challenges group");
                System.out.println(this.name + " forced to check and lift check");
                this.challengesGroup.liftCheck();
            }
            this.checked = !this.checked;
        }
    }

    // MODIFIES: this
    // EFFECTS: unchecks challenge and sinks uncheck to elaborated mini challenges
    protected void sinkUnCheck() {
        System.out.println(this.name + " forced to uncheck and sink check");
        this.checked = !this.checked;
        this.elaboratedMiniChallenges.sinkUnCheck();
    }

    // MODIFIES: this
    // EFFECTS: If challenges group exists, checks challenge and lifts check to challenges group if currently unchecked.
    // Otherwise, does nothing
    protected void liftUnCheck() {
        if (this.checked) {
            if (!Objects.isNull(this.challengesGroup)) {
                System.out.println(this.name + " has challenges group");
                System.out.println(this.name + " forced to check and lift check");
                this.challengesGroup.liftUnCheck();
            }
            this.checked = !this.checked;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isChecked() {
        return this.checked;
    }

    // EFFECTS: gets an ArrayList of challenges in elaborated mini challenges
    public ChallengesGroup getElaboratedMiniChallenges() {
        return this.elaboratedMiniChallenges;
    }

    public ChallengesGroup getChallengesGroup() {
        return this.challengesGroup;
    }
}
