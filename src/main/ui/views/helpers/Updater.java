package ui.views.helpers;

import javax.swing.*;

// Represents an updater
public class Updater {
    // EFFECTS: constructs an updater which updates given updatable components
    public Updater(JComponent updatable) {
        updatable.repaint();
        updatable.revalidate();
        updatable.setVisible(true);
    }
}
