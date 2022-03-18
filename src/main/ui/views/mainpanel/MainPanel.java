package ui.views.mainpanel;

import ui.fomattingdata.FormattingData;
import ui.views.MainFrame;
import ui.views.mainpanel.challengecardpanel.CurrentChallengeCard;
import ui.views.mainpanel.minichallengespanel.MiniChallenges;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel {
    private FormattingData formattingData;
    private MainFrame mainFrame;

    public MainPanel(FormattingData formattingData, MainFrame mainframe) {
        this.formattingData = formattingData;
        this.mainFrame = mainframe;

        setPreferredSize(
                new Dimension(
                        this.formattingData.getMainPanelWidth(),
                        this.formattingData.getAppHeight()
                )
        );
        setBackground(this.formattingData.getMainBackground());
        setLayout(new BorderLayout());

        ArrayList<String> testVisitedLayers = new ArrayList<>();
        testVisitedLayers.add("Main Challenge");

        add(new MainPanelTopBar(this.formattingData, testVisitedLayers), BorderLayout.NORTH);

        add(new CurrentChallengeCard(this.formattingData,
                this,
                "Some Challenge Lol",
                ("Stupid Challenge description that is very long "
                + "so that the line will fukin break and go to a new mf line"
                + " please work lmao I donno anymore what to write hjrnknrfnnlefmfmremmremfmkfr")
                ), BorderLayout.CENTER);

        add(createTestBottomPanel(), BorderLayout.SOUTH);
    }

    private JPanel createTestBottomPanel() {
        JPanel testBottom = new JPanel();
        testBottom.setPreferredSize(new Dimension(
                this.formattingData.getMainPanelWidth(),
                this.formattingData.getAppHeight()
                        - this.formattingData.getBarHeight()
                        - this.formattingData.getChallengeCardPanelHeight()
                )
        );

        testBottom.setLayout(new BorderLayout());

        testBottom.add(new MiniElaboratedChallengesLabel(
                this.formattingData
        ),
                BorderLayout.NORTH);

        List<String> testNames = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testNames.add("Some stupid sub challenge");
        }

        testBottom.add(new MiniChallenges(this.formattingData, this, testNames));

        return testBottom;
    }
}
