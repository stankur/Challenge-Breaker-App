package ui.views.mainpanel.challengecardpanel.buttons;

import ui.fomattingdata.FormattingData;
import ui.views.mainpanel.challengecardpanel.CurrentChallengeHeader;
import ui.views.mainpanel.challengecardpanel.NameAndDescPrompter;
import ui.views.mainpanel.challengecardpanel.NameAndDescPrompterListener;
import ui.views.reusables.SquareButton;

import java.awt.event.MouseEvent;
import java.util.Objects;

// Represents an edit button
public class EditButton extends SquareButton implements NameAndDescPrompterListener {
    private CurrentChallengeHeader header;
    private FormattingData formattingData;
    private NameAndDescPrompter prompter;

    // EFFECTS: constructs an edit button with given formatting data and header
    public EditButton(FormattingData formattingData, CurrentChallengeHeader header) {
        super(formattingData,"✎", null);
        this.formattingData = formattingData;
        this.header = header;
        this.prompter = null;
    }

    // EFFECTS: prompts for new name and description and requests this.header to
    //          edit current challenge to user's given new name and new description
    @Override
    public void mousePressed(MouseEvent e) {
        if (Objects.isNull(this.prompter)) {
            this.prompter = new NameAndDescPrompter(
                    this.formattingData,
                    this,
                    "Edit Current Challenge", "✎");
        }
    }

    @Override
    public void setNameAndDesc(String name, String desc) {
        this.header.requestEditCurrentChallenge(name, desc);
        this.prompter.dispose();
        this.prompter = null;
    }
}
