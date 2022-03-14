package ui.fomattingdata;

import ui.fomattingdata.Theme;

import java.awt.*;

public class DarkTheme extends Theme {
    private Color mainBackground;
    private Color mainTopBarBackground;

    private Color sidePanelBackground;
    private Color sidePanelTopBarBackground;

    private Color cardBackground;
    private Color buttonBackground;

    private Color buttonOnHoverBackground;

    private Color symbolColor;
    private Color textColor;


    public DarkTheme() {
        mainBackground = new Color(37, 37, 37);
        mainTopBarBackground = new Color(70, 70, 70);

        sidePanelBackground = new Color(54, 54, 54);
        sidePanelTopBarBackground = new Color(85, 85, 85);

        cardBackground = new Color(45, 45, 45);
        buttonBackground = new Color(70, 70, 70);

        buttonOnHoverBackground = new Color(63, 63, 63);

        symbolColor = new Color(4, 148, 129);
        textColor = new Color(159, 159, 159);
    }

    @Override
    public Color getMainBackground() {
        return this.mainBackground;
    }

    @Override
    public Color getMainTopBarBackground() {
        return this.mainTopBarBackground;
    }

    @Override
    public Color getSidePanelBackground() {
        return this.sidePanelBackground;
    }

    @Override
    public Color getSidePanelTopBarBackground() {
        return this.sidePanelTopBarBackground;
    }

    @Override
    public Color getCardBackground() {
        return this.cardBackground;
    }

    @Override
    public Color getButtonBackground() {
        return this.buttonBackground;
    }

    @Override
    public Color getButtonOnHoverBackground() {
        return this.buttonOnHoverBackground;
    }

    @Override
    public Color getSymbolColor() {
        return this.symbolColor;
    }

    public Color getTextColor() {
        return this.textColor;
    }

}
