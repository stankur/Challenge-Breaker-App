package ui.views.mainpanel.minichallengesarea.minichallengespanel.buttons;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.minichallengesarea.minichallengespanel.MiniChallengeHeader;
import ui.views.reusables.SquareButton;

import java.awt.event.MouseEvent;

// represent a remove button
public class RemoveButton extends SquareButton {
    private MiniChallengeHeader miniChallengeHeader;

    // EFFECTS: constructs a remove button with given formatting data and reference to mini challenge header
    public RemoveButton(FormattingData formattingData, MiniChallengeHeader miniChallengeHeader) {
        super(formattingData, "✕", null);
        this.miniChallengeHeader = miniChallengeHeader;
    }

    // MODIFIES: this
    // EFFECTS: requests mini challenge header to remove challenge
    @Override
    public void mousePressed(MouseEvent e) {
        this.miniChallengeHeader.requestRemoveChallenge();
    }
}
