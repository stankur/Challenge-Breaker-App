package ui.views.mainpanel.minichallengesarea.minichallengespanel;

import ui.fomattingdata.FormattingData;
import ui.views.reusables.SquareButton;

import java.awt.event.MouseEvent;

public class StepIntoButton extends SquareButton {
    private MiniChallengeHeader miniChallengeHeader;

    public StepIntoButton(FormattingData formattingData, MiniChallengeHeader miniChallengeHeader) {
        super(formattingData, "→");
        this.miniChallengeHeader = miniChallengeHeader;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
