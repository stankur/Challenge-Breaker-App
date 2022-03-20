package ui.views.mainpanel;

import model.Challenge;
import ui.fomattingdata.FormattingData;
import ui.views.FramePanel;
import ui.views.helpers.Updater;
import ui.views.mainpanel.challengecardpanel.CurrentChallengeCard;
import ui.views.mainpanel.minichallengesarea.minichallengespanel.MiniChallenges;
import ui.views.mainpanel.minichallengesarea.MiniElaboratedChallengesLabel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainPanel extends JPanel {
    private FormattingData formattingData;
    private FramePanel framePanel;
    private List<String> visitedLayers;
    private Challenge currentChallenge;

    private JPanel bottomPanel;
    private MainPanelTopBar mainPanelTopBar;
    private CurrentChallengeCard currentChallengeCard;


    public MainPanel(FormattingData formattingData,
                     List<String> visitedLayers,
                     Challenge currentChallenge,
                     FramePanel framePanel) {
        this.formattingData = formattingData;
        this.framePanel = framePanel;
        this.visitedLayers = visitedLayers;
        this.currentChallenge = currentChallenge;

        setPreferredSize(
                new Dimension(
                        this.formattingData.getMainPanelWidth(),
                        this.formattingData.getAppHeight()
                )
        );
        setBackground(this.formattingData.getMainBackground());
        setLayout(new BorderLayout());

        addMainPanelTopBar();
        addCurrentChallengeCard();
        addBottomPanel();
    }

    private void addBottomPanel() {
        JPanel bottomPanel = new JPanel();
        setUpBottomPanel(bottomPanel);

        this.bottomPanel = bottomPanel;

        add(this.bottomPanel, BorderLayout.SOUTH);

    }

    private void setUpBottomPanel(JPanel bottomPanel) {
        bottomPanel.setPreferredSize(new Dimension(
                this.formattingData.getMainPanelWidth(), this.formattingData.getBottomPanelHeight()
        ));
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(new MiniElaboratedChallengesLabel(this.formattingData), BorderLayout.NORTH);
        List<Challenge> miniChallenges = this.currentChallenge.getElaboratedMiniChallenges().getChallenges();
        bottomPanel.add(new MiniChallenges(this.formattingData, this, miniChallenges));
    }

    private void addMainPanelTopBar() {
        MainPanelTopBar mainPanelTopBar = new MainPanelTopBar(this.formattingData, this.visitedLayers);

        this.mainPanelTopBar = mainPanelTopBar;

        add(this.mainPanelTopBar, BorderLayout.NORTH);
    }

    private void addCurrentChallengeCard() {
        CurrentChallengeCard currentChallengeCard = new CurrentChallengeCard(this.formattingData,
                this,
                currentChallenge.getName(),
                currentChallenge.getDescription(),
                currentChallenge.isChecked()
        );

        this.currentChallengeCard = currentChallengeCard;

        add(this.currentChallengeCard, BorderLayout.CENTER);
    }

    public void requestAddChallenge(String name, String description) {
        this.framePanel.requestAddChallenge(name, description);
    }

    public void requestRemoveChallenge(int index) {
        Challenge challengeToBeRemoved = this.currentChallenge.getElaboratedMiniChallenges().getChallenges().get(index);
        this.currentChallenge.removeElaboratedMiniChallenge(challengeToBeRemoved);

        remove(this.bottomPanel);
        addBottomPanel();

        new Updater(this);
    }

    public void requestRearrange(int oldIndex, int newIndex) {
        this.currentChallenge.changePosition(oldIndex, newIndex);

        remove(this.bottomPanel);
        addBottomPanel();

        new Updater(this);
    }

    public void requestEditChallenge(String newName, String newDesc) {
        this.currentChallenge.editName(newName);
        this.currentChallenge.editDescription(newDesc);

        remove(this.currentChallengeCard);
        addCurrentChallengeCard();

        new Updater(this);
    }

    public void requestStepInto(int miniElaboratedChallengeIndex) {
        this.framePanel.requestStepInto(miniElaboratedChallengeIndex);
    }

    public void requestExitCurrentChallenge() {
        this.framePanel.requestExitCurrentChallenge();
    }

    public void toggleCheckCurrentChallenge() {
        this.currentChallenge.toggleCheck();

        remove(this.bottomPanel);
        remove(this.mainPanelTopBar);
        remove(this.currentChallengeCard);

        addBottomPanel();
        addMainPanelTopBar();
        addCurrentChallengeCard();

        new Updater(this);
    }

    public void toggleCheckElaboratedMiniChallenge(int index) {
        this.currentChallenge.getElaboratedMiniChallenges().getChallenges().get(index).toggleCheck();

        remove(this.bottomPanel);
        remove(this.currentChallengeCard);

        addBottomPanel();
        addCurrentChallengeCard();

        new Updater(this.bottomPanel);
        new Updater(this.currentChallengeCard);
    }
}
