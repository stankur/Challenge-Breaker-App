package ui.fomattingdata;

import java.awt.*;

// represents a theme with various colors
public abstract class Theme {
    // EFFECTS: returns main background color
    public abstract Color getMainBackground();

    // EFFECTS: returns main top bar background color
    public abstract Color getMainTopBarBackground();

    //EFFECTS: returns side panel background color
    public abstract Color getSidePanelBackground();

    // EFFECTS: returns side panel top bar background color
    public abstract Color getSidePanelTopBarBackground();

    // EFFECTS: returns card background color
    public abstract Color getCardBackground();

    // EFFECTS: returns button background color
    public abstract Color getButtonBackground();

    // EFFECTS: returns button color on hover
    public abstract Color getButtonOnHoverBackground();

    // EFFECTS: returns symbol color
    public abstract Color getSymbolColor();

    // EFFECTS: returns text color
    public abstract Color getTextColor();

}
