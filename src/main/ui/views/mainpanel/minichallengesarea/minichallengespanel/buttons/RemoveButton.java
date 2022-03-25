package ui.views.mainpanel.minichallengesarea.minichallengespanel.buttons;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.minichallengesarea.minichallengespanel.MiniChallengeHeader;
import ui.views.reusables.SquareButton;

import java.awt.event.MouseEvent;

public class RemoveButton extends SquareButton {
    private MiniChallengeHeader miniChallengeHeader;

    public RemoveButton(FormattingData formattingData, MiniChallengeHeader miniChallengeHeader) {
        super(formattingData, "✕", null);
        this.miniChallengeHeader = miniChallengeHeader;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.miniChallengeHeader.requestRemoveChallenge();
    }
}
