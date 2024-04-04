package Model.Contacts;


import Model.Contacts.Contact;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingContact {
    protected abstract ArrayList<Contact> readContactJsonFile(String file_path);
    protected abstract void writeContactJsonFile(String file_path, ArrayList<Contact> students) throws IOException;
}
