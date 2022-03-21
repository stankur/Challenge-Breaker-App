package ui.views.mainpanel.challengecardpanel.buttons;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.challengecardpanel.CurrentChallengeHeader;
import ui.views.reusables.SquareButton;

import java.awt.event.MouseEvent;
import java.util.Scanner;

public class EditButton extends SquareButton {
    private CurrentChallengeHeader header;

    public EditButton(FormattingData formattingData, CurrentChallengeHeader header) {
        super(formattingData,"✎");
        this.header = header;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Scanner input = new Scanner(System.in);
        System.out.println("what da new name boi?");

        String newName = input.nextLine();

        System.out.println("what da new desc?");

        String newDesc = input.nextLine();

        this.header.requestEditCurrentChallenge(newName, newDesc);
    }
}
