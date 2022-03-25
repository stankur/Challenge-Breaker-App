package ui.views.mainpanel.minichallengesarea.minichallengespanel.buttons.rearrangebutton;

import ui.fomattingdata.FormattingData;
import ui.views.reusables.SquareButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class NewPositionPrompterPanel extends JPanel {
    private FormattingData formattingData;
    private NewPositionPrompterListener listener;
    private JTextField newPositionField;

    private int width;

    public NewPositionPrompterPanel(FormattingData formattingData, NewPositionPrompterListener listener) {
        super();

        this.formattingData = formattingData;
        this.listener = listener;
        this.width = this.formattingData.getCardWidth() / 2;

        setPreferredSize(new Dimension(
                this.width,
                this.formattingData.getCardHeight()
                )
        );
        setBackground(this.formattingData.getMainBackground());
        setLayout(null);

        addNewPositionLabel();
        addNewPositionField();
        addSubmitButton();
    }

    private void addNewPositionLabel() {

        JLabel label = new JLabel();

        label.setText("New Position: ");
        label.setFont(new Font(
                "Arial Rounded MT Bold", Font.PLAIN, this.formattingData.getBigFont())
        );
        label.setForeground(this.formattingData.getTextColor());

        label.setBounds(this.formattingData.getSmallGap(), this.formattingData.getSmallGap(),
                this.formattingData.getCardWidth() - 2 * this.formattingData.getSmallGap(),
                this.formattingData.getHeaderHeight() - 2 * this.formattingData.getSmallGap());
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.LEFT);

        add(label);
    }

    private void addNewPositionField() {
        JTextField newPositionField = new JTextField();

        newPositionField.setBounds(
                this.formattingData.getSmallGap(),
                (this.formattingData.getHeaderHeight() / 2) + this.formattingData.getSmallGap(),
                this.width - 2 * this.formattingData.getSmallGap(),
                this.formattingData.getHeaderHeight() / 2
        );
        newPositionField.setBackground(this.formattingData.getCardBackground());
        newPositionField.setForeground(this.formattingData.getTextColor());
        newPositionField.setFont(new Font(
                "Arial Rounded MT Bold", Font.PLAIN, this.formattingData.getSmallFont()));

        newPositionField.setCaretColor(this.formattingData.getTextColor());
        newPositionField.setBorder(null);
        newPositionField.setBorder(BorderFactory.createCompoundBorder(
                newPositionField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));


        this.newPositionField = newPositionField;

        add(this.newPositionField);
    }

    private void addSubmitButton() {
        SquareButton submitButton = new SquareButton(this.formattingData, "↕", null) {
            @Override
            public void mousePressed(MouseEvent e) {
                listener.changePositionTo(newPositionField.getText());
            }
        };

        submitButton.setBounds(
                this.width - this.formattingData.getBorderedButtonWidth(),
                this.formattingData.getCardHeight() - this.formattingData.getBorderedButtonWidth(),
                this.formattingData.getSquareButtonSize(),
                this.formattingData.getSquareButtonSize());

        add(submitButton);

    }

}
