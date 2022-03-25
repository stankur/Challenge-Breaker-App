package ui.fomattingdata;

// represents constants used in the ui
public class Constants {
    private int appHeight;
    private int appWidth;

    private int sidePanelWidth;

    private int barHeight;

    private int smallGap;
    private int mediumGap;

    private int squareButtonSize;

    private int smallFont;
    private int bigFont;
    private int biggerFont;

    private int challengeCardPanelHeight;
    private int miniElaboratedChallengesLabelHeight;

    // EFFECTS: constructs constants with font sizes, gap sized, and component sizes
    public Constants() {
        initializeFonts();
        initializeGaps();
        initializeSizes();
    }

    // MODIFIES: this
    // EFFECTS: assigns appropriate values to this' fields related to component sizes
    private void initializeSizes() {
        this.appHeight = 575;
        this.appWidth = 750;

        this.squareButtonSize = 40;

        this.sidePanelWidth = 250;

        this.barHeight = 25;

        this.challengeCardPanelHeight = 230;
        this.miniElaboratedChallengesLabelHeight = 30 + this.smallGap;

    }

    // MODIFIES: this
    // EFFECTS: assigns appropriate values to this' fields related to fap sizes
    private void initializeGaps() {
        this.smallGap = 10;
        this.mediumGap = 20;
    }

    // MODIFIES: this
    // EFFECTS: assigns appropriate values to this' fields related to font sizes
    private void initializeFonts() {
        this.smallFont = 13;
        this.bigFont = 18;
        this.biggerFont = 21;
    }
    
    // EFFECTS: returns app height
    public int getAppHeight() {
        return this.appHeight;
    }

    // EFFECTS: returns app width
    public int getAppWidth() {
        return this.appWidth;
    }

    // EFFECTS: returns side panel width
    public int getSidePanelWidth() {
        return this.sidePanelWidth;
    }

    // EFFECTS: return main panel width
    public int getMainPanelWidth() {
        return this.appWidth - this.sidePanelWidth;
    }

    // EFFECTS: returns bar height
    public int getBarHeight() {
        return this.barHeight;
    }

    // EFFECTS: returns small gap size
    public int getSmallGap() {
        return this.smallGap;
    }

    // EFFECTS: returns medium gap size
    public int getMediumGap() {
        return this.mediumGap;
    }

    // EFFECTS: returns size of length of square button
    public int getSquareButtonSize() {
        return this.squareButtonSize;
    }

    // EFFECTS: returns size of small font
    public int getSmallFont() {
        return this.smallFont;
    }

    // EFFECTS: returns size of big font
    public int getBigFont() {
        return this.bigFont;
    }

    // EFFECTS: returns size of bigger font
    public int getBiggerFont() {
        return this.biggerFont;
    }

    // EFFECTS: returns size of challenge card panel height
    public int getChallengeCardPanelHeight() {
        return this.challengeCardPanelHeight;
    }

    // EFFECTS: returns height of bottom panel
    public int getBottomPanelHeight() {
        return this.appHeight - this.barHeight - this.challengeCardPanelHeight;
    }

    // EFFECTS: returns height of "mini elaborated challenges" label
    public int getMiniElaboratedChallengesLabelHeight() {
        return this.miniElaboratedChallengesLabelHeight;
    }

    // EFFECTS: returns card width
    public int getCardWidth() {
        return this.appWidth - this.sidePanelWidth - 2 * this.smallGap;
    }

    // EFFECTS: returns card height
    public int getCardHeight() {
        return this.challengeCardPanelHeight - 2 * this.smallGap;
    }

    // EFFECTS: returns header height
    public int getHeaderHeight() {
        return this.squareButtonSize + 2 * this.smallGap;
    }

    // EFFECTS: returns bordered button width
    public int getBorderedButtonWidth() {
        return this.smallGap + this.squareButtonSize;
    }

    // EFFECTS: returns mini elaborated challenges pane height
    public int getMiniElaboratedChallengesPaneHeight() {
        return this.appHeight - this.barHeight
                - this.challengeCardPanelHeight
                - this.miniElaboratedChallengesLabelHeight;
    }

    // EFFECTS: returns x coordinate of top left corner of button at a specified index relative to other
    // buttons beginning with index 1 being on the rightmost corner
    public int getButtonLocation(int i) {
        return getCardWidth() - i * getBorderedButtonWidth();
    }

    // EFFECTS: returns mini challenges label width
    public int getMiniChallengesLabelWidth() {
        return this.getMainPanelWidth() - 2 * this.smallGap - 2 * this.mediumGap;
    }

}
