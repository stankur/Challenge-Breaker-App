package ui.views.sidepanel.buttons;

import ui.fomattingdata.BatmanTheme;
import ui.fomattingdata.FormattingData;
import ui.views.sidepanel.SidePanelBottomBar;

public class BatmanButton extends ThemeChangerButton {
    public BatmanButton(FormattingData formattingData, SidePanelBottomBar sidePanelBottomBar) {
        super(formattingData,
                sidePanelBottomBar,
                "./src/main/ui/views/sidepanel/buttons/batman.png",
                new BatmanTheme());
    }
}
