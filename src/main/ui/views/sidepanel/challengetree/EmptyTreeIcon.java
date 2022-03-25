// code inspired from:
// https://stackoverflow.com/questions/5260223/how-to-remove-folder-symbol-
// which-comes-in-front-of-each-node-from-jtree-in-java/5263600#5263600

package ui.views.sidepanel.challengetree;

import javax.swing.*;
import java.awt.*;

public class EmptyTreeIcon implements Icon {
    private static int SIZE = 0;

    public EmptyTreeIcon() {
    }

    public int getIconWidth() {
        return SIZE;
    }

    public int getIconHeight() {
        return SIZE;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        System.out.println(c.getWidth() + " " + c.getHeight() + " " + x + " " + y);
    }

}
