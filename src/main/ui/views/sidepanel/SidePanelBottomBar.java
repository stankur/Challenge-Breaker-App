package ui.views.sidepanel;

import ui.fomattingdata.FormattingData;
import ui.views.reusables.SquareButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class SidePanelBottomBar extends JPanel {
    private FormattingData formattingData;
    private SidePanel sidePanel;

    public SidePanelBottomBar(FormattingData formattingData, SidePanel sidePanel) {
        super();

        this.formattingData = formattingData;
        this.sidePanel = sidePanel;

        setPreferredSize(new Dimension(
                this.formattingData.getSidePanelWidth(),
                this.formattingData.getSquareButtonSize() + 2 * this.formattingData.getSmallGap())
        );
        setBackground(this.formattingData.getSidePanelBackground());

        setLayout(null);

        addSaveButton();
        addLoadButton();
    }

    private void addSaveButton() {
        SquareButton saveButton = new SquareButton(this.formattingData, "↓") {
            @Override
            public void mouseClicked(MouseEvent e) {
                sidePanel.requestSave();
            }
        };

        saveButton.setLocation(
                this.formattingData.getSmallGap(),
                this.formattingData.getSmallGap()
        );

        add(saveButton);
    }

    private void addLoadButton() {
        SquareButton loadButton = new SquareButton(this.formattingData, "↑") {
            @Override
            public void mouseClicked(MouseEvent e) {
                sidePanel.requestLoad();
            }
        };

        loadButton.setLocation(
                this.formattingData.getSquareButtonSize() + 2 * this.formattingData.getSmallGap(),
                this.formattingData.getSmallGap()
        );

        add(loadButton);


    }
}
