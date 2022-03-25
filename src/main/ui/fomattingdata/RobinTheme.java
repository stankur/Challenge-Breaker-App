package ui.fomattingdata;

import java.awt.*;

// represents a robin theme
public class RobinTheme extends Theme {
    private Color mainBackground;
    private Color mainTopBarBackground;

    private Color sidePanelBackground;
    private Color sidePanelTopBarBackground;

    private Color cardBackground;
    private Color buttonBackground;

    private Color buttonOnHoverBackground;

    private Color symbolColor;
    private Color textColor;


    // EFFECTS: constructs a theme object with values assigned according to the visuals of a robin theme
    public RobinTheme() {
        mainBackground = new Color(44, 44, 44);
        mainTopBarBackground = new Color(81, 76, 76);

        sidePanelBackground = new Color(74, 114, 88);
        sidePanelTopBarBackground = new Color(74, 136, 89);

        cardBackground = new Color(154, 69, 73);
        buttonBackground = new Color(44, 44, 44);

        buttonOnHoverBackground = new Color(58, 55, 55);

        symbolColor = new Color(190, 190, 130);
        textColor = new Color(204, 204, 204);
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
