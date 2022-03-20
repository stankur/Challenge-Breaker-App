package ui.views.mainpanel.minichallengesarea.minichallengespanel;

import ui.fomattingdata.FormattingData;
import ui.views.reusables.HeaderBar;

public class MiniChallengeHeader extends HeaderBar {
    private MiniChallenges miniChallenges;
    int index;

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

    public void requestRemoveChallenge() {
        this.miniChallenges.requestRemoveChallenge(this.index);
    }

    public void requestMoveTo(int newIndex) {
        this.miniChallenges.requestRearrange(this.index, newIndex);
    }

    public void requestStepIntoMiniChallenge() {
        this.miniChallenges.requestStepInto(this.index);
    }
}
