package ui.views.mainpanel.challengecardpanel;

import ui.fomattingdata.FormattingData;
import ui.views.reusables.HeaderBar;
import ui.views.reusables.SquareButton;

public class CurrentChallengeHeader extends HeaderBar {
    private FormattingData formattingData;
    private CurrentChallengeCard card;

    public CurrentChallengeHeader(FormattingData formattingData,
                                  CurrentChallengeCard card,
                                  String challengeName) {
        super(formattingData, challengeName);

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

}
