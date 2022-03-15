package ui.views.mainpanel;

import ui.fomattingdata.FormattingData;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MiniElaboratedChallengesLabel extends JPanel {
    private FormattingData formattingData;

    public MiniElaboratedChallengesLabel(FormattingData formattingData, int height) {
        super();

        this.formattingData = formattingData;

        setLayout(null);
        setPreferredSize(new Dimension(
                this.formattingData.getMainPanelWidth(),
                height
        ));

        JLabel label = new JLabel();

        label.setText("Mini Elaborated Challenges");
        label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, this.formattingData.getBiggerFont()));
        label.setBounds(
                this.formattingData.getMediumGap(),
                0,
                this.formattingData.getMainPanelWidth()
                        - 2 * this.formattingData.getSmallGap()
                        - 2 * this.formattingData.getMediumGap(),
                30
        );

        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(this.formattingData.getTextColor());

        setBackground(this.formattingData.getMainBackground());

        add(label);

    }
}
