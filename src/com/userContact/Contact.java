package com.userContact;

import com.contactListCategory.GroupList;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contact {
    private String[] phoneNumbers;
    private String contactName;
    private String group;

    private final LocalDate entryDate = LocalDate.now();

    public String[] getPhoneNumber() {
        return phoneNumbers;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String groupName) {
       ArrayList<String> groups = GroupList.getCategories();
       for(String group : groups){
            if(groupName.equals(group)){
                this.group = group;
            }
       }
    }

    public void setPhoneNumber(String[] phoneNumbers) {
        for(String phoneNumber : phoneNumbers) {
            if (phoneNumber.length() == 11) {
                if (phoneNumber.charAt(0) == '0') {
                    this.phoneNumbers = phoneNumbers;
                }
            }
        }
    }


    public void setContactName(String name) {
        if(name.length() >= 2 && name.length() <= 15){
            contactName = name;
        }
    }

    public String printContactNumber() {
        StringBuilder phoneNumber = new StringBuilder();
        for(int count = 0; count < phoneNumbers.length; count++){
            phoneNumber.append("\nPhone_number").append(count + 1).append(": ").append(phoneNumbers[count]);
        }
        return phoneNumber.toString();
    }

    public String getContactName() {
        return contactName;
    }

    public String viewContactEntry() {
        return "Contact_name: " + contactName + printContactNumber() + "\nDate_of_entry: " + entryDate + "\nGroup: " + group;
    }

    @Override
    public String toString() {
        return viewContactEntry();
    }
}
