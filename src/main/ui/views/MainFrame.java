package ui.views;

import model.Challenge;
import ui.ChallengeBreakerController;
import ui.fomattingdata.FormattingData;
import ui.views.helpers.Updater;

import javax.swing.*;

public class MainFrame extends JFrame {
    private FormattingData formattingData;

    private ChallengeBreakerController controller;

    private FramePanel framePanel;


    public MainFrame(FormattingData formattingData, ChallengeBreakerController controller) {
        super("Challenge Breaker");

        this.formattingData = formattingData;
        this.controller = controller;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        addFramePanel();
        pack();
    }

    public void addFramePanel() {
        this.framePanel = new FramePanel(this.formattingData, this, this.controller.getLayerNavigator(),
                this.controller.getMainChallenge());

        add(this.framePanel);
    }
}
