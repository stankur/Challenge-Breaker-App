package ui.views.reusables;

import ui.fomattingdata.FormattingData;

import javax.swing.*;
import java.awt.*;

public class HeaderBar extends JPanel {
    FormattingData formattingData;
    int headerHeight;
    int headerWidth;
    String title;

    public HeaderBar(FormattingData formattingData, String title, int headerWidth) {
        super();

        this.formattingData = formattingData;

        this.headerHeight = this.formattingData.getSquareButtonSize()
                + 2 * this.formattingData.getSmallGap();
        this.headerWidth = headerWidth;
        this.title = title;

        setPreferredSize(new Dimension(
                this.headerWidth,
                this.headerHeight
        ));

        setBackground(this.formattingData.getCardBackground());
        setLayout(null);

        SquareButton checkBox = createCheckBox();
        checkBox.setLocation(
                this.formattingData.getSmallGap(),
                this.formattingData.getSmallGap());

        add(checkBox);
        add(createNameLabel());


    }

    private JLabel createNameLabel() {
        int borderedButtonWidth = this.formattingData.getSmallGap() + this.formattingData.getSquareButtonSize();

        JLabel challengeName = new JLabel();
        challengeName.setText(this.title);
        challengeName.setBounds(borderedButtonWidth + this.formattingData.getSmallGap(),
                this.formattingData.getSmallGap(),
                this.headerWidth
                        - 4 * borderedButtonWidth
                        - 3 + this.formattingData.getSmallGap(),
                this.formattingData.getSquareButtonSize());
        challengeName.setForeground(this.formattingData.getTextColor());
        challengeName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, this.formattingData.getBigFont()));
        challengeName.setHorizontalAlignment(JLabel.LEFT);
        challengeName.setVerticalAlignment(JLabel.CENTER);

        return challengeName;
    }

    private SquareButton createCheckBox() {
        return new SquareButton(this.formattingData, "◼");
    }


    public int getHeaderHeight() {
        return this.headerHeight;
    }

    public int getHeaderWidth() {
        return this.headerWidth;
    }
}
