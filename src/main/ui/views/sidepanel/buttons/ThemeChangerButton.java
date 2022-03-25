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

// represents a theme changer button
public abstract class ThemeChangerButton extends SquareButton {
    private FormattingData formattingData;
    private SidePanelBottomBar sidePanelBottomBar;
    private Theme associatedTheme;

    // EFFECTS: constructs a theme changer button with given formatting data, reference to side panel
    //          bottom bar, icon image of image located at given image icon path, and with an associated theme
    //          of given associated theme
    public ThemeChangerButton(FormattingData formattingData, SidePanelBottomBar sidePanelBottomBar,
                              String imageIconPath, Theme associatedTheme) {
        super(formattingData, null, getImage(imageIconPath,
                formattingData.getSquareButtonSize() - formattingData.getSmallGap()));

        this.formattingData = formattingData;
        this.sidePanelBottomBar = sidePanelBottomBar;
        this.associatedTheme = associatedTheme;
    }

    // EFFECTS: returns an image icon with image with size of given size from image path
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

    // EFFECTS: requests side panel bottom bar to change theme into this' associated theme
    @Override
    public void mousePressed(MouseEvent e) {
        this.sidePanelBottomBar.requestChangeTheme(this.associatedTheme);
    }


}
