package Model.Contacts; // Changed class name to follow Java conventions

import Model.Contacts.Contact;
import Model.Displayable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class manageContact extends FileHandlingContact implements Displayable { // Changed class name to follow Java conventions

    private ArrayList<Contact> contacts = new ArrayList<>(); // Added explicit type declaration
    private ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    private int lastLineIndex;
    private int highlightedLine;

    public manageContact() {
        readContactJsonFile("Model/Contacts/Contacts.json"); // Corrected file path
    }

    @Override
    public ArrayList<Contact> readContactJsonFile(String filePath) {
        contacts.clear(); // Used clear() method instead of removeAll() for clarity
        try {
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int contactId = node.get("contact_id").asInt(); // JSON field name is "contact_id"
                    String contactFname = node.get("fname").asText(); // JSON field name is "fname"
                    String contactLname = node.get("lname").asText(); // JSON field name is "lname"
                    String contactEmail = node.get("email").asText(); // JSON field name is "email"
                    String contactAddress = node.get("address").asText(); // JSON field name is "address"
                    String contactMobile = node.get("mobile").asText(); // JSON field name is "mobile"
                    Contact tempContact = new Contact(contactId, contactFname, contactLname, contactEmail, contactAddress, contactMobile);
                    contacts.add(tempContact);
                }
            }
        } catch (IOException e) {
            // Handle the exception appropriately (logging or rethrowing)
            e.printStackTrace();
        }

        return contacts;
    }

    @Override
    public void writeContactJsonFile(String file_path, ArrayList<Contact> contacts) throws IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), contacts);
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Contact Id");
        headers.add("Contact first Name");
        headers.add("Contact last Name");
        headers.add("Contact Email");
        headers.add("Contact Address");
        headers.add("Contact Mobile");


        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> contact_details = new ArrayList<String>();

        contact_details.add(String.valueOf(contacts.get(line).getcontact_id()));
        contact_details.add(contacts.get(line).getFname());
        contact_details.add(contacts.get(line).getLname());
        contact_details.add(contacts.get(line).getEmail());
        contact_details.add(contacts.get(line).getAddress());
        contact_details.add(contacts.get(line).getMobile());


        return contact_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> contact_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            contact_subset.add(getLine(i));
        }
        return contact_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return this.firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return 0;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(this.firstLineIndex + this.linesBeingDisplayed - 1);
        return this.lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {

    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }

    public ArrayList<Contact> getTable() {
        readContactJsonFile("Model/Contacts/Contacts.json");
        return contacts;
    }

    public void addNewContact(int contact_id, String contact_fname,String contact_lname,String contact_email, String contact_address, String contact_mobile) throws IOException {
        readContactJsonFile("Model/Contacts/Contacts.json");
        Contact temp_stud = new Contact(contact_id, contact_fname,contact_lname,contact_email,contact_address,contact_mobile);
        contacts.add(temp_stud);
        writeContactJsonFile("Model/Contacts/Contacts.json",contacts);

    }

    public void editNewContact(int edit_contact_idx,int contact_id, String contact_fname,String contact_lname,String contact_email, String contact_address, String contact_mobile) throws IOException {
        readContactJsonFile("Model/Contacts/Contacts.json");
        contacts.get(edit_contact_idx).setcontact_id(contact_id);
        contacts.get(edit_contact_idx).setFname(contact_fname);
        contacts.get(edit_contact_idx).setLname(contact_lname);
        contacts.get(edit_contact_idx).setEmail(contact_email);
        contacts.get(edit_contact_idx).setAddress(contact_address);
        contacts.get(edit_contact_idx).setMobile(contact_mobile);
        writeContactJsonFile("Model/Contacts/Contacts.json",contacts);
    }

    public void deleteContact(int edit_contact_idx) throws IOException {
        readContactJsonFile("Model/Contacts/Contacts.json");
        contacts.remove(edit_contact_idx);
        writeContactJsonFile("Model/Contacts/Contacts.json",contacts);
    }
}
