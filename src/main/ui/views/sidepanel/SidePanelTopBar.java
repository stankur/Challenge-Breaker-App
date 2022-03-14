package ui.views.sidepanel;

import ui.fomattingdata.FormattingData;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SidePanelTopBar extends JPanel {
    private FormattingData formattingData;

    public SidePanelTopBar(FormattingData formattingData) {
        super();

        this.formattingData = formattingData;

        setPreferredSize(new Dimension(250, 25));
        setBackground(this.formattingData.getSidePanelTopBarBackground());

        JLabel description = new JLabel();

        description.setPreferredSize(new Dimension(250, 25));
        description.setText("Challenge Structure");

        Border pusher = BorderFactory.createEmptyBorder(0, 20, 0, 0);
        description.setBorder(pusher);
        description.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
        description.setForeground(this.formattingData.getTextColor());

        description.setHorizontalAlignment(JLabel.LEFT);
        description.setVerticalAlignment(JLabel.TOP);

        add(description);
    }
}
