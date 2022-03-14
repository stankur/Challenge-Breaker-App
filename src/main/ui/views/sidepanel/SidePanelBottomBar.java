package ui.views.sidepanel;

import ui.fomattingdata.FormattingData;
import ui.views.reusables.SquareButton;

import javax.swing.*;
import java.awt.*;

public class SidePanelBottomBar extends JPanel {
    private FormattingData formattingData;

    public SidePanelBottomBar(FormattingData formattingData) {
        super();

        this.formattingData = formattingData;

        setPreferredSize(new Dimension(250, 60));
        setBackground(this.formattingData.getSidePanelBackground());

        SquareButton saveButton = new SquareButton(this.formattingData, "S");
        SquareButton loadButton = new SquareButton(this.formattingData, "L");

        saveButton.setLocation(10,10);
        loadButton.setLocation(58,10);

        setLayout(null);
        add(saveButton);
        add(loadButton);

    }
}
