package ui.views;

import model.Challenge;
import ui.LayerNavigator;
import ui.fomattingdata.FormattingData;
import ui.views.helpers.Updater;
import ui.views.mainpanel.MainPanel;
import ui.views.sidepanel.SidePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FramePanel extends JPanel {
    private FormattingData formattingData;
    private MainFrame mainFrame;
    private Challenge mainChallenge;
    private LayerNavigator layerNavigator;

    private SidePanel sidePanel;
    private MainPanel mainPanel;

    public FramePanel(FormattingData formattingData, MainFrame mainFrame,
                      LayerNavigator layerNavigator, Challenge mainChallenge) {
        this.formattingData = formattingData;
        this.mainFrame = mainFrame;
        this.mainChallenge = mainChallenge;
        this.layerNavigator = layerNavigator;

        setSize(this.formattingData.getAppWidth(), this.formattingData.getAppHeight());
        setLayout(new BorderLayout());

        addSidePanel();
        addMainPanel();
    }

    private List<String> getVisitedLayersString() {
        List<String> visitedLayersString = new ArrayList<>();
        for (Challenge challengeLayer: this.layerNavigator.getVisitedLayers()) {
            visitedLayersString.add(challengeLayer.getName());
        }

        return visitedLayersString;
    }

    private void addSidePanel() {
        SidePanel sidePanel = new SidePanel(this.formattingData, mainChallenge, this);

        this.sidePanel = sidePanel;

        add(sidePanel, BorderLayout.WEST);
    }

    private void addMainPanel() {
        MainPanel mainPanel = new MainPanel(
                this.formattingData,
                getVisitedLayersString(),
                this.layerNavigator.getCurrentChallenge(),
                this
        );

        this.mainPanel = mainPanel;

        add(mainPanel, BorderLayout.EAST);
    }

    public void requestAddChallenge(String name, String description) {
        this.layerNavigator.getCurrentChallenge().addElaboratedMiniChallenge(new Challenge(name, description));

        remove(this.sidePanel);
        remove(this.mainPanel);

        addSidePanel();
        addMainPanel();

        new Updater(this.sidePanel);
        new Updater(this.mainPanel);
    }

    public void requestStepInto(int elaboratedMiniChallengeIndex) {
        this.layerNavigator.stepInto(elaboratedMiniChallengeIndex);

        remove(this.mainPanel);

        addMainPanel();

        new Updater(this.mainPanel);
    }

}