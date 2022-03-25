package ui.views.mainpanel;

import ui.fomattingdata.FormattingData;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

// represents the top bar of main panel
public class MainPanelTopBar extends JPanel {
    private FormattingData formattingData;
    private List<String> visitedLayers;

    // EFFECTS: constructs a new main panel top bar with given formatting data and visited layers
    public MainPanelTopBar(FormattingData formattingData, List<String> visitedLayers) {
        super();
        this.formattingData = formattingData;
        this.visitedLayers = visitedLayers;

        setPreferredSize(
                new Dimension(this.formattingData.getMainPanelWidth(),
                this.formattingData.getBarHeight())
        );
        setBackground(this.formattingData.getMainTopBarBackground());

        add(visitedLayers());
    }

    // EFFECTS: returns a label with visited layers information
    private JLabel visitedLayers() {
        JLabel description = new JLabel();

        description.setPreferredSize(new Dimension(
                this.formattingData.getMainPanelWidth(),
                this.formattingData.getBarHeight())
        );
        description.setText(getVisitedLayersString());

        Border pusher = BorderFactory.createEmptyBorder(0, this.formattingData.getMediumGap(), 0, 0);
        description.setBorder(pusher);
        description.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, this.formattingData.getSmallFont()));
        description.setForeground(this.formattingData.getTextColor());

        description.setHorizontalAlignment(JLabel.LEFT);
        description.setVerticalAlignment(JLabel.TOP);

        return description;
    }

    // EFFECTS: returns a string of visited layers names
    private String getVisitedLayersString() {
        int size = this.visitedLayers.size();

        if (this.visitedLayers.size() == 0) {
            return "";
        }

        String accumulator = "";

        for (int i = 0; i < size - 1; i++) {
            accumulator = accumulator + this.visitedLayers.get(i) + " - ";
        }

        accumulator += this.visitedLayers.get(size - 1);

        return accumulator;
    }
}
