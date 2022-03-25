package ui.views.mainpanel.challengecardpanel.buttons;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.challengecardpanel.CurrentChallengeHeader;
import ui.views.reusables.SquareButton;

import java.awt.event.MouseEvent;

// represents an exit button
public class ExitButton extends SquareButton {
    private CurrentChallengeHeader header;

    // EFFECTS: constructs an exit button with given formatting data and header
    public ExitButton(FormattingData formattingData, CurrentChallengeHeader header) {
        super(formattingData, "←", null);
        this.header = header;
    }

    // MODIFIES: this
    // EFFECTS: requests header
    @Override
    public void mousePressed(MouseEvent e) {
        this.header.requestExitCurrentChallenge();
    }
}
