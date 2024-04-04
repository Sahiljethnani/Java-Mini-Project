package View;

import javax.swing.*;

public class ManageContactFrame extends JFrame {
    InitialPanelContact contact_ip;

    public ManageContactFrame() {
        super("Manage Address Book"); // Fixed the missing closing quotation mark here
        contact_ip = new InitialPanelContact();
        add(contact_ip);
        pack();
        setSize(500, 600);
    }

    public void setContact_ip(InitialPanelContact contact_ip) {
        this.contact_ip = contact_ip;
    }

    public InitialPanelContact getContact_ip() {
        return contact_ip;
    }
}
