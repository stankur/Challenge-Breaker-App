package ui.views.sidepanel;

import model.Challenge;

import ui.fomattingdata.FormattingData;
import ui.fomattingdata.Theme;
import ui.views.FramePanel;
import ui.views.sidepanel.challengetree.TreeHolder;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    private FormattingData formattingData;
    private Challenge mainChallenge;

    private FramePanel framePanel;

    private TreeHolder treeHolder;
    private SidePanelBottomBar sidePanelBottomBar;

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

    private void addSidePanelTopBar() {
        add(new SidePanelTopBar(this.formattingData, this), BorderLayout.NORTH);
    }

    private void addTreeHolder() {
        this.treeHolder = new TreeHolder(this.formattingData, mainChallenge, this);
        System.out.println(mainChallenge.getElaboratedMiniChallenges().getChallenges());

        add(this.treeHolder, BorderLayout.CENTER);
    }

    private void addSidePanelBottomBar() {
        this.sidePanelBottomBar = new SidePanelBottomBar(this.formattingData, this);
        add(this.sidePanelBottomBar, BorderLayout.SOUTH);
    }

    public void requestLoad() {
        this.framePanel.requestLoad();
    }

    public void requestSave() {
        this.framePanel.requestSave();
    }

    public void requestChangeTheme(Theme theme) {
        this.framePanel.requestChangeTheme(theme);
    }
}
