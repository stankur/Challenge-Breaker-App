package ui.views.reusables;

import ui.fomattingdata.FormattingData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// represents a square button
public class SquareButton extends JPanel implements MouseListener {
    private FormattingData formattingData;
    private String symbol;

    // EFFECTS: constructs a square button with given formatting data, symbol, and image icon
    public SquareButton(FormattingData formattingData, String symbol, ImageIcon imageIcon) {
        super();

        this.formattingData = formattingData;
        this.symbol = symbol;

        addMouseListener(this);

        setSize(this.formattingData.getSquareButtonSize(),this.formattingData.getSquareButtonSize());
        setBackground(this.formattingData.getButtonBackground());

        JLabel content = new JLabel();

        content.setText(symbol);
        content.setIcon(imageIcon);
        content.setForeground(this.formattingData.getSymbolColor());
        content.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
        content.setHorizontalAlignment(JLabel.CENTER);
        content.setVerticalAlignment(JLabel.TOP);

        add(content);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    // MODIFIES: this
    // EFFECTS: sets background to button on hover background and re-render
    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(this.formattingData.getButtonOnHoverBackground());
        repaint();
        revalidate();
    }

    // MODIFIES: this
    // EFFECTS: sets background to normal button background
    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(this.formattingData.getButtonBackground());
        repaint();
        revalidate();
    }
}
