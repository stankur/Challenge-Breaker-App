package ui.views;

import model.Challenge;
import ui.LayerNavigator;
import ui.fomattingdata.FormattingData;
import ui.fomattingdata.Theme;
import ui.views.helpers.Updater;
import ui.views.mainpanel.MainPanel;
import ui.views.sidepanel.SidePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// represents the outermost panel
public class FramePanel extends JPanel {
    private FormattingData formattingData;
    private MainFrame mainFrame;
    private Challenge mainChallenge;
    private LayerNavigator layerNavigator;

    private SidePanel sidePanel;
    private MainPanel mainPanel;

    // EFFECTS: constructs a frame panel with given formatting data, reference to main frame,
    //          given layer navigator, and given main challenge
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

    // EFFECTS: returns a list of visited layers' names
    private List<String> getVisitedLayersString() {
        List<String> visitedLayersString = new ArrayList<>();
        for (Challenge challengeLayer: this.layerNavigator.getVisitedLayers()) {
            visitedLayersString.add(challengeLayer.getName());
        }

        return visitedLayersString;
    }

    // MODIFIES: this
    // EFFECTS: adds side panel to this panel at the left
    private void addSidePanel() {
        SidePanel sidePanel = new SidePanel(this.formattingData, mainChallenge, this);

        this.sidePanel = sidePanel;

        add(sidePanel, BorderLayout.WEST);
    }

    // MODIFIES: this
    // EFFECTS: adds main panel to this panel at the right
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

    // MODIFIES: this
    // EFFECTS: requests layer navigator to add mini challenge of given name and given string to
    //          current challenge and re-renders side panel and main panel.
    public void requestAddChallenge(String name, String description) {
        this.layerNavigator.getCurrentChallenge().addElaboratedMiniChallenge(new Challenge(name, description));

        remove(this.sidePanel);
        remove(this.mainPanel);

        addSidePanel();
        addMainPanel();

        new Updater(this.sidePanel);
        new Updater(this.mainPanel);
    }

    // MODIFIES: this
    // EFFECTS: requests layer navigator to remove mini challenge of current challenge of given index
    //          and re-renders side panel.
    public void requestRemoveChallenge(int index) {
        Challenge challengeToBeRemoved = this.layerNavigator.getCurrentChallenge().getElaboratedMiniChallenges()
                .getChallenges().get(index);
        this.layerNavigator.getCurrentChallenge().removeElaboratedMiniChallenge(challengeToBeRemoved);

        remove(this.sidePanel);

        addSidePanel();

        new Updater(this.sidePanel);
    }

    // MODIFIES: this
    // EFFECTS: requests layer navigator to move mini challenge of current challenge of given oldIndex to
    //          newIndex and re-renders side panel.
    public void requestRearrange(int oldIndex, int newIndex) {
        this.layerNavigator.getCurrentChallenge().changePosition(oldIndex, newIndex);

        remove(this.sidePanel);

        addSidePanel();

        new Updater(this.sidePanel);
    }

    // MODIFIES: this
    // EFFECTS: requests layer navigator to change name and description of current challenge
    //          to given newName and newDesc and re-renders side panel.
    public void requestEditChallenge(String newName, String newDesc) {
        this.layerNavigator.getCurrentChallenge().editName(newName);
        this.layerNavigator.getCurrentChallenge().editDescription(newDesc);

        remove(this.sidePanel);
        addSidePanel();

        new Updater(this.sidePanel);
    }

    // MODIFIES: this
    // EFFECTS: requests layer navigator to step into mini challenge of index of
    //          given elaboratedMiniChallengeIndex and re-renders main panel
    public void requestStepInto(int elaboratedMiniChallengeIndex) {
        this.layerNavigator.stepInto(elaboratedMiniChallengeIndex);

        remove(this.mainPanel);

        addMainPanel();

        new Updater(this.mainPanel);
    }

    // MODIFIES: this
    // EFFECTS: requests layer navigator to exit current layer and re-renders main panel
    public void requestExitCurrentChallenge() {
        this.layerNavigator.exitCurrentLayer();

        remove(this.mainPanel);

        addMainPanel();

        new Updater(this.mainPanel);
    }

    // MODIFIES: this
    // EFFECTS: requests main frame to load previous data
    public void requestLoad() {
        this.mainFrame.requestLoad();
    }

    // MODIFIES: this
    // EFFECTS: requests main frame to save current data
    public void requestSave() {
        this.mainFrame.requestSave();
    }

    // MODIFIES: this
    // EFFECTS: requests main frame to change theme into given theme
    public void requestChangeTheme(Theme theme) {
        this.mainFrame.requestChangeTheme(theme);
    }

}