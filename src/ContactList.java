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
    public void addContact(Person added) {
        contacts.add(added);
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
        Scanner input = new Scanner(System.in);
        menu();
        // Exit
        if (choice == 0) {
            return;
        }
        // Gets information to add a person
        else if (choice == 1) {
            String first = null;
            String last = null;
            String num = null;
            System.out.println("Select a type of contact to add:\n" +
                    "1. Student\n" +
                    "2. Girl Scout\n");
            int select = input.nextInt();
            input.nextLine();
            // Adds a student
            if (select == 1) {
                personInfo(first, last, num);
                System.out.println("Grade:");
                int grade = input.nextInt();
                input.nextLine();
                Student add = new Student (first, last, num, grade);
                addContact(add);
            }
            // Adds a girl scout
            else if (select == 2) {
                personInfo(first, last, num);
                System.out.println("Cookies sold:");
                int cookies = input.nextInt();
                input.nextLine();
                GirlScout add = new GirlScout (first, last, num, cookies);
                addContact(add);
            }

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
        else if (choice == 5) {
            listStudents();
        }

        // Search by first name
        else if (choice == 6) {
            System.out.println("Enter a first name: ");
            String first = input.nextLine();
            Person finder = searchByFirstName(first);
            System.out.println(finder);
        }

        // Search by last name
        else if (choice == 7) {
            System.out.println("Enter a last name: ");
            String last = input.nextLine();
            Person finder = searchByLastName(last);
            System.out.println(finder);
        }

        // Search by number
        else if (choice == 8) {
            System.out.println("Enter a phone number: ");
            String num = input.nextLine();
            Person finder = searchByPhoneNumber(num);
            System.out.println(finder);
        }

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

    // Get general person info
    public static void personInfo(String first, String last, String num) {
        Scanner input = new Scanner(System.in);
        // Get first name
        System.out.println("First Name: ");
        first = input.nextLine();
        // Get last name
        System.out.println("Last Name: ");
        last = input.nextLine();
        // Get phone number
        System.out.println("Phone Number: ");
        num = input.nextLine();
    }
}