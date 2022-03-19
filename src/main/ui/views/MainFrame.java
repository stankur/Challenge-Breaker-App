package ui.views;

import model.Challenge;
import ui.ChallengeBreakerController;
import ui.fomattingdata.FormattingData;

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

        this.framePanel = new FramePanel(this.formattingData, this, this.controller.getCurrentChallenge(),
                this.controller.getMainChallenge(),
                this.controller.getCurrentChallenge().getElaboratedMiniChallenges().getChallenges());

        add(this.framePanel);
        pack();
    }
}
