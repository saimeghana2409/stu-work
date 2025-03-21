package com.example.myapplication;

public class ContactData {

    private final String contactName;
    private final String phoneNumber;

    public ContactData(String contactName, String phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
