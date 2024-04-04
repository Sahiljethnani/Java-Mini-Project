package View;

import javax.swing.*;

public class AddContactPanel extends JPanel {

    JTextField txt_contact_id;
    JTextField txt_contact_fname;
    JTextField txt_contact_lname;
    JTextField txt_contact_email;

    JTextField txt_contact_address;
    JTextField txt_contact_mobile;
    JButton addContactBtn;

    public AddContactPanel()
    {

        txt_contact_id = new JTextField();
        txt_contact_fname = new JTextField();
        txt_contact_lname = new JTextField();
        txt_contact_email = new JTextField();
        txt_contact_address = new JTextField();
        txt_contact_mobile = new JTextField();
        addContactBtn = new JButton("Add Contact");


        txt_contact_id.setText("txt_contact_id");
        txt_contact_fname.setText("txt_contact_fname");
        txt_contact_lname.setText("txt_contact_lname");
        txt_contact_email.setText("txt_contact_email");
        txt_contact_address.setText("txt_contact_address");
        txt_contact_mobile.setText("txt_contact_mobile");

        add(txt_contact_id);
        add(txt_contact_fname);
        add(txt_contact_lname);
        add(txt_contact_email);
        add(txt_contact_address);
        add(txt_contact_mobile);
        add(addContactBtn);
    }

    public JTextField getTxt_contact_id() {
        return txt_contact_id;
    }
    public JTextField getTxt_contact_fname() {
        return txt_contact_fname;
    }
    public JTextField getTxt_contact_lname() {
        return txt_contact_lname;
    }
    public JTextField getTxt_contact_email() {
        return txt_contact_email;
    }
    public JTextField getTxt_contact_address() {
        return txt_contact_address;
    }
    public JTextField getTxt_contact_mobile() {
        return txt_contact_mobile;
    }



    public JButton getAddContactBtn() {
        return addContactBtn;
    }

    public void setTxt_contact_id(JTextField txt_contact_id) {
        this.txt_contact_id = txt_contact_id;
    }
    public void setTxt_contact_fname(JTextField txt_contact_id) {
        this.txt_contact_fname = txt_contact_fname;
    }
    public void setTxt_contact_lname(JTextField txt_contact_lname) {
        this.txt_contact_lname = txt_contact_lname;
    }
    public void setTxt_contact_email(JTextField txt_contact_email) {
        this.txt_contact_email = txt_contact_email;
    }




    public void setAddContactBtn(JButton addContactBtn) {
        this.addContactBtn = addContactBtn;
    }
}
