package ui.views.sidepanel.buttons;

import ui.fomattingdata.BatmanTheme;
import ui.fomattingdata.FormattingData;
import ui.views.sidepanel.SidePanelBottomBar;

// represents a batman button
public class BatmanButton extends ThemeChangerButton {

    // EFFECTS: constructs a new batman button with given formatting data and reference to side panel bottom
    //          bar, with an associated theme and image of batman
    public BatmanButton(FormattingData formattingData, SidePanelBottomBar sidePanelBottomBar) {
        super(formattingData,
                sidePanelBottomBar,
                "./src/main/ui/views/sidepanel/buttons/batman.png",
                new BatmanTheme());
    }
}
