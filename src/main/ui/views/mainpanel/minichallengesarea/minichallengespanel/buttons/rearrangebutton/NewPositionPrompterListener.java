package ui.views.mainpanel.minichallengesarea.minichallengespanel.buttons.rearrangebutton;

// represents a new position prompter listener
public interface NewPositionPrompterListener {

    // EFFECTS: changes position to given index if applicable, otherwise does nothing
    void changePositionTo(String index);
}
