package ui.views.mainpanel.challengecardpanel;

import ui.fomattingdata.FormattingData;
import ui.views.reusables.SquareButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class NameAndDescPrompterPanel extends JPanel {
    private FormattingData formattingData;
    private String addSymbol;
    private NameAndDescPrompterListener listener;
    private JTextField nameTextField;
    private JTextArea descriptionTextField;

    public NameAndDescPrompterPanel(FormattingData formattingData,
                                    NameAndDescPrompterListener listener, String addSymbol) {
        super();

        this.formattingData = formattingData;
        this.listener = listener;
        this.addSymbol = addSymbol;

        setPreferredSize(new Dimension(
                this.formattingData.getCardWidth(),
                this.formattingData.getCardHeight()
                )
        );
        setBackground(this.formattingData.getMainBackground());
        setLayout(null);

        addNameLabel();
        addNameTextField();

        addDescriptionLabel();
        addDescriptionField();

        addAddButton();
    }

    private JLabel createLabel(String title, int positionX, int positionY, int width, int height) {
        JLabel label = new JLabel();

        label.setText(title);
        label.setFont(new Font(
                "Arial Rounded MT Bold", Font.PLAIN, this.formattingData.getBigFont())
        );
        label.setForeground(this.formattingData.getTextColor());

        label.setBounds(positionX, positionY,
                width,
                height);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.LEFT);

        return label;

    }

    private void addNameLabel() {
        JLabel nameLabel = createLabel(
                "Challenge Name:",
                this.formattingData.getSmallGap(), this.formattingData.getSmallGap(),
                this.formattingData.getCardWidth() - 2 * this.formattingData.getSmallGap(),
                this.formattingData.getHeaderHeight() - 2 * this.formattingData.getSmallGap());

        add(nameLabel);
    }

    private void addNameTextField() {
        JTextField nameTextField = new JTextField();

        nameTextField.setBounds(
                this.formattingData.getSmallGap(),
                (this.formattingData.getHeaderHeight() / 2) + this.formattingData.getSmallGap(),
                this.formattingData.getCardWidth() - 2 * this.formattingData.getSmallGap(),
                this.formattingData.getHeaderHeight() / 2
        );
        nameTextField.setBackground(this.formattingData.getCardBackground());
        nameTextField.setForeground(this.formattingData.getTextColor());
        nameTextField.setFont(new Font(
                "Arial Rounded MT Bold", Font.PLAIN, this.formattingData.getSmallFont()));

        nameTextField.setCaretColor(this.formattingData.getTextColor());
        nameTextField.setBorder(null);
        nameTextField.setBorder(BorderFactory.createCompoundBorder(
                nameTextField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));


        this.nameTextField = nameTextField;

        add(this.nameTextField);
    }

    private void addDescriptionLabel() {
        JLabel descriptionLabel = createLabel("Challenge Description:",
                this.formattingData.getSmallGap(), this.formattingData.getHeaderHeight()
                        + 2 * this.formattingData.getSmallGap(),
                this.formattingData.getCardWidth() - 2 * this.formattingData.getSmallGap(),
                this.formattingData.getHeaderHeight() - 2 * this.formattingData.getSmallGap());

        add(descriptionLabel);

    }

    private void addDescriptionField() {
        JTextArea descriptionField = new JTextArea();

        descriptionField.setBounds(
                this.formattingData.getSmallGap(),
                2 * this.formattingData.getHeaderHeight() - this.formattingData.getSmallGap(),
                this.formattingData.getCardWidth() - 2 * this.formattingData.getSmallGap(),
                this.formattingData.getHeaderHeight() - 2 * this.formattingData.getSmallGap());

        descriptionField.setBackground(this.formattingData.getCardBackground());
        descriptionField.setForeground(this.formattingData.getTextColor());
        descriptionField.setFont(new Font(
                "Arial Rounded MT Bold", Font.PLAIN, this.formattingData.getSmallFont()));

        descriptionField.setCaretColor(this.formattingData.getTextColor());
        descriptionField.setBorder(null);
        descriptionField.setBorder(BorderFactory.createCompoundBorder(
                descriptionField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        descriptionField.setWrapStyleWord(true);
        descriptionField.setLineWrap(true);

        this.descriptionTextField = descriptionField;

        add(this.descriptionTextField);
    }

    private void addAddButton() {
        SquareButton addButton = new SquareButton(this.formattingData, this.addSymbol, null) {
            @Override
            public void mousePressed(MouseEvent e) {
                listener.setNameAndDesc(nameTextField.getText(), descriptionTextField.getText());
            }
        };

        addButton.setBounds(
                this.formattingData.getCardWidth() - this.formattingData.getBorderedButtonWidth(),
                this.formattingData.getCardHeight() - this.formattingData.getBorderedButtonWidth(),
                this.formattingData.getSquareButtonSize(),
                this.formattingData.getSquareButtonSize());

        add(addButton);
    }
}
