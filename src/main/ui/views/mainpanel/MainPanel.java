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

// represents main panel
public class MainPanel extends JPanel {
    private FormattingData formattingData;
    private FramePanel framePanel;
    private List<String> visitedLayers;
    private Challenge currentChallenge;

    private JPanel bottomPanel;
    private MainPanelTopBar mainPanelTopBar;
    private CurrentChallengeCard currentChallengeCard;

    // EFFECTS: constructs a new main panel with given formatting data, given visited layers,
    //          given current challenge, and reference to frame panel
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

    // MODIFIES: this
    // EFFECTS: adds bottom panel to this panel at the bottom
    private void addBottomPanel() {
        JPanel bottomPanel = new JPanel();
        setUpBottomPanel(bottomPanel);

        this.bottomPanel = bottomPanel;

        add(this.bottomPanel, BorderLayout.SOUTH);

    }

    // MODIFIES: bottomPanel
    // EFFECTS: sets up bottom panel
    private void setUpBottomPanel(JPanel bottomPanel) {
        bottomPanel.setPreferredSize(new Dimension(
                this.formattingData.getMainPanelWidth(), this.formattingData.getBottomPanelHeight()
        ));
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(new MiniElaboratedChallengesLabel(this.formattingData), BorderLayout.NORTH);
        List<Challenge> miniChallenges = this.currentChallenge.getElaboratedMiniChallenges().getChallenges();
        bottomPanel.add(new MiniChallenges(this.formattingData, this, miniChallenges));
    }

    // MODIFIES: this
    // EFFECTS: adds main panel top bar to this panel at the top
    private void addMainPanelTopBar() {
        MainPanelTopBar mainPanelTopBar = new MainPanelTopBar(this.formattingData, this.visitedLayers);

        this.mainPanelTopBar = mainPanelTopBar;

        add(this.mainPanelTopBar, BorderLayout.NORTH);
    }

    // MODIFIES: this
    // EFFECTS: adds current challenge card to this panel at the center
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

    // MODIFIES: this
    // EFFECTS: adds challenges of name of given name and of description of given description
    //          to this.framePanel
    public void requestAddChallenge(String name, String description) {
        this.framePanel.requestAddChallenge(name, description);
    }

    // MODIFIES: this
    // EFFECTS: requests frame panel to remove challenge of index of given index
    public void requestRemoveChallenge(int index) {
        this.framePanel.requestRemoveChallenge(index);

        remove(this.bottomPanel);
        addBottomPanel();

        new Updater(this.bottomPanel);
    }

    // MODIFIES: this
    // EFFECTS: requests frame panel to rearrange challenge at oldIndex to newIndex, and updates
    //          bottom panel
    public void requestRearrange(int oldIndex, int newIndex) {
        this.framePanel.requestRearrange(oldIndex, newIndex);

        remove(this.bottomPanel);
        addBottomPanel();

        new Updater(this.bottomPanel);
    }

    // MODIFIES: this
    // EFFECTS: requests frame panel to edit current challenge to have a name of newName
    // and a description of newDesc
    public void requestEditChallenge(String newName, String newDesc) {
        this.framePanel.requestEditChallenge(newName, newDesc);

        remove(this.currentChallengeCard);
        addCurrentChallengeCard();

        new Updater(this.currentChallengeCard);
    }

    // MODIFIES: this
    // EFFECTS: requests frame panel to step into mini elaborated challenge of given index
    public void requestStepInto(int miniElaboratedChallengeIndex) {
        this.framePanel.requestStepInto(miniElaboratedChallengeIndex);
    }

    // MODIFIES: this
    // EFFECTS: requests frame panel to exit current challenge
    public void requestExitCurrentChallenge() {
        this.framePanel.requestExitCurrentChallenge();
    }

    // MODIFIES: this
    // EFFECTS: requests current challenge to toggle checked state and update bottom pane, main panel top bar,
    //          and current challenge card
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

    // MODIFIES: this
    // EFFECTS: requests current challenge to toggle its mini elaborated challenge of given index
    //          and updates bottom panel and current challenge card
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
