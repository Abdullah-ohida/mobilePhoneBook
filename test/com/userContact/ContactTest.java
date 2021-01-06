package com.userContact;

import com.contactListCategory.GroupList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    Contact newContact;
    @BeforeEach
    void setUp() {
        newContact = new Contact();
    }

    @AfterEach
    void tearDown() {
        newContact = null;
    }

    @Test
    void testIfPhoneNumberCanBeSet(){
        String[] phoneNumber = {"09075617573"};
        newContact.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, newContact.getPhoneNumber());
    }

    @Test
    void testIfPhoneNumberIsGreaterOrLesserThan11Digit(){
        String[] phoneNumber = {"09075617573"};
        newContact.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, newContact.getPhoneNumber());
    }

    @Test
    void testIfContactNameCanBeSet(){
        String name = "Emma";
        newContact.setContactName(name);
        assertEquals(name, newContact.getContactName());
    }

    @Test
    void testIfGroupCanBesetToContact(){
        GroupList categories = new GroupList();
        categories.addGroup("Family");
        categories.addGroup("Friend");

        String category = "Family";
        newContact.setGroup(category);
        assertEquals(category, newContact.getGroup());
    }

    @Test
    void checkIfNewContactCanBeView(){
        String[] phoneNumber = {"09075617573"};
        String name = "Emma";

        GroupList categories = new GroupList();
        categories.addGroup("Family");
        categories.addGroup("Friend");

        String category = "Family";
        newContact.setGroup(category);

        newContact.setPhoneNumber(phoneNumber);
        newContact.setContactName(name);

        String expected = "Contact_name: " + name + "\nPhone_number1: " + "09075617573" + "\nDate_of_entry: " + LocalDate.now() + "\nGroup: " + "Family";
        String actual = newContact.viewContactEntry();

        assertEquals(expected, actual);
    }

}