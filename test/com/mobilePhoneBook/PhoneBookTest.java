package com.mobilePhoneBook;

import com.userContact.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    PhoneBook myPhone;

    @BeforeEach
    void setUp() {
        myPhone = new PhoneBook("081 875 0474 265");
    }

    @AfterEach
    void tearDown() {
        myPhone = null;
    }
    @Test
    void checkTheLengthOfContactEntry(){
        assertEquals(0,myPhone.getContactEntryLength());
    }

    @Test
    void testIfContactCanBeAddToPhoneBook(){
        Contact myContact = Contact.createContact("Abdullah", "08424524511", null);
        myPhone.addContactToMobilePhone(myContact);

        assertEquals(1,myPhone.getContactEntryLength());
    }

    @Test
    void testIfContactEntriesCanBePrint(){
        Contact myContact = Contact.createContact("Abdullah", "08424524511", null);
        myPhone.addContactToMobilePhone(myContact);

        myPhone.printContactEntries();
        assertEquals(1,myPhone.getContactEntryLength());
    }
    @Test
    void testIfContactCanDeleteOnContactList(){
        Contact myContact = Contact.createContact("Abdullah", "08424524511", null);
        myPhone.addContactToMobilePhone(myContact);

        myPhone.deleteContactList("Abdullah");
        myPhone.printContactEntries();

        assertEquals(0,myPhone.getContactEntryLength());
    }

    @Test
    void testIfContactEntriesCanBeFindWithName(){
        Contact myContact = Contact.createContact("Abdullah", "08424524511", null);
        myPhone.addContactToMobilePhone(myContact);

        Contact contact = myPhone.displayContact("Abdullah");
        assertEquals(myContact, contact);
    }


    @Test
    void checkIfContactNameCanBeChange(){
        Contact myContact = Contact.createContact("Abdullah", "08424524511", null);
        Contact contact = Contact.createContact("Wisdom", "09085632456", "Friends");

        myPhone.addContactToMobilePhone(myContact);
        myPhone.addContactToMobilePhone(contact);

        myPhone.editContact(myContact.getContactName(), contact);

        assertEquals(contact.getContactName(), "Wisdom");
    }

    @Test
    void checkIfContactNameCanBeCollectFromPhoneBook(){
        Contact contact = Contact.createContact("Abdullah", "09085632456", "Friends");
        Contact myContact = Contact.createContact("Yolo", "084285524511", null);
        Contact DoContact = Contact.createContact("Wisdom", "0908563852456", "Friends");
        Contact newContact = Contact.createContact("Abdul", "08423r54524511", null);

        myPhone.addContactToMobilePhone(contact);
        myPhone.addContactToMobilePhone(myContact);
        myPhone.addContactToMobilePhone(DoContact);
        myPhone.addContactToMobilePhone(newContact);

        myPhone.sortContactList();
        myPhone.printContactEntries();

        assertEquals(4, myPhone.getContactEntryLength());
    }
}