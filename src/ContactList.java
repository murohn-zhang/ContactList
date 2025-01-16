import java.util.ArrayList;

public class ContactList {
    // Instance variable
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    // getContacts()
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // addContacts()
    public void addContact(Person new) {
        contacts.add(new);
    }

    // printContacts()
    public void printContacts() {
        for (Person dude : contacts) {
            System.out.println(dude);
        }
    }

    // Sort function
    public void sort(int sortBy) {

    }
}
