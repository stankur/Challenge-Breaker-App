package ui.views;

import model.Challenge;
import ui.fomattingdata.FormattingData;
import ui.views.MainFrame;
import ui.views.helpers.Updater;
import ui.views.mainpanel.MainPanel;
import ui.views.sidepanel.SidePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FramePanel extends JPanel {
    private FormattingData formattingData;
    private MainFrame mainFrame;
    private Challenge mainChallenge;
    private Challenge currentChallenge;
    private List<Challenge> visitedLayers;

    private SidePanel sidePanel;
    private MainPanel mainPanel;

    public FramePanel(FormattingData formattingData, MainFrame mainFrame,
                      Challenge mainChallenge, Challenge currentChallenge,
                      List<Challenge> visitedLayers) {
        this.formattingData = formattingData;
        this.mainFrame = mainFrame;
        this.mainChallenge = mainChallenge;
        this.currentChallenge = currentChallenge;
        this.visitedLayers = visitedLayers;

        setSize(this.formattingData.getAppWidth(), this.formattingData.getAppHeight());
        setLayout(new BorderLayout());

        addSubComponents();
    }

    private List<String> getVisitedLayersString() {
        List<String> visitedLayersString = new ArrayList<>();
        for (Challenge challengeLayer: this.visitedLayers) {
            visitedLayersString.add(challengeLayer.getName());
        }

        return visitedLayersString;
    }

    private void addSubComponents() {
        SidePanel sidePanel = new SidePanel(this.formattingData, mainChallenge, this);
        MainPanel mainPanel = new MainPanel(
                this.formattingData,
                getVisitedLayersString(),
                currentChallenge,
                this
        );

        this.sidePanel = sidePanel;
        this.mainPanel = mainPanel;

        add(sidePanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.EAST);
    }

    public void requestAddChallenge(String name, String description) {
        this.currentChallenge.addElaboratedMiniChallenge(new Challenge(name, description));

        remove(this.sidePanel);
        remove(this.mainPanel);

        addSubComponents();

        new Updater(this);
    }


}