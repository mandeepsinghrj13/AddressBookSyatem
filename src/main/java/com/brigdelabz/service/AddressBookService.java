package com.brigdelabz.service;

import com.bridgelabz.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookService implements AddressBookServiceInterface {
    Scanner scanner = new Scanner(System.in);
    PersonServiceInterface personServiceInterface = new PersonService();

    /**
     *
     * @param addressBook contains address book of all company
     * @param companyName contains the address book 'key'
     * @param personArrayList contains all the person information in particular company/address book
     */
    @Override
    public void addAddressBook(HashMap<String, ArrayList<Person>> addressBook, String companyName, ArrayList<Person> personArrayList) {
        // validating to add new address book
        if (!addressBook.containsKey(companyName)) {
            boolean flag = true;
            while (flag) {
                System.out.println("Press 1 to Add person information in " + companyName.toUpperCase() + "\nPress 2 to Exit from " + companyName.toUpperCase() + " address book" );
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        personArrayList = personServiceInterface.addPersonInfo(personArrayList);
                        addressBook.put(companyName, personArrayList);
                        break;
                    default:
                        flag = false;
                        System.out.println("Exit from " + companyName + " address book.");
                }
            }
        } else {
            System.out.println(companyName + " address book already present.");
        }
    }

    /**
     * Editing the address book like
     * 1. add person information into existing address book
     * 2. edit person information from existing address book
     * 3. delete person information from existing address book
     * 4. view all the person information from existing address book
     * @param addressBook contains address book of all company
     * @param companyName contains the address book 'key'
     * @param personArrayList contains all the person information in particular company/address book
     */
    @Override
    public void editAddressBook(HashMap<String, ArrayList<Person>> addressBook, String companyName, ArrayList<Person> personArrayList) {
        try {
            if (addressBook.containsKey(companyName)) {
                personArrayList = (ArrayList<Person>) addressBook.get(companyName);
                boolean flag = true;
                while (flag) {
                    Person person = new Person();
                    System.out.println("Press 1 to Add contact in " + companyName + "\nPress 2 to Edit Contact from " + companyName + "\nPress 3 to Delete contact from " + companyName + "\nPress 4 to View contact from " + companyName + "\nPress 5 to Exit " + companyName);
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            personArrayList = personServiceInterface.addPersonInfo(personArrayList);
                            break;
                        case 2:
                            personArrayList = personServiceInterface.editPersonInfo(personArrayList);
                            break;
                        case 3:
                            personArrayList = personServiceInterface.deletePersonInfo(personArrayList);
                            break;
                        case 4:
                            personServiceInterface.viewPersonInfo(personArrayList);
                            break;
                        default:
                            flag = false;
                            addressBook.put(companyName, personArrayList);
                            System.out.println("Exit ");
                    }
                }
                // adding contact list to the dictionary (Address book)
                addressBook.put(companyName, personArrayList);
            } else {
                System.out.println("No such address book");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Shows all existing address books name
     * @param addressBook contains all the company/address book
     */
    @Override
    public void viewAddressBook(HashMap<String, ArrayList<Person>> addressBook) {
        if (!addressBook.isEmpty()) {
            System.out.println("Address book names : ");
            for (String key : addressBook.keySet()) {
                System.out.print(key);
            }
            System.out.println();
        } else {
            System.out.println("Address book is empty.");
        }
    }
}
