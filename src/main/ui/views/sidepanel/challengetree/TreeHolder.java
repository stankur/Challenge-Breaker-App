package ui.views.sidepanel.challengetree;

import model.Challenge;
import ui.fomattingdata.FormattingData;
import ui.views.sidepanel.SidePanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.ArrayList;

// represents a tree holder
public class TreeHolder extends JPanel {
    private FormattingData formattingData;
    private SidePanel sidePanel;
    private Challenge mainChallenge;

    // EFFECTS: constructs a tree holder with given formatting data, main challenge and reference to side panel
    public TreeHolder(FormattingData formattingData, Challenge mainChallenge, SidePanel sidePanel) {
        super(new GridLayout());

        this.formattingData = formattingData;
        this.sidePanel = sidePanel;
        this.mainChallenge = mainChallenge;

        Border pusher = BorderFactory.createEmptyBorder(
                this.formattingData.getSmallGap(),
                this.formattingData.getMediumGap(),
                0,
                0);
        setPreferredSize(new Dimension(this.formattingData.getSidePanelWidth(),
                this.formattingData.getSidePanelWidth()));
        setBorder(pusher);
        setBackground(this.formattingData.getSidePanelBackground());

        addTree();
    }

    // MODIFIES: this
    // EFFECTS: adds challenge info node tree at expanded state
    private void addTree() {
        JTree tree = new JTree(createChallengeInfoNode()) {
            // code retrieved from
            // https://www.tutorialspoint.com/can-we-prevent-the-collapse-of-nodes-and-child-nodes-in-a-jtree-with-java
            protected void setExpandedState(TreePath path, boolean state) {
                if (state) {
                    super.setExpandedState(path, state);
                }
            }
        };

        // code retrieved from
        // https://stackoverflow.com/questions/15210979/how-do-i-auto-expand-a-jtree-when-setting-a-new-treemodel
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }


        tree.setBackground(this.formattingData.getSidePanelBackground());

        tree.setCellRenderer(createTreeCellRenderer());
        tree.setRowHeight(this.formattingData.getBarHeight());

        add(tree);
    }

    // EFFECTS: returns a tree cell renderer assigns to this' formatting data
    private TreeCellRenderer createTreeCellRenderer() {
        TreeCellRenderer treeCellRenderer = new TreeCellRenderer();
        treeCellRenderer.assignFormattingData(this.formattingData);

        return treeCellRenderer;
    }

    // EFFECTS: returns a new tree of challenge info with main challenge as the root
    private DefaultMutableTreeNode createChallengeInfoNode() {

        return new ChallengeInfoTree(new ChallengeInfo(
                this.mainChallenge,
                new ArrayList<>()
        ));
    }
}
