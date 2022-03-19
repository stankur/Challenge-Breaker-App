package ui.views.mainpanel.minichallengesarea.minichallengespanel;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.MainPanel;
import ui.views.reusables.HeaderBar;

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
            panel.setPreferredSize(new Dimension(this.formattingData.getMainPanelWidth(),
                    this.formattingData.getMiniElaboratedChallengesPaneHeight()));
        } else {
            panel.setPreferredSize(new Dimension(
                    this.formattingData.getMainPanelWidth(), theoreticalPanelHeight));
        }

        panel.setBackground(this.formattingData.getMainBackground());

        for (int i = 0; i < numberOfMiniChallenges; i++) {
            HeaderBar miniChallengeBar = new MiniChallengeHeader(
                    this.formattingData, this, challengeNames.get(i), i);

            miniChallengeBar.setBounds(this.formattingData.getSmallGap(), i * borderedMiniChallengeBarHeight,
                    miniChallengeBar.getHeaderWidth(), miniChallengeBar.getHeaderHeight());

            panel.add(miniChallengeBar);
        }

        return panel;
    }

    public void requestRemoveChallenge(int index) {
        this.mainPanel.requestRemoveChallenge(index);
    }


}
