package ui.views.mainpanel.minichallengesarea.minichallengespanel;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.minichallengesarea.minichallengespanel.buttons.rearrangebutton.RearrangeButton;
import ui.views.mainpanel.minichallengesarea.minichallengespanel.buttons.RemoveButton;
import ui.views.mainpanel.minichallengesarea.minichallengespanel.buttons.StepIntoButton;
import ui.views.reusables.HeaderBar;

// represents a mini challenge header bar
public class MiniChallengeHeader extends HeaderBar {
    private MiniChallenges miniChallenges;
    int index;

    // EFFECTS: constructs a mini challenge header with given formatting data and mini challenges
    public MiniChallengeHeader(FormattingData formattingData, MiniChallenges miniChallenges,
                                String challengeName, int index, boolean isChecked) {
        super(formattingData, challengeName, miniChallenges, index, isChecked);

        this.miniChallenges = miniChallenges;
        this.index = index;

        RemoveButton removeButton = new RemoveButton(formattingData, this);
        RearrangeButton rearrangeButton = new RearrangeButton(formattingData, this);
        StepIntoButton stepIntoButton = new StepIntoButton(formattingData, this);

        removeButton.setLocation(formattingData.getButtonLocation(1), formattingData.getSmallGap());
        rearrangeButton.setLocation(formattingData.getButtonLocation(2), formattingData.getSmallGap());
        stepIntoButton.setLocation(formattingData.getButtonLocation(3), formattingData.getSmallGap());

        add(removeButton);
        add(rearrangeButton);
        add(stepIntoButton);
    }

    // MODIFIES: this
    // EFFECTS: requests mini challenges to remove challenge of index this.index
    public void requestRemoveChallenge() {
        this.miniChallenges.requestRemoveChallenge(this.index);
    }

    // MODIFIES: this
    // EFFECTS: requests mini challenges to rearrange mini challenge of index this.index to newIndex
    public void requestMoveTo(int newIndex) {
        this.miniChallenges.requestRearrange(this.index, newIndex);
    }

    // MODIFIES: this
    // EFFECTS: requests mini challenges to step into challenge with index of this.index
    public void requestStepIntoMiniChallenge() {
        this.miniChallenges.requestStepInto(this.index);
    }
}
