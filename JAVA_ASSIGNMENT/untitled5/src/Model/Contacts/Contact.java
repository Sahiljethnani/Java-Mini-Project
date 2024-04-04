package Model.Contacts;


public class Contact extends Person {
    private static int contact_count = 0;
    int contact_id;

    public static void setcontact_count(int count)
    {
        contact_count=count;
    }
    public static int getcontact_count()
    {
        return contact_count;
    }


    public Contact()
    {
        setcontact_count(getcontact_count()+1);
        this.setcontact_id(contact_count);
    }

    public Contact( String contact_fname, String contact_lname, String contact_email, String contact_address, String contact_mobile)
    {
        super(contact_fname, contact_lname, contact_email,contact_address,contact_mobile);
        setcontact_count(getcontact_count()+1);;
        this.setcontact_id(contact_count);

    }

    public Contact(int contact_id, String contact_fname, String contact_lname, String contact_email, String contact_address, String contact_mobile)
    {
        super(contact_fname, contact_lname, contact_email, contact_address,contact_mobile);
        setcontact_count(getcontact_count()+1);;
        this.setcontact_id(contact_id);

    }

    public void setcontact_id(int id) {
        this.contact_id = id;
    }



    public int getcontact_id() {
        return contact_id;
    }



    public void display()
    {
        System.out.println("Contact Id: "+getcontact_id());

        super.display();
    }

}
