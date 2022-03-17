package ui;

import model.Challenge;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.fomattingdata.Constants;
import ui.fomattingdata.DarkTheme;
import ui.fomattingdata.FormattingData;
import ui.fomattingdata.Theme;
import ui.views.MainFrame;

import java.util.ArrayList;

public class ChallengeBreakerController {
    private static final String STORAGE = "./data/storage.json";

    private Challenge mainChallenge;
    private ArrayList<Challenge> visitedLayers;
    private Challenge currentChallenge;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private FormattingData formattingData;

    private MainFrame mainFrame;

    public ChallengeBreakerController() {
        this.mainChallenge = new Challenge(
                "template challenge",
                "template description"
        );
        this.visitedLayers = new ArrayList<>();
        this.currentChallenge = this.mainChallenge;

        this.jsonWriter = new JsonWriter(STORAGE);
        this.jsonReader = new JsonReader(STORAGE);

        this.formattingData = new FormattingData(new DarkTheme(), new Constants());

        this.mainFrame = new MainFrame(this.formattingData, this);
        this.mainFrame.setVisible(true);
    }

    public Challenge getMainChallenge() {
        return mainChallenge;
    }

    public ArrayList<Challenge> getVisitedLayers() {
        return this.visitedLayers;
    }

    public Challenge getCurrentChallenge() {
        return this.currentChallenge;
    }




}
