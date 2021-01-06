package com.mobilePhoneBook;

import com.contactListCategory.GroupList;
import com.userContact.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    PhoneBook myPhone;

    @BeforeEach
    void setUp() {
        myPhone = new PhoneBook();
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
        Contact myContact = new Contact();
        myContact.setContactName("Abdullah");
        myContact.setPhoneNumber(new String[]{"08424524511", "09075617573"});

        Contact contact = new Contact();
        contact.setContactName("Ramon");
        contact.setPhoneNumber(new String[]{"08126524511"});

        Contact anotherContact = new Contact();
        anotherContact.setContactName("Wow");
        anotherContact.setPhoneNumber(new String[]{"08124574511"});

        myPhone.addContactToMobilePhone(myContact);
        myPhone.addContactToMobilePhone(contact);
        myPhone.addContactToMobilePhone(anotherContact);

        myPhone.printContactEntries();
        assertEquals(3,myPhone.getContactEntryLength());
    }

    @Test
    void testIfMultipleContactCanBeAddToPhoneBook() {
        Contact myContact = new Contact();
        myContact.setContactName("Abdullah");
        myContact.setPhoneNumber(new String[]{"08124524511"});

        Contact anotherContact = new Contact();
        anotherContact.setContactName("Ramon");
        anotherContact.setPhoneNumber(new String[]{"08124524511"});

        Contact contact = new Contact();
        contact.setContactName("Ramon");
        contact.setPhoneNumber(new String[]{"08124524511"});



        myPhone.addContactToMobilePhone(myContact, anotherContact, contact);
        myPhone.printContactEntries();


        assertEquals(2,myPhone.getContactEntryLength());
    }
    @Test
    void testIfContactEntriesCanBePrint(){
        Contact myContact = new Contact();
        myContact.setContactName("Abdullah");
        myContact.setPhoneNumber(new String[]{"08124524511"});

        Contact contact = new Contact();
        contact.setContactName("yusuf");
        contact.setPhoneNumber(new String[]{"08124524511"});

        myPhone.addContactToMobilePhone(myContact, contact);

        myPhone.printContactEntries();
        assertEquals(2,myPhone.getContactEntryLength());
    }

    @Test
    void checkIfContactListCanBeRemoveFromContactEntries(){
        Contact contact = new Contact();
        contact.setContactName("yusuf");
        contact.setPhoneNumber(new String[]{"08124524511"});

        Contact myContact = new Contact();
        myContact.setContactName("Abdullah");
        myContact.setPhoneNumber(new String[]{"08124524511"});


        myPhone.addContactToMobilePhone(myContact, contact);

        myPhone.deleteContactList("yusuf");

        assertEquals(1,myPhone.getContactEntryLength());
    }

    @Test
    void testIfContactEntriesCanBeFindByName(){

        Contact n_contact = new Contact();
        n_contact.setContactName("yusuf");
        n_contact.setPhoneNumber(new String[]{"08124524511"});

        Contact contact = new Contact();
        contact.setContactName("Abdullah");
        contact.setPhoneNumber(new String[]{"08124524511"});

        myPhone.addContactToMobilePhone(contact, n_contact);
        Contact actual = myPhone.findContactByName(contact.getContactName());
        assertEquals(contact, actual);
    }

    @Test
    void testIfContactEntriesCanBeFindByPhoneNumber(){
        Contact n_contact = new Contact();
        n_contact.setContactName("yusuf");
        n_contact.setPhoneNumber(new String[]{"08123524511", "09075617573"});

        Contact contact = new Contact();
        contact.setContactName("Abdullah");
        contact.setPhoneNumber(new String[]{"08124524511"});

        myPhone.addContactToMobilePhone(contact, n_contact);

        Contact actual = myPhone.findContactByNumber("08124524511");
        assertEquals(contact, actual);
    }

    @Test
    void checkIfContactNameCanBeChange(){
        Contact n_contact = new Contact();
        n_contact.setContactName("Ramon");
        n_contact.setPhoneNumber(new String[]{"08124529511"});

        Contact contact = new Contact();
        contact.setContactName("Abdullah");
        contact.setPhoneNumber(new String[]{"08124564511"});

        Contact anotherContact = new Contact();
        anotherContact.setContactName("Frank");
        anotherContact.setPhoneNumber(new String[]{"08154524511", "09075615420", "09075634221"});


        myPhone.addContactToMobilePhone(n_contact, contact);

        myPhone.editContact(contact.getContactName(), anotherContact);
        myPhone.printContactEntries();
        assertEquals(contact.getContactName(), anotherContact.getContactName());
    }


    @Test
    void checkIfContactNameCanBeCollectFromPhoneBook(){
        Contact myContact = new Contact();
        myContact.setContactName("Abdullah");
        myContact.setPhoneNumber(new String[]{"09075617573"});

        Contact anotherContact = new Contact();
        anotherContact.setContactName("Wow");
        anotherContact.setPhoneNumber(new String[]{"08124524511"});

        Contact contact = new Contact();
        contact.setContactName("Ramon");
        contact.setPhoneNumber(new String[]{"08124524511"});
        GroupList groups = new GroupList();
        groups.addGroup("Families");

        contact.setGroup("Families");

        myPhone.addContactToMobilePhone(myContact, anotherContact, contact);
        myPhone.printContactEntries();
        String[] actual = myPhone.contactNameArr();

        assertEquals((Arrays.toString(new String[]{"Abdullah", "Wow", "Ramon"})), Arrays.toString(actual));
    }


    @Test
    void testIfContactNameCanBeSorted(){
        Contact myContact = new Contact();
        myContact.setContactName("Abdullah");
        myContact.setPhoneNumber(new String[]{"09075617573"});

        Contact anotherContact = new Contact();
        anotherContact.setContactName("Wow");
        anotherContact.setPhoneNumber(new String[]{"08124524511"});

        Contact contact = new Contact();
        contact.setContactName("Ramon");
        contact.setPhoneNumber(new String[]{"08124524511"});

        myPhone.addContactToMobilePhone(myContact, anotherContact, contact);
        String[] actual = myPhone.sortContactName();

        assertEquals((Arrays.toString(new String[]{"Abdullah", "Ramon", "Wow"})), Arrays.toString(actual));
    }

    @Test
    void checkIfContactListCanBeSorted(){
        Contact myContact = new Contact();
        myContact.setContactName("Abdullah");
        myContact.setPhoneNumber(new String[]{"09075617573"});

        Contact anotherContact = new Contact();
        anotherContact.setContactName("Wow");
        anotherContact.setPhoneNumber(new String[]{"08124524511"});

        Contact contact = new Contact();
        contact.setContactName("Ramon");
        contact.setPhoneNumber(new String[]{"08124524511"});

        Contact bad = new Contact();
        bad.setContactName("Fam");
        bad.setPhoneNumber(new String[]{"08124524511", "09076532421"});

        Contact rank = new Contact();
        rank.setContactName("Rema");
        rank.setPhoneNumber(new String[]{"08124544511", "09076322421"});

        myPhone.addContactToMobilePhone(myContact, anotherContact, contact, bad, rank);

        String[] actual = myPhone.sortContactName();
        myPhone.sortContactList();

        myPhone.printContactEntries();

        assertEquals((Arrays.toString(new String[]{"Abdullah", "Fam", "Ramon", "Rema", "Wow"})), Arrays.toString(actual));
    }
}