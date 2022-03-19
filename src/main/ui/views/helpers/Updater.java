package ui.views.helpers;

import javax.swing.*;

public class Updater {
    public Updater(JComponent updatable) {
        updatable.repaint();
        updatable.revalidate();
        updatable.setVisible(true);
    }
}
