package ui.views.mainpanel.challengecardpanel.buttons;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.challengecardpanel.CurrentChallengeHeader;
import ui.views.reusables.SquareButton;

import java.awt.event.MouseEvent;

public class ExitButton extends SquareButton {
    private CurrentChallengeHeader header;

    public ExitButton(FormattingData formattingData, CurrentChallengeHeader header) {
        super(formattingData, "←");
        this.header = header;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.header.requestExitCurrentChallenge();
    }
}
