package ui.views.mainpanel.challengecardpanel;

import ui.fomattingdata.FormattingData;
import ui.views.CheckListener;
import ui.views.mainpanel.challengecardpanel.buttons.AddButton;
import ui.views.mainpanel.challengecardpanel.buttons.EditButton;
import ui.views.mainpanel.challengecardpanel.buttons.ExitButton;
import ui.views.reusables.HeaderBar;
import ui.views.reusables.SquareButton;

// represents a header bar of current challenge
public class CurrentChallengeHeader extends HeaderBar implements CheckListener {
    private FormattingData formattingData;
    private CurrentChallengeCard card;

    // EFFECTS: constructs a new current challenge header with given formatting data,
    //          reference to given card, given name and checked state and of index -1
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

    // MODIFIES: this
    // EFFECTS: requests card to add challenge with given name and description
    public void requestAddChallenge(String name, String description) {
        this.card.requestAddChallenge(name, description);
    }

    // MODIFIES: this
    // EFFECTS: requests card to edit current challenge to a challenge with given new name and given
    //          new description
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
