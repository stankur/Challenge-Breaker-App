package ui.views.sidepanel.challengetree;

import ui.fomattingdata.FormattingData;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

// represents a tree cell renderer
public class TreeCellRenderer extends DefaultTreeCellRenderer {
    private FormattingData formattingData;

    // EFFECTS: constructs a tree cell renderer
    public TreeCellRenderer() {
        super();
        // code from:
        // https://kodejava.org/how-do-i-remove-jtree-default-icons/#:~
        // :text=You%20can%20remove%20JTree%20default,setClosedIcon()%20and%20setOpenIcon()%20.
        setLeafIcon(UIManager.getIcon("Tree.collapsedIcon"));
        setClosedIcon(UIManager.getIcon("Tree.collapsedIcon"));
        setOpenIcon(UIManager.getIcon("Tree.collapsedIcon"));
        UIManager.put("Tree.expandedIcon", new EmptyTreeIcon());
    }

    // MODIFIES: this
    // EFFECTS: assigns given formatting data to this.formattingData
    public void assignFormattingData(FormattingData formattingData) {
        this.formattingData = formattingData;
    }

    // EFFECTS: returns tree cell renderer label
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
                                                  boolean sel, boolean exp, boolean leaf, int row, boolean hasFocus) {
        JLabel label = (JLabel) super.getTreeCellRendererComponent(tree, value, sel, exp, leaf, row, hasFocus);

        label.setBackground(this.formattingData.getSidePanelBackground());
        label.setForeground(this.formattingData.getTextColor());
        label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
        label.setOpaque(true);

        return label;
    }

}
