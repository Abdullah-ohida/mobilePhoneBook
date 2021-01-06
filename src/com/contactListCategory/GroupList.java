package com.contactListCategory;

import java.util.ArrayList;

public class GroupList {
    private static final ArrayList<String> categories = new ArrayList<>();

    public static ArrayList<String> getCategories() {
        return categories;
    }

    public int groupListLength(){
        return categories.size();
    }

    public void addGroup(String name){
        if(categories.size() > 0){
           if(!exit(name)){
               categories.add(name);
           }
        }else {
            categories.add(name);
        }
    }

    public boolean exit(String name){
        for(String groupName : categories) {
            if (name.equals(groupName)) {
                return true;
            }
        }
        return false;
    }
}
