package ui.views.sidepanel.challengetree;

import model.Challenge;

import java.util.List;

// represents challenge information holder
public class ChallengeInfo {
    Challenge challenge;
    List<Challenge> visitedLayers;

    // EFFECTS: constructs a challenge information holder with given challenge and given visited layers
    public ChallengeInfo(Challenge challenge, List<Challenge> visitedLayers) {
        this.challenge = challenge;
        this.visitedLayers = visitedLayers;
    }

    // EFFECTS: returns name of challenge
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
