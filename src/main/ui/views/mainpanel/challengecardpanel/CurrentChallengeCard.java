package ui.views.mainpanel.challengecardpanel;

import ui.fomattingdata.FormattingData;
import ui.views.CheckListener;
import ui.views.mainpanel.MainPanel;

import javax.swing.*;
import java.awt.*;

// represents a card displaying current challenge
public class CurrentChallengeCard extends JPanel implements CheckListener {
    FormattingData formattingData;
    String name;
    String description;
    boolean isChecked;
    MainPanel mainPanel;

    JPanel cardPanel;

    // EFFECTS: constructs a new card with given formatting data, reference to main panel,
    //          given name, given description, and given checked state
    public CurrentChallengeCard(
            FormattingData formattingData,
            MainPanel mainPanel,
            String name,
            String description,
            boolean isChecked
    ) {
        super();

        this.formattingData = formattingData;
        this.name = name;
        this.description = description;
        this.isChecked = isChecked;
        this.mainPanel = mainPanel;

        setPreferredSize(new Dimension(
                this.formattingData.getMainPanelWidth(),
                this.formattingData.getChallengeCardPanelHeight()
        ));
        setBackground(this.formattingData.getMainBackground());
        setLayout(null);

        addCardPanel();

    }

    // MODIFIES: this
    // EFFECTS: adds a card panel at the proper position
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

    // MODIFIES: panel
    // EFFECTS: sets up the given panel to be a card panel
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
                this.name,
                this.isChecked), BorderLayout.NORTH);
        panel.add(createDescriptionPanel(), BorderLayout.SOUTH);
    }

    // MODIFIES: this
    // EFFECTS: adds a description panel at the proper position
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

    // MODIFIES: this
    // EFFECTS: requests main panel to add challenge of given name and description
    public void requestAddChallenge(String name, String description) {
        this.mainPanel.requestAddChallenge(name, description);
    }

    // MODIFIES: this
    // EFFECTS: requests main panel to edit current challenge into a challenge with given new name
    //          and new description.
    public void requestEditChallenge(String newName, String newDesc) {
        this.mainPanel.requestEditChallenge(newName, newDesc);
    }

    // MODIFIES: this
    // EFFECTS: requests main panel to exit current challenge
    public void requestExitCurrentChallenge() {
        this.mainPanel.requestExitCurrentChallenge();
    }

    // MODIFIES: this
    // EFFECTS: requests main panel to toggle the checked state of current challenge
    @Override
    public void toggleCheck(int index) {
        this.mainPanel.toggleCheckCurrentChallenge();
    }
}
