package ui.views.sidepanel.challengetree;

import model.Challenge;

import java.util.List;

public class ChallengeInfo {
    Challenge challenge;
    List<Challenge> visitedLayers;

    public ChallengeInfo(Challenge challenge, List<Challenge> visitedLayers) {
        this.challenge = challenge;
        this.visitedLayers = visitedLayers;
    }

    @Override
    public String toString() {
        return this.challenge.getName();
    }

    public Challenge getChallenge() {
        return this.challenge;
    }

    public List<Challenge> getVisitedLayers() {
        return this.visitedLayers;
    }
}
