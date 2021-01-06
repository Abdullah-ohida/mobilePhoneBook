package com.contactListCategory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupListTest {
    GroupList categories;
    @BeforeEach
    void setUp() {
        categories = new GroupList();
    }

    @AfterEach
    void tearDown() {
        categories = null;
    }

    @Test
    void checkIfLengthCanBeCollected(){
        assertEquals(0, categories.groupListLength());
    }

    @Test
    void checkIfGroupCanBeAddedToGroupList(){
        categories.addGroup("Family");
        categories.addGroup("Friend");

        assertEquals(2, categories.groupListLength());
    }

    @Test
    void checkIfGroupExitMoreThanOnceOnGroupList(){
        String name = "family";
        categories.addGroup(name);
        categories.addGroup(name);

        assertTrue(categories.exit(name));
    }
}