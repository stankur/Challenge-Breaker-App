package ui.views.sidepanel;

import model.Challenge;

import ui.fomattingdata.FormattingData;
import ui.views.MainFrame;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    private FormattingData formattingData;

    private Challenge mainChallenge;

    private MainFrame mainFrame;

    public SidePanel(FormattingData formattingData, Challenge mainChallenge, MainFrame mainFrame) {
        super();

        this.formattingData = formattingData;
        this.mainFrame = mainFrame;
        this.mainChallenge = mainChallenge;

        setPreferredSize(new Dimension(
                this.formattingData.getSidePanelWidth(),
                this.formattingData.getAppHeight()
        ));
        setBackground(this.formattingData.getSidePanelBackground());
        setLayout(new BorderLayout());

        add(new SidePanelTopBar(this.formattingData), BorderLayout.NORTH);
        add(new TreeHolder(this.formattingData), BorderLayout.CENTER);
        add(new SidePanelBottomBar(this.formattingData), BorderLayout.SOUTH);
    }


}
