package com.main;

import com.mobilePhoneBook.PhoneBook;
import com.userContact.Contact;

import java.util.Scanner;

public class TestMobilePhoneBook {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PhoneBook myPhone = new PhoneBook("090857457484");

    public static void main(String[] args) {
        boolean quit = false;
        smartPhone();
        while (!quit) {
            System.out.print("\nEnter action: (7 to show available actions): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nShutting down...");
                    quit = true;
                }
                case 2 -> myPhone.printContactEntries();
                case 3 -> addContact();
                case 4 -> editContact();
                case 5 -> deleteContact();
                case 6 -> searchContact();
                case 7 -> printInstruction();
            }
        }
    }

    public static void smartPhone() {
        System.out.println("Starting phone...");
    }

    public static void printInstruction() {
        System.out.println("\nAvailable actions: \nPress");
        System.out.println("\t 1 - To quit the application..");
        System.out.println("\t 2 - To print all contacts on the phone book.");
        System.out.println("\t 3 - To add contacts to phone book.");
        System.out.println("\t 4 - To edit contact on phone book.");
        System.out.println("\t 5 - To delete contact from phone book.");
        System.out.println("\t 6 - To search for contact.");
        System.out.println("\t 7 - To print choice option");
    }

    public static Contact createContact(){
        System.out.print("Please enter contact name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Please enter contact number: ");
        String phoneNumber = scanner.nextLine().trim();

        if(addGroup()){
            System.out.print("Please enter category name: ");
            String groupName = scanner.nextLine().trim();
            return Contact.createContact(name, phoneNumber, groupName);
        }else {
            return Contact.createContact(name, phoneNumber, null);
        }
    }

    public static boolean addGroup(){
        System.out.print("Did you want to add contact to a category (e.g families, friends, work)?\n\tPress Y for Yes and any key for No: ");
        char option = scanner.nextLine().charAt(0);
        return option == 'y' || option == 'Y';
    }

    public static void addContact(){
        Contact newContact = createContact();
        if(myPhone.addContactToMobilePhone(newContact)){
            System.out.printf("New contact added: name: %s, phone-number: %s, category: %s", newContact.getContactName(),newContact.getPhoneNumber(), newContact.getGroup());
        }else {
            System.out.printf("Cannot add, %s already exit on phone book", newContact.getContactName());
        }
    }

    public static void editContact(){
        System.out.print("Enter existing contact name: ");
        String name = scanner.nextLine().trim();
        Contact existingContact = myPhone.displayContact(name);
        if(existingContact == null){
            System.out.println("Contact not found");
            return;
        }
        Contact newContact = createContact();
        if(myPhone.editContact(name, newContact)){
            System.out.println("Successfully updated phonebook");
        }else {
            System.out.println("Error updating phonebook");
        }
    }

    public static void deleteContact(){
        System.out.print("Enter existing contact name: ");
        String name = scanner.nextLine().trim();
        Contact existingContact = myPhone.displayContact(name);
        if(existingContact == null){
            System.out.println("Contact not found");
            return;
        }
        if(myPhone.deleteContactList(name)){
            System.out.println("Successfully deleted!");
        }else {
            System.out.println("Error deleting contact");
        }
    }

    public static void searchContact(){
        System.out.print("Enter existing contact name: ");
        String name = scanner.nextLine().trim();
        Contact existingContact = myPhone.displayContact(name);
        if(existingContact == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + existingContact.getContactName() + ", Phone-number: " + existingContact.getPhoneNumber());
    }

}
