package ui.views.mainpanel;

import ui.fomattingdata.FormattingData;
import ui.views.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    private FormattingData formattingData;
    private MainFrame mainFrame;

    public MainPanel(FormattingData formattingData, MainFrame mainframe) {
        this.formattingData = formattingData;
        this.mainFrame = mainframe;

        setPreferredSize(new Dimension(500, 600));
        setBackground(this.formattingData.getMainBackground());
        setLayout(new BorderLayout());

        ArrayList<String> testVisitedLayers = new ArrayList<>();
        testVisitedLayers.add("Main Challenge");
        testVisitedLayers.add("Some stupid Challenge");
        testVisitedLayers.add("Spongbob");

        add(new MainPanelTopBar(this.formattingData, testVisitedLayers), BorderLayout.NORTH);
        add(new CurrentChallengeCard(this.formattingData,
                "Some Challenge Lol",
                ("Stupid Challenge description that is very long "
                + "so that the line will fukin break and go to a new mf line"
                + " please work lmao I donno anymore what to write hjrnknrfnnlefmfmremmremfmkfr"),
                this), BorderLayout.CENTER);

        JPanel testBottom = new JPanel();
        testBottom.setBorder(BorderFactory.createLineBorder(Color.blue));
        testBottom.setPreferredSize(new Dimension(500, 310));
        add(testBottom, BorderLayout.SOUTH);
    }
}
