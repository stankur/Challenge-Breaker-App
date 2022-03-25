package ui.views.mainpanel.challengecardpanel;

import ui.fomattingdata.FormattingData;

import javax.swing.*;

public class NameAndDescPrompter extends JFrame {
    private FormattingData formattingData;
    private NameAndDescPrompterListener listener;
    private NameAndDescPrompterPanel panel;
    private String addSymbol;

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

    private void addPanel() {
        this.panel = new NameAndDescPrompterPanel(this.formattingData, this.listener, this.addSymbol);
        add(this.panel);
    }



}
