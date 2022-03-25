package ui.views.mainpanel.minichallengesarea.minichallengespanel.buttons.rearrangebutton;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.minichallengesarea.minichallengespanel.MiniChallengeHeader;
import ui.views.reusables.SquareButton;

import java.awt.event.MouseEvent;
import java.util.Objects;
import java.util.Scanner;

public class RearrangeButton extends SquareButton implements NewPositionPrompterListener {
    private FormattingData formattingData;
    private MiniChallengeHeader miniChallengeHeader;
    private NewPositionPrompter prompter;

    public RearrangeButton(FormattingData formattingData, MiniChallengeHeader miniChallengeHeader) {
        super(formattingData, "↕", null);

        this.formattingData = formattingData;
        this.miniChallengeHeader = miniChallengeHeader;
        this.prompter = null;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (Objects.isNull(this.prompter)) {
            this.prompter = new NewPositionPrompter(this.formattingData, this);
        }
    }

    @Override
    public void changePositionTo(String index) {
        try {
            int newPosition = Integer.parseInt(index);

            int newIndex = newPosition - 1;

            this.miniChallengeHeader.requestMoveTo(newIndex);

        } catch (NumberFormatException error) {
            System.out.println("not valid input");
        }

        this.prompter.dispose();
        this.prompter = null;
    }
}
