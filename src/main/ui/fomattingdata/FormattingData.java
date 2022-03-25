package ui.fomattingdata;

import java.awt.*;

// represents all formatting data for the ui consisting of theme and constants
public class FormattingData {
    Theme theme;
    Constants constants;

    // EFFECTS: constructs formatting data with given constants and theme
    public FormattingData(Theme theme, Constants constants) {
        this.theme = theme;
        this.constants = constants;
    }

    // MODIFIES: this
    // EFFECTS: sets theme to given theme
    public void changeTheme(Theme theme) {
        this.theme = theme;
    }

    // EFFECTS: returns main background color
    public Color getMainBackground() {
        return this.theme.getMainBackground();
    }

    // EFFECTS: returns main top bar background color
    public Color getMainTopBarBackground() {
        return this.theme.getMainTopBarBackground();
    }

    // EFFECTS: returns side panel background color
    public Color getSidePanelBackground() {
        return this.theme.getSidePanelBackground();
    }

    // EFFECTS: returns side panel top bar background color
    public Color getSidePanelTopBarBackground() {
        return this.theme.getSidePanelTopBarBackground();
    }

    // EFFECTS: returns card background color
    public Color getCardBackground() {
        return this.theme.getCardBackground();
    }

    // EFFECTS: returns button background color
    public Color getButtonBackground() {
        return this.theme.getButtonBackground();
    }

    // EFFECTS: returns button background color on hover
    public Color getButtonOnHoverBackground() {
        return this.theme.getButtonOnHoverBackground();
    }

    // EFFECTS: returns symbol color
    public Color getSymbolColor() {
        return this.theme.getSymbolColor();
    }

    // EFFECTS: returns text color
    public Color getTextColor() {
        return this.theme.getTextColor();
    }

    // EFFECTS: returns app height
    public int getAppHeight() {
        return this.constants.getAppHeight();
    }

    // EFFECTS: returns app width
    public int getAppWidth() {
        return this.constants.getAppWidth();
    }

    // EFFECTS: returns side panel width
    public int getSidePanelWidth() {
        return this.constants.getSidePanelWidth();
    }

    // EFFECTS: returns main panel width
    public int getMainPanelWidth() {
        return this.constants.getMainPanelWidth();
    }

    // EFFECTS: returns bar height
    public int getBarHeight() {
        return this.constants.getBarHeight();
    }

    // EFFECTS: returns small gap
    public int getSmallGap() {
        return this.constants.getSmallGap();
    }

    // EFFECTS: returns medium gap
    public int getMediumGap() {
        return this.constants.getMediumGap();
    }

    // EFFECTS returns size of length of square button side
    public int getSquareButtonSize() {
        return this.constants.getSquareButtonSize();
    }

    // EFFECTS: returns size of small font
    public int getSmallFont() {
        return this.constants.getSmallFont();
    }

    // EFFECTS: returns size of big font
    public int getBigFont() {
        return this.constants.getBigFont();
    }

    // EFFECTS: returns size of bigger font
    public int getBiggerFont() {
        return this.constants.getBiggerFont();
    }

    // EFFECTS: returns challenge card panel height
    public int getChallengeCardPanelHeight() {
        return this.constants.getChallengeCardPanelHeight();
    }

    // EFFECTS: returns height of bottom panel
    public int getBottomPanelHeight() {
        return this.constants.getBottomPanelHeight();
    }

    // EFFECTS: returns "mini elaborated challenges" label height
    public int getMiniElaboratedChallengesLabelHeight() {
        return this.constants.getMiniElaboratedChallengesLabelHeight();
    }

    // EFFECTS: returns card height
    public int getCardHeight() {
        return this.constants.getCardHeight();
    }

    // EFFECTS: returns card width
    public int getCardWidth() {
        return this.constants.getCardWidth();
    }

    // EFFECTS: returns header height
    public int getHeaderHeight() {
        return this.constants.getHeaderHeight();
    }

    // EFFECTS: returns bordered button width
    public int getBorderedButtonWidth() {
        return this.constants.getBorderedButtonWidth();
    }

    // EFFECTS returns mini elaborated challenges pane height
    public int getMiniElaboratedChallengesPaneHeight() {
        return this.constants.getMiniElaboratedChallengesPaneHeight();
    }

    // EFFECTS: returns x coordinate of top left corner of button at a specified index relative to other
    // buttons beginning with index 1 being on the rightmost corner
    public int getButtonLocation(int i) {
        return this.constants.getButtonLocation(i);
    }

    // EFFECTS: returns mini challenges label width
    public int getMiniChallengesLabelWidth() {
        return this.constants.getMiniChallengesLabelWidth();
    }

}
