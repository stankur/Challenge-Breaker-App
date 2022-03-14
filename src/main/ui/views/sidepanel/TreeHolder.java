package ui.views.sidepanel;

import ui.fomattingdata.FormattingData;
import ui.TreeCellRenderer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class TreeHolder extends JPanel {
    private FormattingData formattingData;

    public TreeHolder(FormattingData formattingData) {
        super(new GridLayout());

        this.formattingData = formattingData;

        JTree tree = new JTree(testTree());
        tree.setBackground(this.formattingData.getSidePanelBackground());

        TreeCellRenderer treeCellRenderer = new TreeCellRenderer();
        treeCellRenderer.assignFormattingData(this.formattingData);

        tree.setCellRenderer(treeCellRenderer);
        tree.setRowHeight(25);

        Border pusher = BorderFactory.createEmptyBorder(10,20,0,0);
        setPreferredSize(new Dimension(250, 250));
        setBorder(pusher);
        setBackground(this.formattingData.getSidePanelBackground());
        add(tree);
    }

    public DefaultMutableTreeNode testTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode root0 = new DefaultMutableTreeNode("Root0");
        DefaultMutableTreeNode root1 = new DefaultMutableTreeNode("Root1");
        DefaultMutableTreeNode root2 = new DefaultMutableTreeNode("Root2");
        DefaultMutableTreeNode root00 = new DefaultMutableTreeNode("Root00");

        root0.add(root00);

        root.add(root0);
        root.add(root1);
        root.add(root2);

        return root;
    }

}
