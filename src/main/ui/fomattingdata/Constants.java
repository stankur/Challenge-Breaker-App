package ui.fomattingdata;

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

    public Constants() {
        initializeFonts();
        initializeGaps();
        initializeSizes();
    }

    private void initializeSizes() {
        this.appHeight = 575;
        this.appWidth = 750;

        this.squareButtonSize = 40;

        this.sidePanelWidth = 250;

        this.barHeight = 25;

        this.challengeCardPanelHeight = 230;
        this.miniElaboratedChallengesLabelHeight = 30 + this.smallGap;

    }

    private void initializeGaps() {
        this.smallGap = 10;
        this.mediumGap = 20;
    }

    private void initializeFonts() {
        this.smallFont = 13;
        this.bigFont = 18;
        this.biggerFont = 21;
    }



    public int getAppHeight() {
        return this.appHeight;
    }

    public int getAppWidth() {
        return this.appWidth;
    }

    public int getSidePanelWidth() {
        return this.sidePanelWidth;
    }

    public int getMainPanelWidth() {
        return this.appWidth - this.sidePanelWidth;
    }

    public int getBarHeight() {
        return this.barHeight;
    }

    public int getSmallGap() {
        return this.smallGap;
    }

    public int getMediumGap() {
        return this.mediumGap;
    }

    public int getSquareButtonSize() {
        return this.squareButtonSize;
    }

    public int getSmallFont() {
        return this.smallFont;
    }

    public int getBigFont() {
        return this.bigFont;
    }

    public int getBiggerFont() {
        return this.biggerFont;
    }

    public int getChallengeCardPanelHeight() {
        return this.challengeCardPanelHeight;
    }

    public int getBottomPanelHeight() {
        return this.appHeight - this.barHeight - this.challengeCardPanelHeight;
    }

    public int getMiniElaboratedChallengesLabelHeight() {
        return this.miniElaboratedChallengesLabelHeight;
    }

    public int getCardWidth() {
        return this.appWidth - this.sidePanelWidth - 2 * this.smallGap;
    }

    public int getCardHeight() {
        return this.challengeCardPanelHeight - 2 * this.smallGap;
    }

    public int getHeaderHeight() {
        return this.squareButtonSize + 2 * this.smallGap;
    }

    public int getBorderedButtonWidth() {
        return this.smallGap + this.squareButtonSize;
    }

    public int getMiniElaboratedChallengesPaneHeight() {
        return this.appHeight - this.barHeight
                - this.challengeCardPanelHeight
                - this.miniElaboratedChallengesLabelHeight;
    }

    public int getButtonLocation(int i) {
        return getCardWidth() - i * getBorderedButtonWidth();
    }

    public int getMiniChallengesLabelWidth() {
        return this.getMainPanelWidth() - 2 * this.smallGap - 2 * this.mediumGap;
    }

}
