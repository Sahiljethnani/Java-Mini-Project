package View;

import javax.swing.*;

public class DeleteContactPanel extends JPanel {

    JTextField txt_del_contact_id;
    JButton deleteContactBtn;

    public DeleteContactPanel()
    {

        txt_del_contact_id = new JTextField();
        deleteContactBtn = new JButton("Delete Contact");

        txt_del_contact_id.setText("txt_contact_id");

        add(txt_del_contact_id);
        add(deleteContactBtn);
    }

    public JButton getDeleteContactBtn() {
        return deleteContactBtn;
    }

    public JTextField getTxt_del_contact_id() {
        return txt_del_contact_id;
    }

    public void setDeleteContactBtn(JButton deleteContactBtn) {
        this.deleteContactBtn = deleteContactBtn;
    }

    public void setTxt_del_contact_id(JTextField txt_del_contact_id) {
        this.txt_del_contact_id = txt_del_contact_id;
    }
}
