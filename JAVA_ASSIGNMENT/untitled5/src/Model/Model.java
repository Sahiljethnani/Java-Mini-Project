package Model;

import Model.Contacts.manageContact;


public class Model {
    manageContact mc;


    public Model() {
        mc = new manageContact();

    }

    public manageContact getMc() {
        return mc;
    }



    public void setMs(manageContact mc) {
        this.mc = mc;
    }




}
