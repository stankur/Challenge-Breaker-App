package ui.fomattingdata;

public class Constants {
    private int appHeight;
    private int appWidth;

    private int sidePanelWidth;
    private int mainPanelWidth;

    private int barHeight;

    private int smallGap;
    private int mediumGap;

    private int squareButtonSize;

    private int smallFont;
    private int bigFont;
    private int biggerFont;

    public Constants() {
        this.appHeight = 575;
        this.appWidth = 750;

        this.sidePanelWidth = 250;
        this.mainPanelWidth = this.appWidth - this.sidePanelWidth;

        this.barHeight = 25;

        this.smallGap = 10;
        this.mediumGap = 20;

        this.squareButtonSize = 40;

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
        return this.mainPanelWidth;
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
}
