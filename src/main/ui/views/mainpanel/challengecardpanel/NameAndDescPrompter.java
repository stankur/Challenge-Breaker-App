package ui.views.mainpanel.challengecardpanel;

import ui.fomattingdata.FormattingData;

import javax.swing.*;

// represents the frame of a name and description prompter
public class NameAndDescPrompter extends JFrame {
    private FormattingData formattingData;
    private NameAndDescPrompterListener listener;
    private NameAndDescPrompterPanel panel;
    private String addSymbol;

    // EFFECTS: constructs a new name and description prompter with given formatting data,
    //          reference to listener, name of given type and symbol of given add symbol
    public NameAndDescPrompter(FormattingData formattingData, NameAndDescPrompterListener listener,
                               String type, String addSymbol) {
        super(type);

        this.formattingData = formattingData;
        this.listener = listener;
        this.addSymbol = addSymbol;

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        addPanel();
        pack();
        setVisible(true);

    }

    // MODIFIES: this
    // EFFECTS: adds name and description panel to this frame
    private void addPanel() {
        this.panel = new NameAndDescPrompterPanel(this.formattingData, this.listener, this.addSymbol);
        add(this.panel);
    }



}
