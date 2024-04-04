/*
/**
*
*
* Identification comments:
*   Name: Sarthak Shinde
*   Homework/Lab 3B Assignment - Interfaces and Arrays
*   Due Date: 03-03-23
*   Email Address: sps6944@psu.edu
*   @version 1.0
*
*
* Beginning comments
* Filename: View.java
* author:   Sarthak Shinde
* Overview: The View class represents the user interface of an application, and it is responsible for presenting data to the
            user and receiving input from them. It is typically used in the Model-View-Controller (MVC) architectural pattern,
            where the View is the part of the application that interacts with the user and displays information. The public class
            View is declared but there are no methods or fields defined in it.
*/

package View;

import View.ManageContactFrame;

import java.awt.*;
import java.util.ArrayList;

public class View {
    FirstFrame ff;

    ManageContactFrame mcf;


    public View()
    {
        ff = new FirstFrame();

        mcf = new ManageContactFrame();
    }



    public void centerInitialSetupContact(int linesBeingDisplayed, int size) {
        mcf.getContact_ip().getCtp().setLayout(new GridLayout(linesBeingDisplayed+1,size));
        mcf.getContact_ip().getCtp().createButtons((linesBeingDisplayed+1) * size);
    }

    public void centerUpdateContact(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++)
        {
            mcf.getContact_ip().getCtp().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int contact_row_no = 0; contact_row_no < lines.size(); contact_row_no++)
        {
            for (int contact_col_no = 0; contact_col_no < headers.size(); contact_col_no++)
            {
                int button_no = contact_row_no * headers.size() + headers.size() + contact_col_no;
                String button_txt = lines.get(contact_row_no).get(contact_col_no);

                mcf.getContact_ip().getCtp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void setFf(FirstFrame ff) {
        this.ff = ff;
    }

    public FirstFrame getFf() {
        return ff;
    }



    public void setMcf(ManageContactFrame mcf) {
        this.mcf = mcf;
    }

    public ManageContactFrame getMcf() {
        return mcf;
    }

}

