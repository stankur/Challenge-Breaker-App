package ui.views.mainpanel.minichallengesarea.minichallengespanel;

import ui.fomattingdata.FormattingData;
import ui.views.reusables.SquareButton;

import java.awt.event.MouseEvent;

public class RearrangeButton extends SquareButton {
    private  MiniChallengeHeader miniChallengeHeader;

    public RearrangeButton(FormattingData formattingData, MiniChallengeHeader miniChallengeHeader) {
        super(formattingData, "↕");
        this.miniChallengeHeader = miniChallengeHeader;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
