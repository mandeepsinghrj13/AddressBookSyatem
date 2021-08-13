package com.bridgelabz;

import com.brigdelabz.service.AddressBookService;
import com.brigdelabz.service.AddressBookServiceInterface;
import com.brigdelabz.service.PersonService;
import com.brigdelabz.service.PersonServiceInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * We are storing multiple address book
 * each address book contains multiple person information
 * @author mandeep
 */
public class AddressBookSystem {
    static Scanner scanner = new Scanner(System.in);

    /**
     * main class
     * @param args using hashmap in main function
     */
    public static void main(String[] args) {
        HashMap<String, ArrayList<Person>> addressBook = new HashMap<String, ArrayList<Person>>();
        AddressBookServiceInterface addressBookServiceInterface = new AddressBookService();
        PersonServiceInterface personServiceInterface = new PersonService();
        boolean flag = true;
        while (flag) {
            System.out.println("Press 1 to Create new Address book\nPress 2 to edit address books\nPress 3 to view all the address books names."+
                    "\nPress 4 to view all the person in particular city or state.\nPress 5 to Exit");
            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    ArrayList<Person> personArrayList = new ArrayList<Person>();
                    System.out.println("Enter a company/address book name : ");
                    String companyName = scanner.next();
                    addressBookServiceInterface.addAddressBook(addressBook, companyName, personArrayList);
                    System.out.println("");
                    break;
                case 2:
                    ArrayList<Person> personArrayList1 = new ArrayList<Person>();
                    System.out.println("Enter a company/address book name : ");
                    String companyName1 = scanner.next();
                    addressBookServiceInterface.editAddressBook(addressBook, companyName1, personArrayList1);
                    break;
                case 3:
                    addressBookServiceInterface.viewAddressBook(addressBook);
                    break;
                case 4:
                    addressBookServiceInterface.searchPersonByCityOrState(addressBook);
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}
