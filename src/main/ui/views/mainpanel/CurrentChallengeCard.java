package ui.views.mainpanel;

import ui.fomattingdata.FormattingData;
import ui.views.reusables.HeaderBar;
import ui.views.reusables.SquareButton;

import javax.swing.*;
import java.awt.*;

public class CurrentChallengeCard extends JPanel {
    FormattingData formattingData;
    String name;
    String description;
    MainPanel mainPanel;

    int rawHeight;

    int cardWidth;
    int cardHeight;

    int headerHeight;


    public CurrentChallengeCard(
            FormattingData formattingData,
                                int height,
                                String name,
                                String description,
                                MainPanel mainPanel
    ) {
        super();

        this.formattingData = formattingData;
        this.name = name;
        this.description = description;
        this.mainPanel = mainPanel;
        this.rawHeight = height;

        setPreferredSize(new Dimension(
                this.formattingData.getMainPanelWidth(),
                height
        ));
        setBackground(this.formattingData.getMainBackground());
        setLayout(null);

        JPanel panel = createCardPanel();
        panel.setLocation(
                this.formattingData.getSmallGap(),
                this.formattingData.getSmallGap()
        );
        add(panel);

    }

    private JPanel createCardPanel() {
        this.cardWidth = this.formattingData.getMainPanelWidth()
                - 2 * (this.formattingData.getSmallGap());

        this.cardHeight = this.rawHeight
                - 2 * (this.formattingData.getSmallGap());

        JPanel panel = new JPanel();
        panel.setSize(new Dimension(
                this.cardWidth,
                this.cardHeight
        ));
        panel.setBackground(this.formattingData.getCardBackground());
        panel.setLayout(new BorderLayout());

        panel.add(createHeader(), BorderLayout.NORTH);
        panel.add(createDescriptionPanel(), BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createHeader() {
        this.headerHeight = this.formattingData.getSquareButtonSize()
                + 2 * this.formattingData.getSmallGap();
        int borderedButtonWidth = this.formattingData.getSmallGap() + this.formattingData.getSquareButtonSize();

        JPanel header = new HeaderBar(this.formattingData, this.name, this.cardWidth);

        SquareButton add = createAddButton();
        add.setLocation(this.cardWidth - borderedButtonWidth, this.formattingData.getSmallGap());

        SquareButton exit = createExitButton();
        exit.setLocation(this.cardWidth - 2 * borderedButtonWidth, this.formattingData.getSmallGap());

        header.add(add);
        header.add(exit);

        return header;
    }

    private JPanel createDescriptionPanel() {
        JPanel descriptionPanel = new JPanel();

        descriptionPanel.setPreferredSize(new Dimension(this.cardWidth, (this.cardHeight - this.headerHeight)));
        descriptionPanel.setBackground(this.formattingData.getCardBackground());

        JTextArea descriptionLabel = new JTextArea();
        descriptionLabel.setBounds(
                this.formattingData.getSmallGap(),
                this.formattingData.getSmallGap(),
                this.cardWidth - 2 * this.formattingData.getSmallGap(),
                this.cardHeight - 2 * this.formattingData.getSmallGap());
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

    private SquareButton createAddButton() {
        return new SquareButton(this.formattingData, "﹢");
    }

    private SquareButton createExitButton() {
        return new SquareButton(this.formattingData, "←");
    }

}
