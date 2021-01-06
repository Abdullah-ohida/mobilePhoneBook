package com.mobilePhoneBook;

import com.userContact.Contact;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PhoneBook {
    private final ArrayList<Contact> contactEntries = new ArrayList<>();

    public int getContactEntryLength() {
        return contactEntries.size();
    }

    private void addContactToMobilePhone(Contact contact) {
        String name = contact.getContactName();
        Contact existing_contact = findContactByName(name);
        if (existing_contact != null) {
            return;
        } else {
            contactEntries.add(contact);
        }
    }

    public void addContactToMobilePhone(Contact... contacts) {
        for (Contact contact : contacts) {
            addContactToMobilePhone(contact);
        }
    }

    public void printContactEntries() {
        StringBuilder output = new StringBuilder();
        for (int count = 0; count < contactEntries.size(); count++) {
           output.append(count + 1).append(". ").append(contactEntries.get(count)).append("\n");
        }
        JOptionPane.showMessageDialog(null, output);
    }


    public void deleteContactList(String contactName) {
        int deleteContact = findContactPositionByName(contactName);
        contactEntries.remove(deleteContact);
    }

    public int findContactPositionByName(String contactName) {
        for (Contact contactEntry : contactEntries) {
            if (contactName.equals(contactEntry.getContactName()))
                return contactEntries.indexOf(contactEntry);
        }
        return -1;
    }

    public Contact findContactByName(String contactName) {
        for (Contact contactEntry : contactEntries) {
            if (contactName.equals(contactEntry.getContactName())) {
                return contactEntry;
            }
        }
        return null;
    }

    public Contact findContactByNumber(String phoneNumber) {
        for (int count = 0; count < contactEntries.size(); count++) {
            for (int counter = 0; counter < contactEntries.get(count).getPhoneNumber().length; counter++) {
                if (phoneNumber.equals(contactEntries.get(counter).getPhoneNumber()[counter])) {
                    return contactEntries.get(counter);
                }
            }
        }
        return null;
    }

    public void editContact(String contactName, Contact contact) {
        Contact existContact = findContactByName(contactName);
        if (contact.getContactName() != null) {
            existContact.setContactName(contact.getContactName());
        }else {
            printContactEntries();
        }
        if (contact.getPhoneNumber() != null) {
            existContact.setPhoneNumber(contact.getPhoneNumber());
        }else {
            printContactEntries();
        }
    }


    public String[] contactNameArr() {
        String [] contactNameArray = new String[contactEntries.size()];
        for(int count = 0; count < contactEntries.size(); count++){
            contactNameArray[count] = contactEntries.get(count).getContactName();
        }
        return contactNameArray;
    }


    public String[] sortContactName() {
        String[] contactName = contactNameArr();
         Arrays.sort(contactName);
         return contactName;
    }

    public void sortContactList(){
        String contactName = "";
        String[] names = sortContactName();
        Contact lastContact = null;

        for(int counter = 0; counter < contactEntries.size(); counter++){
            contactName = names[counter];
            if(counter == 0){
                lastContact = findContactByName(names[names.length - 1]);
            }
            Contact contact = findContactByName(contactName);
            if(contact == null){
                contactEntries.set(counter, lastContact);
            }else {
                contactEntries.set(counter, contact);
            }
        }
    }
}
