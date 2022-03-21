package ui.views.sidepanel.challengetree;

import model.Challenge;
import ui.views.sidepanel.challengetree.ChallengeInfo;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

public class ChallengeInfoTree extends DefaultMutableTreeNode {
    private ChallengeInfo challengeInfo;

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
