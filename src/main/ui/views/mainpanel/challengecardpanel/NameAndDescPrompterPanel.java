package ui.views.mainpanel.challengecardpanel;

import ui.fomattingdata.FormattingData;
import ui.views.reusables.SquareButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

// represents a name and description prompter panel
public class NameAndDescPrompterPanel extends JPanel {
    private FormattingData formattingData;
    private String addSymbol;
    private NameAndDescPrompterListener listener;
    private JTextField nameTextField;
    private JTextArea descriptionTextField;

    // EFFECTS: constructs a name and description prompter panel with given formatting data,
    //          reference to given listener, and with given add symbol
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

    // EFFECTS: creates a label of given title with bounds at given x and y positions and of given
    //          width and height
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

    // MODIFIES: this
    // EFFECTS: adds label of "Challenge Name:" to panel
    private void addNameLabel() {
        JLabel nameLabel = createLabel(
                "Challenge Name:",
                this.formattingData.getSmallGap(), this.formattingData.getSmallGap(),
                this.formattingData.getCardWidth() - 2 * this.formattingData.getSmallGap(),
                this.formattingData.getHeaderHeight() - 2 * this.formattingData.getSmallGap());

        add(nameLabel);
    }

    // MODIFIES: this
    // EFFECTS: adds name text field to panel
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

    // MODIFIES: this
    // EFFECTS: adds a label of "Challenge Description:" at appropriate location
    private void addDescriptionLabel() {
        JLabel descriptionLabel = createLabel("Challenge Description:",
                this.formattingData.getSmallGap(), this.formattingData.getHeaderHeight()
                        + 2 * this.formattingData.getSmallGap(),
                this.formattingData.getCardWidth() - 2 * this.formattingData.getSmallGap(),
                this.formattingData.getHeaderHeight() - 2 * this.formattingData.getSmallGap());

        add(descriptionLabel);

    }

    // MODIFIES: this
    // EFFECTS: adds a description field to this panel
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

    // MODIFIES: this
    // EFFECTS: adds an add button with addSymbol to this panel at appropriate location
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
