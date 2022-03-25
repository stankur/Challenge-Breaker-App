package ui.views.sidepanel.buttons;

import ui.fomattingdata.FormattingData;
import ui.fomattingdata.RobinTheme;
import ui.views.sidepanel.SidePanelBottomBar;

public class RobinButton extends ThemeChangerButton {
    public RobinButton(FormattingData formattingData, SidePanelBottomBar sidePanelBottomBar) {
        super(formattingData,
                sidePanelBottomBar,
                "./src/main/ui/views/sidepanel/buttons/robin.png",
                new RobinTheme());
    }
}
