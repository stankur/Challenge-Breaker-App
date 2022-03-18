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
        add.setLocation(this.formattingData.getCardWidth() - this.formattingData.getBorderedButtonWidth(),
                this.formattingData.getSmallGap());

        SquareButton exit = new ExitButton(this.formattingData, this);
        exit.setLocation(this.formattingData.getCardWidth()
                        - 2 * this.formattingData.getBorderedButtonWidth(),
                this.formattingData.getSmallGap());

        add(add);
        add(exit);

    }
}
