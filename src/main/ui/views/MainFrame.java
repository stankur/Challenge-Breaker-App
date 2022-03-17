package ui.views;

import model.Challenge;
import ui.ChallengeBreakerController;
import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.MainPanel;
import ui.views.sidepanel.SidePanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private FormattingData formattingData;

    private ChallengeBreakerController controller;

    private SidePanel sidePanel;
    private MainPanel mainPanel;


    public MainFrame(FormattingData formattingData, ChallengeBreakerController controller) {
        super("Challenge Breaker");

        this.formattingData = formattingData;
        this.controller = controller;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        add(createFramePanel());
        pack();
    }

    private JPanel createFramePanel() {
        JPanel framePanel = new JPanel();
        framePanel.setSize(
                this.formattingData.getAppWidth(),
                this.formattingData.getAppHeight());
        framePanel.setLayout(new BorderLayout());

        Challenge mainChallenge = this.controller.getMainChallenge();
        this.sidePanel = new SidePanel(this.formattingData, mainChallenge, this);
        this.mainPanel = new MainPanel(this.formattingData, this);

        framePanel.add(this.sidePanel, BorderLayout.WEST);
        framePanel.add(this.mainPanel, BorderLayout.EAST);

        return framePanel;
    }

}
