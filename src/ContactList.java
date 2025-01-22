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
        int size = contacts.size();
        // go through contacts
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                // sort by first name
                if (sortBy == 0) {
                    String name1 = contacts.get(i).getFirstName();
                    String name2 = contacts.get(j).getFirstName();
                    if (name1.compareTo(name2) > 0) {
                        swap(name1, name2);
                    }
                }
                // Sort by last name
                else if (sortBy == 1) {
                    String name1 = contacts.get(i).getLastName();
                    String name2 = contacts.get(j).getLastName();
                    if (name1.compareTo(name2) > 0) {
                        swap(name1, name2);
                    }
                }

                // Sort by number
                else if (sortBy == 2) {
                    String num1 = contacts.get(i).getPhoneNumber();
                    String num2 = contacts.get(j).getPhoneNumber();
                    if (num1.compareTo(num2) > 0) {
                        swap(num1, num2);
                    }
                }
            }
        }
    }
    // Swapping the strings / numbers
    public void swap(String one, String two) {
        String temp = one;
        one = two;
        two = temp;
    }

    // Search functions
    // By first name
    public Person searchByFirstName(String firstName) {
        // Go through contacts
        for (int i = 0; i < contacts.size(); i++) {
            String first = contacts.get(i).getFirstName();
            if (first.equals(firstName)) {
                return contacts.get(i);
            }
        }
        return null;
    }
    // By last name
    public Person searchByLastName(String lastName) {
        // Go through contacts
        for (int i = 0; i < contacts.size(); i++) {
            String last = contacts.get(i).getLastName();
            if (last.equals(lastName)) {
                return contacts.get(i);
            }
        }
        return null;
    }
    // By phone number
    public Person searchByPhoneNumber(String phoneNumber) {
        // Go through contacts
        for (int i = 0; i < contacts.size(); i++) {
            String num = contacts.get(i).getPhoneNumber();
            if(num.equals(phoneNumber)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    // Lists students
    public void listStudents() {
        // Go through contacts
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i) instanceof Student) {
                System.out.println(contacts.get(i));
            }
        }
    }

    // run
}
