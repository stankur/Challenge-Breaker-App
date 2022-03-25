package ui.views.mainpanel.minichallengesarea.minichallengespanel;

import model.Challenge;
import ui.fomattingdata.FormattingData;
import ui.views.CheckListener;
import ui.views.mainpanel.MainPanel;
import ui.views.reusables.HeaderBar;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// represents mini challenges scroll pane
public class MiniChallenges extends JScrollPane implements CheckListener {
    FormattingData formattingData;
    int cardWidth;
    List<Challenge> challenges;
    MainPanel mainPanel;

    // EFFECTS: constructs a mini challenges scroll pane with given formatting data, reference to main panel,
    //          and challenges of given list of challenges
    public MiniChallenges(FormattingData formattingData, MainPanel mainPanel, List<Challenge> challenges) {
        super();

        this.formattingData = formattingData;
        this.challenges = challenges;
        this.mainPanel = mainPanel;
        this.cardWidth = this.formattingData.getMainPanelWidth() - 2 * this.formattingData.getSmallGap();

        setPreferredSize(new Dimension(
                this.formattingData.getMainPanelWidth(),
                this.formattingData.getMiniElaboratedChallengesPaneHeight()));
        setBackground(this.formattingData.getMainBackground());
        setViewportView(miniChallengesPanel());

        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JScrollBar verticalScrollBar = new JScrollBar(JScrollBar.VERTICAL) {

            @Override
            public boolean isVisible() {
                return true;
            }
        };

        setVerticalScrollBar(verticalScrollBar);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        setBorder(BorderFactory.createEmptyBorder());
    }

    // EFFECTS: creates a new panel holding this.challenges
    private JPanel miniChallengesPanel() {
        JPanel panel = new JPanel();

        int numberOfMiniChallenges = this.challenges.size();

        int borderedMiniChallengeBarHeight = this.formattingData.getSquareButtonSize()
                + 3 * this.formattingData.getSmallGap();

        int theoreticalPanelHeight = numberOfMiniChallenges * borderedMiniChallengeBarHeight;

        panel.setLayout(null);

        if (this.formattingData.getMiniElaboratedChallengesPaneHeight() > theoreticalPanelHeight) {
            panel.setPreferredSize(new Dimension(this.formattingData.getMainPanelWidth(),
                    this.formattingData.getMiniElaboratedChallengesPaneHeight()));
        } else {
            panel.setPreferredSize(new Dimension(
                    this.formattingData.getMainPanelWidth(), theoreticalPanelHeight));
        }

        panel.setBackground(this.formattingData.getMainBackground());

        for (int i = 0; i < numberOfMiniChallenges; i++) {
            Challenge challenge = this.challenges.get(i);
            HeaderBar miniChallengeBar = new MiniChallengeHeader(
                    this.formattingData, this, challenge.getName(), i, challenge.isChecked());

            miniChallengeBar.setBounds(this.formattingData.getSmallGap(), i * borderedMiniChallengeBarHeight,
                    miniChallengeBar.getHeaderWidth(), miniChallengeBar.getHeaderHeight());

            panel.add(miniChallengeBar);
        }

        return panel;
    }

    // MODIFIES: this
    // EFFECTS: requests main panel to remove challenge of given index
    public void requestRemoveChallenge(int index) {
        this.mainPanel.requestRemoveChallenge(index);
    }

    // MODIFIES: this
    // EFFECTS: requests to rearrange challenge of old index to challenge of new index
    public void requestRearrange(int oldIndex, int newIndex) {
        int challengeNamesSize = this.challenges.size();
        int max = challengeNamesSize - 1;
        int min = 0;

        if (newIndex > max) {
            newIndex = max;
        } else if (newIndex < min) {
            newIndex = min;
        }

        System.out.println("old index is " + oldIndex + " new index is: " + newIndex);
        this.mainPanel.requestRearrange(oldIndex, newIndex);
    }

    // MODIFIES: this
    // EFFECTS: requests main panel to step into mini elaborated challenge of given index
    public void requestStepInto(int miniElaboratedChallengeIndex) {
        this.mainPanel.requestStepInto(miniElaboratedChallengeIndex);
    }

    // MODIFIES: this
    // EFFECTS: requests main panel to toggle checked state of ini elaborated challenge of given index
    @Override
    public void toggleCheck(int index) {
        this.mainPanel.toggleCheckElaboratedMiniChallenge(index);
    }
}
