package ui.fomattingdata;

import java.awt.*;

// represents a batman theme
public class BatmanTheme extends Theme {
    private Color mainBackground;
    private Color mainTopBarBackground;

    private Color sidePanelBackground;
    private Color sidePanelTopBarBackground;

    private Color cardBackground;
    private Color buttonBackground;

    private Color buttonOnHoverBackground;

    private Color symbolColor;
    private Color textColor;


    // EFFECTS: constructs a theme object with values assigned according to the visuals of a batman theme
    public BatmanTheme() {
        mainBackground = new Color(37, 37, 37);
        mainTopBarBackground = new Color(70, 70, 70);

        sidePanelBackground = new Color(54, 54, 54);
        sidePanelTopBarBackground = new Color(85, 85, 85);

        cardBackground = new Color(45, 45, 45);
        buttonBackground = new Color(70, 70, 70);

        buttonOnHoverBackground = new Color(63, 63, 63);

        symbolColor = new Color(190, 190, 130);
        textColor = new Color(159, 159, 159);
    }

    // EFFECTS: returns main background color
    @Override
    public Color getMainBackground() {
        return this.mainBackground;
    }

    // EFFECTS: returns main top bar background color
    @Override
    public Color getMainTopBarBackground() {
        return this.mainTopBarBackground;
    }

    // EFFECTS: returns side panel background color
    @Override
    public Color getSidePanelBackground() {
        return this.sidePanelBackground;
    }

    // EFFECTS: returns side panel top bar background color
    @Override
    public Color getSidePanelTopBarBackground() {
        return this.sidePanelTopBarBackground;
    }

    // EFFECTS: returns card background color
    @Override
    public Color getCardBackground() {
        return this.cardBackground;
    }

    // EFFECTS: returns button background color
    @Override
    public Color getButtonBackground() {
        return this.buttonBackground;
    }

    // EFFECTS: returns button background color on hover
    @Override
    public Color getButtonOnHoverBackground() {
        return this.buttonOnHoverBackground;
    }

    // EFFECTS: returns symbol color
    @Override
    public Color getSymbolColor() {
        return this.symbolColor;
    }

    // EFFECTS: returns text color
    @Override
    public Color getTextColor() {
        return this.textColor;
    }

}
