package View;

import javax.swing.*;

public class EditContactPanel extends JPanel{

    JTextField txt_get_Contact_idx;
    JButton getContactBtn;
    JTextField txt_Contact_id;
    JTextField txt_Contact_f_name;
    JTextField txt_Contact_l_name;
    JTextField txt_Contact_email;
    JTextField txt_Contact_address;
    JTextField txt_Contact_mobile;
    JButton editContactBtn;

    public EditContactPanel()
    {

        txt_Contact_id = new JTextField();
        txt_Contact_f_name = new JTextField();
        txt_Contact_l_name = new JTextField();
        txt_Contact_email = new JTextField();
        txt_Contact_address = new JTextField();
        txt_Contact_mobile= new JTextField();
        editContactBtn = new JButton("Edit Contact");
        txt_get_Contact_idx = new JTextField();

        getContactBtn = new JButton("Get Contact to Edit");

        txt_Contact_id.setText("txt_Contact_id");
        txt_Contact_f_name.setText("txt_Contact_f_name");
        txt_Contact_l_name.setText("txt_Contact_l_name");
        txt_Contact_email.setText("txt_Contact_email");
        txt_Contact_address.setText("txt_Contact_address");
        txt_Contact_mobile.setText("txt_Contact_mobile");
        txt_get_Contact_idx.setText("get Contact idx");


        add(txt_get_Contact_idx);
        add(getContactBtn);

        add(txt_Contact_id);
        add(txt_Contact_f_name);
        add(txt_Contact_l_name);
        add(txt_Contact_email);
        add(txt_Contact_address);
        add(txt_Contact_mobile);
        add(editContactBtn);
    }

    public JTextField getTxt_Contact_id() {
        return txt_Contact_id;
    }

    public JTextField getTxt_Contact_f_name() {
        return txt_Contact_f_name;
    }

    public void setTxt_Contact_l_name(JTextField txt_Contact_l_name) {
        this.txt_Contact_l_name = txt_Contact_l_name;
    }

    public JTextField getTxt_Contact_address() {
        return txt_Contact_address;
    }

    public JTextField getTxt_Contact_mobile() {
        return txt_Contact_mobile;
    }

    public JTextField getTxt_Contact_email() {
        return txt_Contact_email;
    }

    public JButton getEditContactBtn() {
        return editContactBtn;
    }

    public JTextField getTxt_get_Contact_idx() {
        return txt_get_Contact_idx;
    }
    public JButton getGetContactBtn() {
        return getContactBtn;
    }
    public void setTxt_Contact_id(JTextField txt_Contact_id) {
        this.txt_Contact_id = txt_Contact_id;
    }

    public void setTxt_Contact_f_name(JTextField txt_Contact_f_name) {
        this.txt_Contact_f_name = txt_Contact_f_name;
    }

    public JTextField getTxt_Contact_l_name() {
        return txt_Contact_l_name;
    }

    public void setTxt_Contact_mobile(JTextField txt_Contact_mobile) {
        this.txt_Contact_mobile= txt_Contact_mobile;
    }

    public void setTxt_Contact_address(JTextField txt_Contact_address) {
        this.txt_Contact_address = txt_Contact_address;
    }

    public void setTxt_Contact_email(JTextField txt_Contact_email) {
        this.txt_Contact_email = txt_Contact_email;
    }

    public void setEditContactBtn(JButton editContactBtn) {
        this.editContactBtn = editContactBtn;
    }

    public void setTxt_get_Contact_idx(JTextField txt_get_Contact_idx) {
        this.txt_get_Contact_idx = txt_get_Contact_idx;
    }

    public void setGetContactBtn(JButton getContactBtn) {
        this.getContactBtn = getContactBtn;
    }
}


