package com.main;

import com.contactListCategory.GroupList;
import com.mobilePhoneBook.PhoneBook;
import com.userContact.Contact;

import javax.swing.*;
import java.util.Scanner;

public class TestMobilePhoneBook {
    private static Scanner scanner = new Scanner(System.in);
    private static PhoneBook myPhone = new PhoneBook();
    private static Contact newContact = new Contact();
    private static GroupList groups = new GroupList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        ;
        while(!quit){
            String option = printInstruction();
            choice = Integer.parseInt(option);

            switch (choice){
                case 0 -> printInstruction();
                case 1 -> myPhone.printContactEntries();
                case 2 -> addContact();
                case 3 -> editContact();
                case 4 -> deleteContact();
                case 5 -> searchContactWithName();
                case 6 -> searchContactWithNumber();
                case 7 -> quit = true;
            }
        }
    }

    public static String printInstruction(){
        return JOptionPane.showInputDialog( "\nPress\n\t0 - To print choice option." +
                "\n\t1 - To print all contacts on the phone book.\n\t2 - To add contacts to phone book." +
                "\n\t3 - To edit contact on phone book.\n\t4 - To delete contact from phone book." +
                "\n\t5 - To search for contact using contact name.\n\t5 - To search for contact using contact number." +
                "\n\t6 - To quit the application.\nEnter your choice: ");

    }

    public static void addContact(){
        String contactName = JOptionPane.showInputDialog("Please enter contact name: ");
        String contactNumber = JOptionPane.showInputDialog("Please enter contact number\n\t(NOTE: you can add more than one number with a comma after it. (e.g: 08124524511, 09076532421) : ");

        newContact.setContactName(contactName);
        newContact.setPhoneNumber(new String[]{contactNumber});

        if(addGroup()){
            String groupName = JOptionPane.showInputDialog("Please enter category name: ");
            groups.addGroup(groupName);
            newContact.setGroup(groupName);
        }

        myPhone.addContactToMobilePhone(newContact);
    }

    public static boolean addGroup(){
        String option = JOptionPane.showInputDialog("Did you want to add contact to a category (e.g families, friends, work)?\n\tPress Y for Yes and any key for No: ");
        if(option.equals("Y")){
            return true;
        }else
            return false;
    }

    public static void editContact(){
        String currentName = JOptionPane.showInputDialog("Please enter current contact name: ");

        String contactName = JOptionPane.showInputDialog("Please enter contact name: ");
        String ContactNumber = JOptionPane.showInputDialog("Please enter contact number\n\t(NOTE: you can add more than one number with a comma after it. (e.g: 08124524511, 09076532421) : ");

        newContact.setContactName(contactName);
        newContact.setPhoneNumber(new String[]{ContactNumber});

        if(addGroup()){
            String groupName = JOptionPane.showInputDialog("Please enter category name: ");
            groups.addGroup(groupName);
            newContact.setGroup(groupName);
        }

        myPhone.editContact(currentName, newContact);

    }

    public static void deleteContact(){
        String contactName = JOptionPane.showInputDialog("Please enter contact name: ");
        if(myPhone.findContactPositionByName(contactName) >= 0){
            myPhone.deleteContactList(contactName);
        }else {
            myPhone.printContactEntries();
        }

    }

    public static void searchContactWithName(){
        String contactName = JOptionPane.showInputDialog("Please enter contact name: ");
        if(myPhone.findContactByName(contactName) == null){
            JOptionPane.showMessageDialog(null, contactName + " is not found on phone book!");
        }else {
            myPhone.findContactByName(contactName);
        }

    }

    public static void searchContactWithNumber(){
        String contactNumber = JOptionPane.showInputDialog("Please enter contact number: ");
        if(myPhone.findContactByNumber(contactNumber) == null){
            JOptionPane.showMessageDialog(null, contactNumber + " is not found on phone book!");
        }else {
            myPhone.findContactByNumber(contactNumber);
        }
    }



}
