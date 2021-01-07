package com.userContact;


import java.time.LocalDate;

public class Contact {
    private final String phoneNumbers;
    private final String contactName;
    private final String group;
    private final LocalDate entryDate = LocalDate.now();

    public Contact(String contactName, String phoneNumbers, String group) {
        this.contactName = contactName;
        this.phoneNumbers = phoneNumbers;
        this.group = group;
    }

    public static Contact createContact(String name, String phoneNumber, String group){
        return new Contact(name, phoneNumber, group);
    }

    public String getContactName(){
        return contactName;
    }

    public String getPhoneNumber() {
        return phoneNumbers;
    }

    public String getGroup() {
        return group;
    }

    public String viewContactEntry() {
        return "Contact_name: " + contactName + "\nPhone_number: " + phoneNumbers + "\nDate_of_entry: " + entryDate + "\nGroup: " + group;
    }

    @Override
    public String toString() {
        return viewContactEntry();
    }
}
