package ui;

import ui.fomattingdata.FormattingData;
import ui.fomattingdata.Theme;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class TreeCellRenderer extends DefaultTreeCellRenderer {
    private FormattingData formattingData;

    public void assignFormattingData(FormattingData formattingData) {
        this.formattingData = formattingData;
    }

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
