import java.util.ArrayList;
import java.util.Scanner;

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

    // Run function: prints menu options. continually ask for options until user exits (0)
    static int choice;
    public void run() {
        menu();
        // Exit
        if (choice == 0) {
            return;
        }
        // should i give them the option of student / girlscout?
        // Gets information to add a person
        else if (choice == 1) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a first name: ");
            String first = input.nextLine();
            System.out.println("Enter a last name: ");
            String last = input.nextLine();
            System.out.println("Enter a number: ");
            String num = input.nextLine();
            Person add = new Person(first, last, num);
            addContact(add);
        }

        // Sort by first name then print
        else if (choice == 2) {
            sort(0);
            printContacts();
        }

        // Sort by last name then print
        else if (choice == 3) {
            sort(1);
            printContacts();
        }

        // Sort by number then print
        else if (choice == 4) {
            sort(2);
            printContacts();
        }

        // Lists students

    }

    // Prints menu
    public static void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Menu: \n1. Add Contact\n2. List All Contacts By First Name\n" +
                "3. List All Contacts By Last Name\n4. List All Contacts By Phone Number\n" +
                "5. List All Students\n6. Search By First Name\n7. Search By Last Name\n" +
                "8. Search By Phone Number\n0. Exit");
        choice = input.nextInt();
        input.nextLine();
        return;
    }
}
