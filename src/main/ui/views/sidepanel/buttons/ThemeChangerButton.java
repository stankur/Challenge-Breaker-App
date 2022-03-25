package ui.views.sidepanel.buttons;

import ui.fomattingdata.FormattingData;
import ui.fomattingdata.Theme;
import ui.views.reusables.SquareButton;
import ui.views.sidepanel.SidePanelBottomBar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public abstract class ThemeChangerButton extends SquareButton {
    private FormattingData formattingData;
    private SidePanelBottomBar sidePanelBottomBar;
    private Theme associatedTheme;

    public ThemeChangerButton(FormattingData formattingData, SidePanelBottomBar sidePanelBottomBar,
                              String imageIconPath, Theme associatedTheme) {
        super(formattingData, null, getImage(imageIconPath,
                formattingData.getSquareButtonSize() - formattingData.getSmallGap()));

        this.formattingData = formattingData;
        this.sidePanelBottomBar = sidePanelBottomBar;
        this.associatedTheme = associatedTheme;
    }

    private static ImageIcon getImage(String imagePath, int size) {
        ImageIcon icon = new ImageIcon();

        try {
            BufferedImage rawImage = ImageIO.read(new File(
                    imagePath
            ));
            Image scaledImage = rawImage.getScaledInstance(size, size, Image.SCALE_AREA_AVERAGING);
            icon = new ImageIcon(scaledImage);

        } catch (Exception e) {
            System.out.println("not found");
        }

        return icon;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.sidePanelBottomBar.requestChangeTheme(this.associatedTheme);
    }


}
