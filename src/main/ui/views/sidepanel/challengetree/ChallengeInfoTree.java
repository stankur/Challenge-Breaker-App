package ui.views.sidepanel.challengetree;

import model.Challenge;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

// represents a challenge information tree
public class ChallengeInfoTree extends DefaultMutableTreeNode {
    private ChallengeInfo challengeInfo;

    // REQUIRES: challenge info must be main challenge
    // EFFECTS: constructs a challenge info tree from given challenge info
    public ChallengeInfoTree(ChallengeInfo challengeInfo) {
        super(challengeInfo);

        this.challengeInfo = challengeInfo;
        List<DefaultMutableTreeNode> worklist = new ArrayList<>();

        worklist.add(this);

        while (worklist.size() > 0) {
            DefaultMutableTreeNode currentNode = worklist.get(0);
            worklist.remove(0);

            ChallengeInfo currentChallengeInfo = (ChallengeInfo) currentNode.getUserObject();

            List<DefaultMutableTreeNode> miniChallengesNodes =
                    createMiniChallengesNodes(currentChallengeInfo);

            for (DefaultMutableTreeNode miniChallengeNode: miniChallengesNodes) {
                currentNode.add(miniChallengeNode);
                worklist.add(miniChallengeNode);
            }
        }
    }

    // EFFECTS: returns a list of default mutable trees with userObject of challenge info of mini elaborated challenges
    //          of the challenge in given challenge info
    private List<DefaultMutableTreeNode> createMiniChallengesNodes(ChallengeInfo challengeInfo) {

        List<DefaultMutableTreeNode> nodes = new ArrayList<>();
        List<Challenge> visitedLayersForMiniChallenges = new ArrayList<>();

        for (Challenge visitedLayer: challengeInfo.getVisitedLayers()) {
            visitedLayersForMiniChallenges.add(visitedLayer);
        }

        visitedLayersForMiniChallenges.add(challengeInfo.getChallenge());

        for (Challenge miniChallenge : challengeInfo.getChallenge().getElaboratedMiniChallenges().getChallenges()) {
            nodes.add(new DefaultMutableTreeNode(new ChallengeInfo(
                    miniChallenge,
                    visitedLayersForMiniChallenges
            )));
        }

        return nodes;
    }

}
