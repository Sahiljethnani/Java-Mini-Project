package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContactTablePanel extends JPanel {

    ArrayList<JButton> contact_buttons = new ArrayList<>();

    public ContactTablePanel()
    {
        super();
    }

    public void createButtons(int count)
    {
        for (int i = 1; i <= count; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.yellow);
            b.setSize(500,50);
            contact_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }

    }

    public void setButtonText(int button_no, String button_text) {
        contact_buttons.get(button_no).setText(button_text);
    }

    public ArrayList<JButton> getAllButtons()
    {
        return contact_buttons;
    }

}
