package ui.views.sidepanel;

import model.Challenge;

import ui.fomattingdata.FormattingData;
import ui.views.FramePanel;
import ui.views.MainFrame;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    private FormattingData formattingData;
    private Challenge mainChallenge;

    private FramePanel framePanel;

    public SidePanel(FormattingData formattingData, Challenge mainChallenge, FramePanel framePanel) {
        super();

        this.formattingData = formattingData;
        this.framePanel = framePanel;
        this.mainChallenge = mainChallenge;

        setPreferredSize(new Dimension(
                this.formattingData.getSidePanelWidth(),
                this.formattingData.getAppHeight()
        ));
        setBackground(this.formattingData.getSidePanelBackground());
        setLayout(new BorderLayout());

        add(new SidePanelTopBar(this.formattingData, this), BorderLayout.NORTH);
        add(new TreeHolder(this.formattingData, this), BorderLayout.CENTER);
        add(new SidePanelBottomBar(this.formattingData, this), BorderLayout.SOUTH);
    }


}
