package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

// Represents a challenge having challenge name, challenge description, and
// elaborated mini challenges
public class Challenge implements Writable {
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

        if (this.checked) {
            this.elaboratedMiniChallenges.sinkCheck();
            if (challengesGroupExists()) {
                this.challengesGroup.liftCheck();
            }
        } else {
            this.elaboratedMiniChallenges.sinkUnCheck();
            if (challengesGroupExists()) {
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
        this.checked = true;
        this.elaboratedMiniChallenges.sinkCheck();
    }

    // REQUIRES: this.checked must be false
    // MODIFIES: this
    // EFFECTS: If challenges group exists, checks challenge and lifts check to challenges group if currently unchecked.
    // Otherwise, does nothing
    protected void liftCheck() {
        this.checked = true;

        if (challengesGroupExists()) {
            this.challengesGroup.liftCheck();
        }
    }

    // MODIFIES: this
    // EFFECTS: unchecks challenge and sinks uncheck to elaborated mini challenges
    protected void sinkUnCheck() {
        this.checked = false;
        this.elaboratedMiniChallenges.sinkUnCheck();
    }

    // MODIFIES: this
    // EFFECTS: If challenges group exists, unchecks challenge and lifts uncheck to challenges group if currently
    // checked. Otherwise, does nothing
    protected void liftUnCheck() {
        if (this.checked) {
            if (challengesGroupExists()) {
                this.challengesGroup.liftUnCheck();
            }
            this.checked = false;
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

    public ChallengesGroup getElaboratedMiniChallenges() {
        return this.elaboratedMiniChallenges;
    }

    public ChallengesGroup getChallengesGroup() {
        return this.challengesGroup;
    }

    // EFFECTS: returns this as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", this.name);
        jsonObject.put("description", this.description);
        jsonObject.put("checked", this.checked);

        if (!this.elaboratedMiniChallenges.getChallenges().isEmpty()) {
            jsonObject.put("elaboratedMiniChallenges", this.elaboratedMiniChallenges.toJson());
        }

        return jsonObject;
    }
}
