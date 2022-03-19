package ui.views.reusables;

import ui.fomattingdata.FormattingData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SquareButton extends JPanel implements MouseListener {
    private FormattingData formattingData;
    private String symbol;

    public SquareButton(FormattingData formattingData, String symbol) {
        super();

        this.formattingData = formattingData;
        this.symbol = symbol;

        addMouseListener(this);

        setSize(40,40);
        setBackground(this.formattingData.getButtonBackground());

        JLabel content = new JLabel();

        content.setText(symbol);
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

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(this.formattingData.getButtonOnHoverBackground());
        repaint();
        revalidate();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(this.formattingData.getButtonBackground());
        repaint();
        revalidate();
    }
}
