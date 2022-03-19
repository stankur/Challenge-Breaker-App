package ui.views.mainpanel.challengecardpanel;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.MainPanel;

import javax.swing.*;
import java.awt.*;

public class CurrentChallengeCard extends JPanel {
    FormattingData formattingData;
    String name;
    String description;
    MainPanel mainPanel;

    JPanel cardPanel;

    public CurrentChallengeCard(
            FormattingData formattingData,
            MainPanel mainPanel,
            String name,
            String description
    ) {
        super();

        this.formattingData = formattingData;
        this.name = name;
        this.description = description;
        this.mainPanel = mainPanel;

        setPreferredSize(new Dimension(
                this.formattingData.getMainPanelWidth(),
                this.formattingData.getChallengeCardPanelHeight()
        ));
        setBackground(this.formattingData.getMainBackground());
        setLayout(null);

        addCardPanel();
    }

    private void addCardPanel() {
        JPanel panel = new JPanel();
        panel.setLocation(
                this.formattingData.getSmallGap(),
                this.formattingData.getSmallGap()
        );
        setupCardPanel(panel);

        this.cardPanel = panel;

        add(panel);

    }

    private void setupCardPanel(JPanel panel) {
        panel.setSize(new Dimension(
                this.formattingData.getCardWidth(),
                this.formattingData.getCardHeight()
        ));
        panel.setBackground(this.formattingData.getCardBackground());
        panel.setLayout(new BorderLayout());

        panel.add(new CurrentChallengeHeader(
                this.formattingData,
                this,
                this.name), BorderLayout.NORTH);
        panel.add(createDescriptionPanel(), BorderLayout.SOUTH);
    }

    private JPanel createDescriptionPanel() {
        JPanel descriptionPanel = new JPanel();

        descriptionPanel.setPreferredSize(new Dimension(this.formattingData.getCardWidth(),
                (this.formattingData.getCardHeight() - this.formattingData.getHeaderHeight())));
        descriptionPanel.setBackground(this.formattingData.getCardBackground());

        JTextArea descriptionLabel = new JTextArea();
        descriptionLabel.setBounds(
                this.formattingData.getSmallGap(),
                this.formattingData.getSmallGap(),
                this.formattingData.getCardWidth() - 2 * this.formattingData.getSmallGap(),
                this.formattingData.getCardHeight() - 2 * this.formattingData.getSmallGap());
        descriptionLabel.setBorder(BorderFactory.createEmptyBorder(
                this.formattingData.getSmallGap(), 0, 0, 0));
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

    public void requestAddChallenge(String name, String description) {
        this.mainPanel.requestAddChallenge(name, description);
    }

    public void requestEditChallenge(String newName, String newDesc) {
        this.mainPanel.requestEditChallenge(newName, newDesc);
    }
}
