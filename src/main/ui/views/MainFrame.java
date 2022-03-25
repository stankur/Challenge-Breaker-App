package ui.views;

import model.Challenge;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.LayerNavigator;
import ui.fomattingdata.*;
import ui.views.helpers.Updater;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFrame extends JFrame {
    private static final String STORAGE = "./data/storage.json";

    private FormattingData formattingData;

    private Challenge mainChallenge;
    private LayerNavigator layerNavigator;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private FramePanel framePanel;


    public MainFrame() {
        super("Challenge Breaker");

        setFormattingData(new FormattingData(new RobinTheme(),new Constants()));
        setMainChallenge(new Challenge(
                "template challenge",
                "template description"
        ));

        this.jsonWriter = new JsonWriter(STORAGE);
        this.jsonReader = new JsonReader(STORAGE);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        addFramePanel();
        pack();
        setVisible(true);
    }

    private void setFormattingData(FormattingData formattingData) {
        this.formattingData = formattingData;

    }

    private void setMainChallenge(Challenge mainChallenge) {
        this.mainChallenge = mainChallenge;
        this.layerNavigator = new LayerNavigator(this.mainChallenge);

    }

    public void addFramePanel() {
        this.framePanel = new FramePanel(this.formattingData, this, this.layerNavigator,
                this.mainChallenge);

        add(this.framePanel);
    }

    public void requestSave() {
        try {
            jsonWriter.open();
            jsonWriter.write(this.mainChallenge);
            jsonWriter.close();
            System.out.println("Saved challenge to " + STORAGE);
        } catch (FileNotFoundException e) {
            System.out.println(STORAGE + " not found");
        }
    }

    public void requestLoad() {
        try {
            this.mainChallenge = jsonReader.read();
            setMainChallenge(this.mainChallenge);
        } catch (IOException e) {
            System.out.println(STORAGE + " not found");
        }

        remove(this.framePanel);
        addFramePanel();

        new Updater(this.framePanel);
    }
    public void requestChangeTheme(Theme newTheme) {
        this.formattingData.changeTheme(newTheme);

        remove(this.framePanel);
        addFramePanel();

        new Updater(this.framePanel);
    }
}
