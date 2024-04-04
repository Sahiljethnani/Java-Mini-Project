package Controller;

import Model.Model;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;


public class Controller {
    Model model;
    View view;

    public Controller(Model m, View v)
    {
        model = m;
        view = v;



        view.getFf().getManageContactBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFf().setVisible(false);
                view.getMcf().setVisible(true);
            }
        });
        view.getMcf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });


        view.getMcf().getContact_ip().getCtp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMc().getFirstLineToDisplay();
                int current_last_line = model.getMc().getLastLineToDisplay();
                int no_of_tourists = model.getMc().getTable().size();
                int no_of_display_lines = model.getMc().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMc().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMc().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_tourists-1)
                {
                    model.getMc().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_tourists-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_tourists - no_of_display_lines)
                    {
                        new_first_line = no_of_tourists-no_of_display_lines;
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateContact(model.getMc().getLines(model.getMc().getFirstLineToDisplay(), model.getMc().getLastLineToDisplay()), model.getMc().getHeaders());
            }
        });

        view.getMcf().getContact_ip().getAcp().getAddContactBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Contact Button Clicked");
                String txt_contact_id = view.getMcf().getContact_ip().getAcp().getTxt_contact_id().getText();
                String txt_contact_f_name = view.getMcf().getContact_ip().getAcp().getTxt_contact_fname().getText();
                String txt_contact_l_name = view.getMcf().getContact_ip().getAcp().getTxt_contact_lname().getText();
                String txt_contact_email = view.getMcf().getContact_ip().getAcp().getTxt_contact_email().getText();
                String txt_contact_address = view.getMcf().getContact_ip().getAcp().getTxt_contact_address().getText();
                String txt_contact_mobile = view.getMcf().getContact_ip().getAcp().getTxt_contact_mobile().getText();
                try {
                    model.getMc().addNewContact(Integer.valueOf(txt_contact_id),txt_contact_f_name,txt_contact_l_name,txt_contact_email,txt_contact_address,txt_contact_mobile);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        view.getMcf().getContact_ip().getEcp().getGetContactBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Contact Details Clicked");
                String txt_contact_idx = view.getMcf().getContact_ip().getEcp().getTxt_get_Contact_idx().getText();
                model.getMc().readContactJsonFile("Model/Contacts/Contacts.json");
                int contact_id = model.getMc().getTable().get(Integer.valueOf(txt_contact_idx)).getcontact_id();
                String contact_f_name = model.getMc().getTable().get(Integer.valueOf(txt_contact_idx)).getFname();
                String contact_l_name = model.getMc().getTable().get(Integer.valueOf(txt_contact_idx)).getLname();
                String contact_email = model.getMc().getTable().get(Integer.valueOf(txt_contact_idx)).getEmail();
                String contact_address = model.getMc().getTable().get(Integer.valueOf(txt_contact_idx)).getAddress();
                String contact_mobile = model.getMc().getTable().get(Integer.valueOf(txt_contact_idx)).getMobile();

                view.getMcf().getContact_ip().getEcp().getTxt_Contact_id().setText(String.valueOf(contact_id));
                view.getMcf().getContact_ip().getEcp().getTxt_Contact_f_name().setText(contact_f_name);
                view.getMcf().getContact_ip().getEcp().getTxt_Contact_l_name().setText(contact_l_name);
                view.getMcf().getContact_ip().getEcp().getTxt_Contact_email().setText(contact_email);
                view.getMcf().getContact_ip().getEcp().getTxt_Contact_address().setText(String.valueOf(contact_address));
                view.getMcf().getContact_ip().getEcp().getTxt_Contact_mobile().setText(contact_mobile);
            }
        });

        view.getMcf().getContact_ip().getEcp().getEditContactBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Contact Button Clicked");
                String txt_contact_idx = view.getMcf().getContact_ip().getEcp().getTxt_get_Contact_idx().getText();
                String txt_contact_id = view.getMcf().getContact_ip().getEcp().getTxt_Contact_id().getText();
                String txt_contact_f_name = view.getMcf().getContact_ip().getEcp().getTxt_Contact_f_name().getText();
                String txt_contact_l_name = view.getMcf().getContact_ip().getEcp().getTxt_Contact_l_name().getText();
                String txt_contact_email = view.getMcf().getContact_ip().getEcp().getTxt_Contact_email().getText();
                String txt_contact_address = view.getMcf().getContact_ip().getEcp().getTxt_Contact_address().getText();
                String txt_contact_mobile = view.getMcf().getContact_ip().getEcp().getTxt_Contact_mobile().getText();
                try {
                    model.getMc().editNewContact(Integer.valueOf(txt_contact_idx),Integer.valueOf(txt_contact_id),txt_contact_f_name,txt_contact_l_name,txt_contact_email,txt_contact_address,txt_contact_mobile);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMcf().getContact_ip().getDcp().getDeleteContactBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Contact Button Clicked");
                String txt_tourist_idx = view.getMcf().getContact_ip().getDcp().getTxt_del_contact_id().getText();
                try {
                    model.getMc().deleteContact(Integer.valueOf(txt_tourist_idx));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        model.getMc().setLinesBeingDisplayed(20);
        view.centerInitialSetupContact(model.getMc().getLinesBeingDisplayed(),model.getMc().getHeaders().size());
        model.getMc().setFirstLineToDisplay(0);
        view.centerUpdateContact(model.getMc().getLines(model.getMc().getFirstLineToDisplay(),model.getMc().getLastLineToDisplay()),model.getMc().getHeaders());}}

