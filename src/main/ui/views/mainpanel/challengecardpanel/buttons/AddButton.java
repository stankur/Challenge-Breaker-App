package ui.views.mainpanel.challengecardpanel.buttons;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.challengecardpanel.CurrentChallengeHeader;
import ui.views.mainpanel.challengecardpanel.NameAndDescPrompter;
import ui.views.mainpanel.challengecardpanel.NameAndDescPrompterListener;
import ui.views.reusables.SquareButton;

import java.awt.event.MouseEvent;
import java.util.Objects;

// Represents an add button
public class AddButton extends SquareButton implements NameAndDescPrompterListener {
    private FormattingData formattingData;
    private CurrentChallengeHeader header;
    private NameAndDescPrompter prompter;

    // EFFECTS: constructs an add button with given formatting data and header
    public AddButton(FormattingData formattingData, CurrentChallengeHeader header) {
        super(formattingData, "+", null);
        this.formattingData = formattingData;
        this.header = header;
        this.prompter = null;
    }

    // MODIFIES: this
    // EFFECTS: prompts for new challenge information and
    //          requests header to add challenge
    @Override
    public void mousePressed(MouseEvent e) {
        if (Objects.isNull(this.prompter)) {
            this.prompter = new NameAndDescPrompter(
                    this.formattingData,
                    this,
                    "Add New Challenge", "+");
        }
    }

    @Override
    public void setNameAndDesc(String name, String desc) {
        this.header.requestAddChallenge(name, desc);
        this.prompter.dispose();
        this.prompter = null;
    }
}
