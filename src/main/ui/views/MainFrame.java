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

// represents main frame of challenge breaker app
public class MainFrame extends JFrame {
    private static final String STORAGE = "./data/storage.json";

    private FormattingData formattingData;

    private Challenge mainChallenge;
    private LayerNavigator layerNavigator;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private FramePanel framePanel;

    // EFFECTS: constructs a new main frame with formatting data with theme batman, and
    //          shows a template challenge with name "template challenge" and description
    //          "template description"
    public MainFrame() {
        super("Challenge Breaker");

        setFormattingData(new FormattingData(new BatmanTheme(),new Constants()));
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

    // MODIFIES: this
    // EFFECTS: sets formatting data into given formatting data
    private void setFormattingData(FormattingData formattingData) {
        this.formattingData = formattingData;

    }

    // MODIFIES: this
    // EFFECTS: sets main challenge to given challenge
    private void setMainChallenge(Challenge mainChallenge) {
        this.mainChallenge = mainChallenge;
        this.layerNavigator = new LayerNavigator(this.mainChallenge);

    }

    // MODIFIES: this
    // EFFECTS: adds frame panel to this frame
    public void addFramePanel() {
        this.framePanel = new FramePanel(this.formattingData, this, this.layerNavigator,
                this.mainChallenge);

        add(this.framePanel);
    }

    // MODIFIES: this
    // EFFECTS: tries to save main challenge. If file not found, prints "not found"
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

    // MODIFIES: this
    // EFFECTS: reads previous main challenge and re-renders frame panel to have read main challenge as its
    //          main challenge. If file not found, prints location not found
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

    // MODIFIES: this
    // EFFECTS: changes formatting data's theme into given newTheme and re-renders frame panel
    public void requestChangeTheme(Theme newTheme) {
        this.formattingData.changeTheme(newTheme);

        remove(this.framePanel);
        addFramePanel();

        new Updater(this.framePanel);
    }
}
