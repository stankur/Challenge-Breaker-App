package ui.views.sidepanel;

import model.Challenge;

import ui.fomattingdata.FormattingData;
import ui.fomattingdata.Theme;
import ui.views.FramePanel;
import ui.views.sidepanel.challengetree.TreeHolder;

import javax.swing.*;
import java.awt.*;

// represents side panel
public class SidePanel extends JPanel {
    private FormattingData formattingData;
    private Challenge mainChallenge;

    private FramePanel framePanel;

    private TreeHolder treeHolder;
    private SidePanelBottomBar sidePanelBottomBar;

    // EFFECTS: creates a side panel with given formatting data, main challenge and reference to frame panel
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

        addSidePanelTopBar();
        addTreeHolder();
        addSidePanelBottomBar();
    }

    // MODIFIES: this
    // EFFECTS: adds side panel top bar to the top of this panel
    private void addSidePanelTopBar() {
        add(new SidePanelTopBar(this.formattingData, this), BorderLayout.NORTH);
    }

    // MODIFIES: this
    // EFFECTS: adds tree holder to the center of this panel
    private void addTreeHolder() {
        this.treeHolder = new TreeHolder(this.formattingData, mainChallenge, this);
        System.out.println(mainChallenge.getElaboratedMiniChallenges().getChallenges());

        add(this.treeHolder, BorderLayout.CENTER);
    }

    // MODIFIES: this
    // EFFECTS: adds side panel bottom bar to the bottom of this panel
    private void addSidePanelBottomBar() {
        this.sidePanelBottomBar = new SidePanelBottomBar(this.formattingData, this);
        add(this.sidePanelBottomBar, BorderLayout.SOUTH);
    }

    // MODIFIES: this
    // EFFECTS: requests frame panel to load previous data
    public void requestLoad() {
        this.framePanel.requestLoad();
    }

    // MODIFIES: this
    // EFFECTS: requests frame panel to save current data
    public void requestSave() {
        this.framePanel.requestSave();
    }

    // MODIFIES: this
    // EFFECTS: requests frame panel to change theme into given theme
    public void requestChangeTheme(Theme theme) {
        this.framePanel.requestChangeTheme(theme);
    }
}
