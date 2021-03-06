package ui.views.sidepanel;

import ui.fomattingdata.FormattingData;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// represents side panel top bar
public class SidePanelTopBar extends JPanel {
    private FormattingData formattingData;
    private SidePanel sidePanel;

    // EFFECTS: constructs a new top bar with given formatting data and reference to side panel
    public SidePanelTopBar(FormattingData formattingData, SidePanel sidePanel) {
        super();

        this.formattingData = formattingData;
        this.sidePanel = sidePanel;

        setPreferredSize(new Dimension(
                this.formattingData.getSidePanelWidth(),
                this.formattingData.getBarHeight()
        ));
        setBackground(this.formattingData.getSidePanelTopBarBackground());

        JLabel description = new JLabel();

        description.setPreferredSize(new Dimension(
                this.formattingData.getSidePanelWidth(),
                this.formattingData.getBarHeight()));
        description.setText("Challenge Structure");

        Border pusher = BorderFactory.createEmptyBorder(0, this.formattingData.getMediumGap(), 0, 0);
        description.setBorder(pusher);
        description.setFont(new Font(
                "Arial Rounded MT Bold", Font.PLAIN, this.formattingData.getSmallFont()
        ));
        description.setForeground(this.formattingData.getTextColor());

        description.setHorizontalAlignment(JLabel.LEFT);
        description.setVerticalAlignment(JLabel.TOP);

        add(description);
    }
}
