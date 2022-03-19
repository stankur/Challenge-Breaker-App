package ui.views.mainpanel.minichallengesarea.minichallengespanel;

import ui.fomattingdata.FormattingData;
import ui.views.reusables.SquareButton;

import java.awt.event.MouseEvent;
import java.util.Scanner;

public class RearrangeButton extends SquareButton {
    private  MiniChallengeHeader miniChallengeHeader;

    public RearrangeButton(FormattingData formattingData, MiniChallengeHeader miniChallengeHeader) {
        super(formattingData, "↕");
        this.miniChallengeHeader = miniChallengeHeader;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Scanner input = new Scanner(System.in);

        System.out.println("new position?");

        int newPosition = 0;

        boolean promptValidInput = true;

        while (promptValidInput) {
            try {
                newPosition = Integer.parseInt(input.nextLine());
                promptValidInput = false;
            } catch (NumberFormatException error) {
                System.out.println("not valid input");
            }
        }

        int newIndex = newPosition - 1;

        this.miniChallengeHeader.requestMoveTo(newIndex);
    }
}
