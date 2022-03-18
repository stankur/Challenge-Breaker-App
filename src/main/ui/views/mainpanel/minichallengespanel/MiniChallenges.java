package ui.views.mainpanel.minichallengespanel;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.MainPanel;
import ui.views.reusables.HeaderBar;
import ui.views.reusables.SquareButton;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MiniChallenges extends JScrollPane {
    FormattingData formattingData;
    int cardWidth;
    List<String> challengeNames;
    MainPanel mainPanel;


    public MiniChallenges(FormattingData formattingData, MainPanel mainPanel, List<String> challengeNames) {
        super();

        this.formattingData = formattingData;
        this.challengeNames = challengeNames;
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

    private JPanel miniChallengesPanel() {
        JPanel panel = new JPanel();

        int numberOfMiniChallenges = this.challengeNames.size();

        int borderedMiniChallengeBarHeight = this.formattingData.getSquareButtonSize()
                + 3 * this.formattingData.getSmallGap();

        int theoreticalPanelHeight = numberOfMiniChallenges * borderedMiniChallengeBarHeight;

        panel.setLayout(null);

        if (this.formattingData.getMiniElaboratedChallengesPaneHeight() > theoreticalPanelHeight) {
            panel.setPreferredSize(new Dimension(
                    this.formattingData.getMainPanelWidth(),
                    this.formattingData.getMiniElaboratedChallengesPaneHeight()));
        } else {
            panel.setPreferredSize(new Dimension(
                    this.formattingData.getMainPanelWidth(),
                    theoreticalPanelHeight));
        }

        panel.setBackground(this.formattingData.getMainBackground());

        for (int i = 0; i < numberOfMiniChallenges; i++) {
            HeaderBar miniChallengeBar = createMiniChallengeBar(challengeNames.get(i));

            miniChallengeBar.setBounds(
                    this.formattingData.getSmallGap(),
                    i * borderedMiniChallengeBarHeight,
                    miniChallengeBar.getHeaderWidth(),
                    miniChallengeBar.getHeaderHeight());

            panel.add(miniChallengeBar);
        }

        return panel;
    }

    private HeaderBar createMiniChallengeBar(String challengeName) {
        int borderedButtonWidth = this.formattingData.getSquareButtonSize()
                + this.formattingData.getSmallGap();

        HeaderBar emptyBar = new HeaderBar(
                this.formattingData,
                challengeName);

        SquareButton removeButton = createRemoveButton();
        removeButton.setLocation(this.cardWidth - borderedButtonWidth, this.formattingData.getSmallGap());

        SquareButton reArrangeButton = createReArrangeButton();
        reArrangeButton.setLocation(this.cardWidth - 2 * borderedButtonWidth, this.formattingData.getSmallGap());

        SquareButton stepIntoButton = createStepIntoButton();
        stepIntoButton.setLocation(this.cardWidth - 3 * borderedButtonWidth, this.formattingData.getSmallGap());

        emptyBar.add(removeButton);
        emptyBar.add(stepIntoButton);
        emptyBar.add(reArrangeButton);

        return emptyBar;
    }

    private SquareButton createRemoveButton() {
        return new SquareButton(this.formattingData, "✕");
    }

    private SquareButton createStepIntoButton() {
        return new SquareButton(this.formattingData, "→");
    }

    private SquareButton createReArrangeButton() {
        return new SquareButton(this.formattingData, "↕");
    }

}
