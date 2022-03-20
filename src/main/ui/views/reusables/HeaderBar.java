package ui.views.reusables;

import ui.fomattingdata.FormattingData;
import ui.views.CheckListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class HeaderBar extends JPanel {
    FormattingData formattingData;
    String title;
    JLabel challengeName;
    CheckListener checkListener;
    int index;
    boolean isChecked;

    public HeaderBar(FormattingData formattingData,
                     String title,
                     CheckListener checkListener, int index, boolean isChecked) {
        super();

        this.formattingData = formattingData;

        this.title = title;
        this.checkListener = checkListener;
        this.index = index;
        this.isChecked = isChecked;

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
        JLabel challengeName = new JLabel();
        challengeName.setText(this.title);
        challengeName.setBounds(this.formattingData.getBorderedButtonWidth() + this.formattingData.getSmallGap(),
                this.formattingData.getSmallGap(),
                this.formattingData.getCardWidth()
                        - 4 * this.formattingData.getBorderedButtonWidth()
                        - 3 + this.formattingData.getSmallGap(),
                this.formattingData.getSquareButtonSize());
        challengeName.setForeground(this.formattingData.getTextColor());
        challengeName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, this.formattingData.getBigFont()));
        challengeName.setHorizontalAlignment(JLabel.LEFT);
        challengeName.setVerticalAlignment(JLabel.CENTER);

        return challengeName;
    }

    private String resolveCheck() {
        if (this.isChecked) {
            return "◼";
        } else {
            return " ";
        }
    }

    private SquareButton createCheckBox() {
        return new SquareButton(this.formattingData, resolveCheck()) {
            @Override
            public void mouseClicked(MouseEvent e) {
                checkListener.toggleCheck(index);
            }
        };
    }


    public int getHeaderHeight() {
        return this.formattingData.getHeaderHeight();
    }

    public int getHeaderWidth() {
        return this.formattingData.getCardWidth();
    }
}
