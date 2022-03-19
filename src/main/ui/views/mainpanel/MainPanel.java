package ui.views.mainpanel;

import model.Challenge;
import ui.fomattingdata.FormattingData;
import ui.views.FramePanel;
import ui.views.MainFrame;
import ui.views.helpers.Updater;
import ui.views.mainpanel.challengecardpanel.CurrentChallengeCard;
import ui.views.mainpanel.minichallengesarea.minichallengespanel.MiniChallenges;
import ui.views.mainpanel.minichallengesarea.MiniElaboratedChallengesLabel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel {
    private FormattingData formattingData;
    private FramePanel framePanel;
    private List<String> visitedLayers;
    private Challenge currentChallenge;

    private JPanel bottomPanel;


    public MainPanel(FormattingData formattingData,
                     List<String> visitedLayers,
                     Challenge currentChallenge,
                     FramePanel framePanel) {
        this.formattingData = formattingData;
        this.framePanel = framePanel;
        this.visitedLayers = visitedLayers;
        this.currentChallenge = currentChallenge;
        this.bottomPanel = createBottomPanel();



        setPreferredSize(
                new Dimension(
                        this.formattingData.getMainPanelWidth(),
                        this.formattingData.getAppHeight()
                )
        );
        setBackground(this.formattingData.getMainBackground());
        setLayout(new BorderLayout());

        add(new MainPanelTopBar(this.formattingData, this.visitedLayers), BorderLayout.NORTH);

        add(new CurrentChallengeCard(this.formattingData,
                this,
                currentChallenge.getName(),
                currentChallenge.getDescription()
                ), BorderLayout.CENTER);

        add(this.bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(
                this.formattingData.getMainPanelWidth(), this.formattingData.getBottomPanelHeight()
        ));

        bottomPanel.setLayout(new BorderLayout());

        bottomPanel.add(new MiniElaboratedChallengesLabel(this.formattingData), BorderLayout.NORTH);

        List<Challenge> miniChallenges = this.currentChallenge.getElaboratedMiniChallenges().getChallenges();
        List<String> miniChallengeNames = new ArrayList<>();
        for (Challenge challenge: miniChallenges) {
            miniChallengeNames.add(challenge.getName());
        }
        bottomPanel.add(new MiniChallenges(this.formattingData, this, miniChallengeNames));

        return bottomPanel;
    }

    public void requestAddChallenge(String name, String description) {
        this.framePanel.requestAddChallenge(name, description);
    }

    public void requestRemoveChallenge(int index) {
        Challenge challengeToBeRemoved = this.currentChallenge.getElaboratedMiniChallenges().getChallenges().get(index);
        this.currentChallenge.removeElaboratedMiniChallenge(challengeToBeRemoved);

        remove(this.bottomPanel);
        this.bottomPanel = createBottomPanel();
        add(this.bottomPanel, BorderLayout.SOUTH);

        new Updater(this);
    }
}
