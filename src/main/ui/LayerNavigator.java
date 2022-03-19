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
        System.out.println("requested index : " + elaboratedMiniChallengeIndex + "\n");
        System.out.println("MEC: " + this.currentChallenge.getElaboratedMiniChallenges().getChallenges());
        this.currentChallenge = this.currentChallenge.getElaboratedMiniChallenges().getChallenges()
                .get(elaboratedMiniChallengeIndex);
    }

}
