package ui.views.reusables;

import ui.fomattingdata.FormattingData;

import javax.swing.*;
import java.awt.*;

public class HeaderBar extends JPanel {
    FormattingData formattingData;
    String title;

    public HeaderBar(FormattingData formattingData, String title) {
        super();

        this.formattingData = formattingData;

        this.title = title;

        setPreferredSize(new Dimension(
                this.formattingData.getCardWidth(),
                this.formattingData.getHeaderHeight()
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
                this.formattingData.getCardWidth()
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
        return this.formattingData.getHeaderHeight();
    }

    public int getHeaderWidth() {
        return this.formattingData.getCardWidth();
    }
}
