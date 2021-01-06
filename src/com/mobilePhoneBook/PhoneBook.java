package com.mobilePhoneBook;

import com.userContact.Contact;

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
        System.out.println("You have " + contactEntries.size() + " contact list on your mobile phone\n=======================================");
        for (int count = 0; count < contactEntries.size(); count++) {
            System.out.println((count + 1) + ". " + contactEntries.get(count) + "\n");
        }
    }

    public void removeContactList(int position) {
        contactEntries.remove(position);
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

    public void modifyContact(String contactName, Contact contact) {
        Contact existContact = findContactByName(contactName);
        if (contact.getContactName() != null) {
            existContact.setContactName(contact.getContactName());
        }
        if (contact.getPhoneNumber() != null) {
            existContact.setPhoneNumber(contact.getPhoneNumber());
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
