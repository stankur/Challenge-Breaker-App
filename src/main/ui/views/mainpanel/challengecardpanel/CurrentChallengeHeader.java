package ui.views.mainpanel.challengecardpanel;

import ui.fomattingdata.FormattingData;
import ui.views.CheckListener;
import ui.views.mainpanel.challengecardpanel.buttons.AddButton;
import ui.views.mainpanel.challengecardpanel.buttons.EditButton;
import ui.views.mainpanel.challengecardpanel.buttons.ExitButton;
import ui.views.reusables.HeaderBar;
import ui.views.reusables.SquareButton;

public class CurrentChallengeHeader extends HeaderBar implements CheckListener {
    private FormattingData formattingData;
    private CurrentChallengeCard card;

    public CurrentChallengeHeader(FormattingData formattingData,
                                  CurrentChallengeCard card,
                                  String challengeName,
                                  boolean isChecked) {
        super(formattingData, challengeName, card, -1, isChecked);

        this.formattingData = formattingData;
        this.card = card;

        SquareButton add = new AddButton(this.formattingData, this);
        add.setLocation(this.formattingData.getButtonLocation(1),
                this.formattingData.getSmallGap());

        SquareButton exit = new ExitButton(this.formattingData, this);
        exit.setLocation(this.formattingData.getButtonLocation(3),
                this.formattingData.getSmallGap());

        SquareButton edit = new EditButton(this.formattingData, this);
        edit.setLocation(this.formattingData.getButtonLocation(2),
                this.formattingData.getSmallGap());

        add(add);
        add(exit);
        add(edit);
    }

    public void requestAddChallenge(String name, String description) {
        this.card.requestAddChallenge(name, description);
    }

    public void requestEditCurrentChallenge(String newName, String newDescription) {
        this.card.requestEditChallenge(newName, newDescription);
    }

    public void requestExitCurrentChallenge() {
        this.card.requestExitCurrentChallenge();
    }

    @Override
    public void toggleCheck(int index) {
        this.card.toggleCheck(-1);
    }

}
