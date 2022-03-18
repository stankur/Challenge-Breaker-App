package ui.views.mainpanel.challengecardpanel;

import ui.fomattingdata.FormattingData;
import ui.views.reusables.SquareButton;

public class ExitButton extends SquareButton {
    private CurrentChallengeHeader header;

    public ExitButton(FormattingData formattingData, CurrentChallengeHeader header) {
        super(formattingData, "←");
        this.header = header;
    }
}
