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

        setPreferredSize(new Dimension(
                this.formattingData.getSidePanelWidth(),
                this.formattingData.getSquareButtonSize() + 2 * this.formattingData.getSmallGap())
        );
        setBackground(this.formattingData.getSidePanelBackground());

        SquareButton saveButton = new SquareButton(this.formattingData, "↓");
        SquareButton loadButton = new SquareButton(this.formattingData, "↑");

        saveButton.setLocation(
                this.formattingData.getSmallGap(),
                this.formattingData.getSmallGap()
        );
        loadButton.setLocation(
                this.formattingData.getSquareButtonSize() + 2 * this.formattingData.getSmallGap(),
                this.formattingData.getSmallGap()
        );

        setLayout(null);
        add(saveButton);
        add(loadButton);

    }
}
