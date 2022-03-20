package ui;

import model.Challenge;

import java.util.ArrayList;
import java.util.List;

public class LayerNavigator {
    private List<Challenge> visitedLayers;
    private Challenge currentChallenge;

    public LayerNavigator(Challenge mainChallenge) {
        this.visitedLayers = new ArrayList<>();
        this.currentChallenge = mainChallenge;
    }

    public List<Challenge> getVisitedLayers() {
        return this.visitedLayers;
    }

    public Challenge getCurrentChallenge() {
        return this.currentChallenge;
    }

    public void stepInto(int elaboratedMiniChallengeIndex) {
        this.visitedLayers.add(this.currentChallenge);
        this.currentChallenge = this.currentChallenge.getElaboratedMiniChallenges().getChallenges()
                .get(elaboratedMiniChallengeIndex);
    }

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

}
