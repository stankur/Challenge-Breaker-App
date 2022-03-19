package ui.views.mainpanel.minichallengesarea;

import ui.fomattingdata.FormattingData;

import javax.swing.*;
import java.awt.*;

public class MiniElaboratedChallengesLabel extends JPanel {
    private FormattingData formattingData;

    public MiniElaboratedChallengesLabel(FormattingData formattingData) {
        super();

        this.formattingData = formattingData;

        setLayout(null);
        setPreferredSize(new Dimension(
                this.formattingData.getMainPanelWidth(),
                this.formattingData.getMiniElaboratedChallengesLabelHeight()
        ));

        JLabel label = new JLabel();

        label.setText("Mini Elaborated Challenges");
        label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, this.formattingData.getBiggerFont()));
        label.setBounds(
                this.formattingData.getMediumGap(),
                0,
                this.formattingData.getMiniChallengesLabelWidth(),
                30
        );

        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(this.formattingData.getTextColor());

        setBackground(this.formattingData.getMainBackground());

        add(label);

    }
}
