package ui.views.mainpanel.minichallengesarea.minichallengespanel.buttons;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.minichallengesarea.minichallengespanel.MiniChallengeHeader;
import ui.views.reusables.SquareButton;

import java.awt.event.MouseEvent;

// represents a step into button
public class StepIntoButton extends SquareButton {
    private MiniChallengeHeader miniChallengeHeader;

    // EFFECTS: constructs a step into button with given formatting data and reference to given mini challenge header
    public StepIntoButton(FormattingData formattingData, MiniChallengeHeader miniChallengeHeader) {
        super(formattingData, "→", null);
        this.miniChallengeHeader = miniChallengeHeader;
    }

    // MODIFIES: this
    // EFFECTS: requests mini challenge header to step into its mini challenge
    @Override
    public void mousePressed(MouseEvent e) {
        this.miniChallengeHeader.requestStepIntoMiniChallenge();
    }
}
