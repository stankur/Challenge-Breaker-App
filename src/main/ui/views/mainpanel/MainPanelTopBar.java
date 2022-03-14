package ui.views.mainpanel;

import ui.fomattingdata.FormattingData;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainPanelTopBar extends JPanel {
    private FormattingData formattingData;
    private List<String> visitedLayers;

    public MainPanelTopBar(FormattingData formattingData, ArrayList<String> visitedLayers) {
        super();
        this.formattingData = formattingData;
        this.visitedLayers = visitedLayers;

        setPreferredSize(new Dimension(500, 25));
        setBackground(this.formattingData.getMainTopBarBackground());

        add(visitedLayers());
    }

    private JLabel visitedLayers() {
        JLabel description = new JLabel();

        description.setPreferredSize(new Dimension(500, 25));
        description.setText(getVisitedLayersString());

        Border pusher = BorderFactory.createEmptyBorder(0, 20, 0, 0);
        description.setBorder(pusher);
        description.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
        description.setForeground(this.formattingData.getTextColor());

        description.setHorizontalAlignment(JLabel.LEFT);
        description.setVerticalAlignment(JLabel.TOP);

        return description;
    }

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
