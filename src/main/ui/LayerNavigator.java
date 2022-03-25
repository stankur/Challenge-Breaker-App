package ui;

import model.Challenge;

import java.util.ArrayList;
import java.util.List;

// represents a layer navigator to navigate changes between challenges layers
public class LayerNavigator {
    private List<Challenge> visitedLayers;
    private Challenge currentChallenge;

    // EFFECTS: constructs a new layer navigator with given main challenge as current challenge and no visited layers
    public LayerNavigator(Challenge mainChallenge) {
        this.visitedLayers = new ArrayList<>();
        this.currentChallenge = mainChallenge;
    }

    // EFFECTS: returns visited layers
    public List<Challenge> getVisitedLayers() {
        return this.visitedLayers;
    }

    // EFFECTS: returns current challenge
    public Challenge getCurrentChallenge() {
        return this.currentChallenge;
    }

    // REQUIRES: 0 <= elaborated mini challenge index
    //             <= this.currentChallenge.getElaboratedMiniChallenges().getChallenges().size()
    // MODIFIES: this
    // EFFECTS: sets current challenge to elaborated mini challenge with given index and adds previous current challenge
    // to visited layers
    public void stepInto(int elaboratedMiniChallengeIndex) {
        this.visitedLayers.add(this.currentChallenge);
        this.currentChallenge = this.currentChallenge.getElaboratedMiniChallenges().getChallenges()
                .get(elaboratedMiniChallengeIndex);
    }

    // MODIFIES: this
    // EFFECTS: if visited layers is empty, does nothing.
    //          Otherwise, sets current challenge to outermost challenge in visited layers
    //          and remove that challenge from visited layers
    public void exitCurrentLayer() {
        int lastIndex = this.visitedLayers.size() - 1;

        if (lastIndex < 0) {
            System.out.println("this is the outermost branch; could not exit further");
        } else {
            lastIndex = this.visitedLayers.size() - 1;
            this.currentChallenge = this.visitedLayers.get(lastIndex);
            this.visitedLayers.remove(lastIndex);
        }

    }

    // REQUIRES: visited layers and current challenge given must have appropriate layers
    // MODIFIES: this
    // EFFECTS: changes visited layers to given visited layers and current challenge to given current challenge
    public void changeToLayer(List<Challenge> visitedLayers, Challenge currentChallenge) {
        this.visitedLayers = visitedLayers;
        this.currentChallenge = currentChallenge;
    }

}
