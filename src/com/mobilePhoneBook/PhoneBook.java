package com.mobilePhoneBook;

import com.userContact.Contact;

import java.util.ArrayList;
import java.util.Arrays;

public class PhoneBook {
    private final ArrayList<Contact> contactEntries;
    private final String myNumber;

    public PhoneBook(String myNumber){
        this.myNumber = myNumber;
        this.contactEntries = new ArrayList<>();
    }

    public int getContactEntryLength() {
        return contactEntries.size();
    }

    public boolean addContactToMobilePhone(Contact contact) {
        if(findContact(contact.getContactName()) >= 0){
            System.out.println("Contact is already on contact list");
            return false;
        }
        contactEntries.add(contact);
        return true;
    }

    private int findContact(String contactName){
        for(int count = 0; count < contactEntries.size(); count++){
            Contact contact = contactEntries.get(count);
            if(contact.getContactName().equals(contactName)){
                return count;
            }
        }
        return -1;
    }


    public void printContactEntries() {
        System.out.println("You have " + contactEntries.size() + " contact list on your mobile phone\n=======================================\n");
        ArrayList<Contact> sorted = sortContactList();
        for (int count = 0; count < sorted.size(); count++) {
            System.out.println((count + 1) + ". " + sorted.get(count) + "\n");
        }
    }

    public boolean deleteContactList(String contactName) {
        int deleteContact = findContact(contactName);
        if(deleteContact < 0){
            System.out.println(contactName + " was not found!");
            return false;
        }
        contactEntries.remove(deleteContact);
        System.out.println(contactName + " was deleted!");
        return true;
    }

    public boolean editContact(String contactName, Contact contact) {
        int position = findContact(contactName);
       if(position < 0){
           System.out.println(contactName + " was not found!");
           return false;
       }
       contactEntries.set(position, contact);
        System.out.println(contactName + " was replaced with " + contact.getContactName());
       return true;
    }

    public Contact displayContact(String contactName){
        int position = findContact(contactName);
        if(position >= 0){
            return contactEntries.get(position);
        }
        return null;
    }


    private String[] contactNameArr() {
        String [] contactNameArray = new String[contactEntries.size()];
        for(int count = 0; count < contactEntries.size(); count++){
            contactNameArray[count] = contactEntries.get(count).getContactName();
        }
        return contactNameArray;
    }


    private String[] sortContactName() {
        String[] contactName = contactNameArr();
         Arrays.sort(contactName);
         return contactName;
    }

    public Contact findContactByName(String contactName) {
        for (Contact contactEntry : contactEntries) {
            if (contactName.equals(contactEntry.getContactName())) {
                return contactEntry;
            }
        }
        return null;
    }


    public ArrayList<Contact> sortContactList(){
        String contactName;
        String[] names = sortContactName();

        for(int counter = 0; counter < contactEntries.size(); counter++){
            contactName = names[counter];
            int position = findContact(contactName);
            Contact contact = findContactByName(contactName);
            Contact newContact = findContactByName(contactEntries.get(counter).getContactName());
                contactEntries.set(counter, contact);
                contactEntries.set(position,newContact);
        }
        return contactEntries;
    }
}
