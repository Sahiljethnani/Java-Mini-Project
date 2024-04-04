package View;

import javax.swing.*;
import java.awt.*;

public class FirstFrame extends JFrame {
    private JButton manageContactBtn;
    private JPanel firstPanel;
    private LoginWindow log;

    public FirstFrame() {
        super("Main Dashboard");

        manageContactBtn = new JButton("Manage AddressBook");
        manageContactBtn.setBackground(Color.YELLOW); // Set button background color
        manageContactBtn.setForeground(Color.BLACK); // Set button text color
        manageContactBtn.setPreferredSize(new Dimension(200, 100));
        Font buttonFont = manageContactBtn.getFont();
        Font newFont = new Font(buttonFont.getName(), Font.PLAIN, 15); // Adjust font size here
        manageContactBtn.setFont(newFont);

        firstPanel = new JPanel();
        firstPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Set padding
        firstPanel.add(manageContactBtn, gbc);

        getContentPane().add(firstPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(400, 200); // Set frame size
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
        log = new LoginWindow(this);
    }

    public void setFirstPanel(JPanel firstPanel) {
        this.firstPanel = firstPanel;
    }

    public void setManageContactBtn(JButton manageContactBtn) {
        this.manageContactBtn = manageContactBtn;
    }

    public JPanel getFirstPanel() {
        return firstPanel;
    }

    public JButton getManageContactBtn() {
        return manageContactBtn;
    }

    public void showMainFrame() {
        setVisible(true); // Make the main frame visible after a successful login
    }
}
