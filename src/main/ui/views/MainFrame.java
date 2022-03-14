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
        setSize(750,600);
        setResizable(false);
        setLayout(new BorderLayout());

        Challenge mainChallenge = this.controller.getMainChallenge();
        this.sidePanel = new SidePanel(this.formattingData, mainChallenge, this);
        this.mainPanel = new MainPanel(this.formattingData, this);

        add(this.sidePanel, BorderLayout.WEST);
        add(this.mainPanel, BorderLayout.EAST);
    }


}
