package ui.views.mainpanel.challengecardpanel.buttons;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.challengecardpanel.CurrentChallengeHeader;
import ui.views.reusables.SquareButton;

import java.awt.event.MouseEvent;
import java.util.Scanner;

public class AddButton extends SquareButton {
    private CurrentChallengeHeader header;

    public AddButton(FormattingData formattingData, CurrentChallengeHeader header) {
        super(formattingData, "+");
        this.header = header;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Scanner input = new Scanner(System.in);
        System.out.println("wut challenge name u wan mate?");
        String name = input.nextLine();
        System.out.println("wut description u wan mate?");
        String desc = input.nextLine();

        this.header.requestAddChallenge(name, desc);
    }

}
