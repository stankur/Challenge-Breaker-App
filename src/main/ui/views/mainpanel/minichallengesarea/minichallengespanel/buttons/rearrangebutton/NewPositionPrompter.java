package ui.views.mainpanel.minichallengesarea.minichallengespanel.buttons.rearrangebutton;

import ui.fomattingdata.FormattingData;

import javax.swing.*;

public class NewPositionPrompter extends JFrame {
    private FormattingData formattingData;
    private NewPositionPrompterListener listener;

    public NewPositionPrompter(FormattingData formattingData, NewPositionPrompterListener listener) {
        super("Change Position");

        this.formattingData = formattingData;
        this.listener = listener;

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        addPanel();
        pack();
        setVisible(true);
    }

    private void addPanel() {
        add(new NewPositionPrompterPanel(this.formattingData, this.listener));
    }
}
