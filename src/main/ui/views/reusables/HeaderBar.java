package ui.views.reusables;

import ui.fomattingdata.FormattingData;
import ui.views.CheckListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

// represents a header bar
public class HeaderBar extends JPanel {
    FormattingData formattingData;
    String title;
    CheckListener checkListener;
    int index;
    boolean isChecked;

    // EFFECTS: constructs a header bar with given formatting data, of title of given title,
    //          reference to given checkListener, of index of given index, and of checked state of given
    //          checked state
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

    // EFFECTS: returns a label of the name of the challenge with appropriate formatting
    private JLabel createNameLabel() {
        JLabel challengeName = new JLabel();
        challengeName.setText(this.title);
        challengeName.setBounds(this.formattingData.getBorderedButtonWidth() + this.formattingData.getSmallGap(),
                this.formattingData.getSmallGap(),
                this.formattingData.getCardWidth()
                        - 4 * this.formattingData.getBorderedButtonWidth()
                        - 2 * this.formattingData.getSmallGap(),
                this.formattingData.getSquareButtonSize());
        challengeName.setForeground(this.formattingData.getTextColor());
        challengeName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, this.formattingData.getBigFont()));
        challengeName.setHorizontalAlignment(JLabel.LEFT);
        challengeName.setVerticalAlignment(JLabel.CENTER);

        return challengeName;
    }

    // EFFECTS: returns the symbol to be used inside the checked box depending on this' checked state
    private String resolveCheck() {
        if (this.isChecked) {
            return "◼";
        } else {
            return " ";
        }
    }

    // EFFECTS: returns a checkbox
    private SquareButton createCheckBox() {
        return new SquareButton(this.formattingData, resolveCheck(), null) {
            @Override
            public void mousePressed(MouseEvent e) {
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
