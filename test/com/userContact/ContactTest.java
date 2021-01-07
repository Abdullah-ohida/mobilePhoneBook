package com.userContact;

import com.contactListCategory.GroupList;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {



    @Test
    void testIfPhoneNumberCanBeSet(){
        Contact newContact = new Contact("Abdul", "09086533", null);
        assertEquals("09086533", newContact.getPhoneNumber());
    }

    @Test
    void testIfContactNameCanBeSet(){
        Contact newContact = new Contact("Abdul", "09086533", null);
        assertEquals("Abdul", newContact.getContactName());
    }

    @Test
    void testIfGroupCanBesetToContact(){
        GroupList categories = new GroupList();
        categories.addGroup("Family");
        categories.addGroup("Friend");

        String category = "Family";
        Contact newContact = new Contact("Abdul", "09086533", category);
        assertEquals(category, newContact.getGroup());
    }

    @Test
    void checkIfNewContactCanBeView(){
        GroupList categories = new GroupList();
        categories.addGroup("Family");
        categories.addGroup("Friend");

        String category = "Family";
        Contact newContact = new Contact("Abdul", "09086533", category);

        String expected = "Contact_name: " + "Abdul" + "\nPhone_number: " + "09086533" + "\nDate_of_entry: " + LocalDate.now() + "\nGroup: " + "Family";
        String actual = newContact.viewContactEntry();

        assertEquals(expected, actual);
    }

}