package ui.fomattingdata;

import java.awt.*;

public class FormattingData {
    Theme theme;
    Constants constants;

    public FormattingData(Theme theme, Constants constants) {
        this.theme = theme;
        this.constants = constants;
    }

    public Color getMainBackground() {
        return this.theme.getMainBackground();
    }

    public Color getMainTopBarBackground() {
        return this.theme.getMainTopBarBackground();
    }

    public Color getSidePanelBackground() {
        return this.theme.getSidePanelBackground();
    }

    public Color getSidePanelTopBarBackground() {
        return this.theme.getSidePanelTopBarBackground();
    }

    public Color getCardBackground() {
        return this.theme.getCardBackground();
    }

    public Color getButtonBackground() {
        return this.theme.getButtonBackground();
    }

    public Color getButtonOnHoverBackground() {
        return this.theme.getButtonOnHoverBackground();
    }

    public Color getSymbolColor() {
        return this.theme.getSymbolColor();
    }

    public Color getTextColor() {
        return this.theme.getTextColor();
    }

    public int getAppHeight() {
        return this.constants.getAppHeight();
    }

    public int getAppWidth() {
        return this.constants.getAppWidth();
    }

    public int getSidePanelWidth() {
        return this.constants.getSidePanelWidth();
    }

    public int getMainPanelWidth() {
        return this.constants.getMainPanelWidth();
    }

    public int getBarHeight() {
        return this.constants.getBarHeight();
    }

    public int getSmallGap() {
        return this.constants.getSmallGap();
    }

    public int getMediumGap() {
        return this.constants.getMediumGap();
    }

    public int getSquareButtonSize() {
        return this.constants.getSquareButtonSize();
    }

    public int getSmallFont() {
        return this.constants.getSmallFont();
    }

    public int getBigFont() {
        return this.constants.getBigFont();
    }

    public int getBiggerFont() {
        return this.constants.getBiggerFont();
    }

    public int getChallengeCardPanelHeight() {
        return this.constants.getChallengeCardPanelHeight();
    }

    public int getBottomPanelHeight() {
        return this.constants.getBottomPanelHeight();
    }

    public int getMiniElaboratedChallengesLabelHeight() {
        return this.constants.getMiniElaboratedChallengesLabelHeight();
    }

    public int getCardHeight() {
        return this.constants.getCardHeight();
    }

    public int getCardWidth() {
        return this.constants.getCardWidth();
    }

    public int getHeaderHeight() {
        return this.constants.getHeaderHeight();
    }

    public int getBorderedButtonWidth() {
        return this.constants.getBorderedButtonWidth();
    }

    public int getMiniElaboratedChallengesPaneHeight() {
        return this.constants.getMiniElaboratedChallengesPaneHeight();
    }

}
