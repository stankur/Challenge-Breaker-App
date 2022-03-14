package ui.views.mainpanel;

import ui.fomattingdata.FormattingData;
import ui.views.reusables.SquareButton;

import javax.swing.*;
import java.awt.*;

public class CurrentChallengeCard extends JPanel {
    FormattingData formattingData;
    String name;
    String description;
    MainPanel mainPanel;

    public CurrentChallengeCard(FormattingData formattingData, String name, String description, MainPanel mainPanel) {
        super();

        this.formattingData = formattingData;
        this.name = name;
        this.description = description;
        this.mainPanel = mainPanel;

        setPreferredSize(new Dimension(500, 235));
        setBackground(this.formattingData.getMainBackground());
        setLayout(null);

        JPanel panel = createCardPanel();
        panel.setLocation(10,10);
        add(panel);

    }

    private JPanel createCardPanel() {
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(480,215));
        panel.setBackground(this.formattingData.getCardBackground());
        panel.setLayout(new BorderLayout());

        panel.add(createHeader(), BorderLayout.NORTH);
        panel.add(createDescriptionPanel(), BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setPreferredSize(new Dimension(480,60));
        header.setBackground(this.formattingData.getCardBackground());
        header.setLayout(null);

        SquareButton checkBox = createCheckBox();
        checkBox.setLocation(10, 10);

        SquareButton add = createAddButton();
        add.setLocation(430,10);

        SquareButton exit = createExitButton();
        exit.setLocation(380,10);

        header.add(checkBox);
        header.add(add);
        header.add(exit);
        header.add(createNameLabel());

        return header;
    }

    private JLabel createNameLabel() {
        JLabel challengeName = new JLabel();
        challengeName.setText(this.name);
        challengeName.setBounds(60,10,310, 40);
        challengeName.setForeground(this.formattingData.getTextColor());
        challengeName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
        challengeName.setHorizontalAlignment(JLabel.LEFT);
        challengeName.setVerticalAlignment(JLabel.CENTER);

        return challengeName;
    }

    private JPanel createDescriptionPanel() {
        JPanel descriptionPanel = new JPanel();

        descriptionPanel.setPreferredSize(new Dimension(480, 165));
        descriptionPanel.setBackground(this.formattingData.getCardBackground());

        JTextArea descriptionLabel = new JTextArea();
        descriptionLabel.setBounds(10,10,460,145);
        descriptionLabel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        descriptionLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
        descriptionLabel.setText(this.description);
        descriptionLabel.setForeground(this.formattingData.getTextColor());
        descriptionLabel.setEditable(false);
        descriptionLabel.setCursor(null);
        descriptionLabel.setOpaque(false);
        descriptionLabel.setWrapStyleWord(true);
        descriptionLabel.setLineWrap(true);
        descriptionPanel.add(descriptionLabel);

        return descriptionPanel;
    }

    private SquareButton createCheckBox() {
        return new SquareButton(this.formattingData, " ");
    }

    private SquareButton createAddButton() {
        return new SquareButton(this.formattingData, "+");
    }

    private SquareButton createExitButton() {
        return new SquareButton(this.formattingData, "<");
    }

}
