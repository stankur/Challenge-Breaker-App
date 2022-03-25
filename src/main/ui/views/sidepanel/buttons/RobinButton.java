package ui.views.sidepanel.buttons;

import ui.fomattingdata.FormattingData;
import ui.fomattingdata.RobinTheme;
import ui.views.sidepanel.SidePanelBottomBar;

// represents a robin button
public class RobinButton extends ThemeChangerButton {

    // EFFECTS: constructs a new robin button with given formatting data, reference to side panel bottom bar, and
    //          with an associated theme and image icon of robin
    public RobinButton(FormattingData formattingData, SidePanelBottomBar sidePanelBottomBar) {
        super(formattingData,
                sidePanelBottomBar,
                "./src/main/ui/views/sidepanel/buttons/robin.png",
                new RobinTheme());
    }
}
