package com.example.myapplication;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class contentpro extends AppCompatActivity {
    private RecyclerView recyclerView;
    private imageadapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentpro);
        recyclerView = findViewById(R.id.recyclerViewContacts);
        imageadapter imageadapter = new imageadapter(this);

        // Set the adapter to the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(imageadapter);

        // Fetch contact data using ContactsContract.Contacts
        fetchContacts();
    }

    private void fetchContacts() {
        // Define the URI for the ContactsContract.Contacts
        Uri contactsUri = ContactsContract.Contacts.CONTENT_URI;

        // Define the columns you want to retrieve
        String[] projection = {
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.HAS_PHONE_NUMBER
        };

        // Perform the query
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(contactsUri, projection, null, null, null);

        if (cursor != null) {
            try {
                // Iterate through the cursor to retrieve contact information
                while (cursor.moveToNext()) {
                    long contactId = cursor.getLong(cursor.getColumnIndexOrThrow(ContactsContract.Contacts._ID));
                    String contactName = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                    int hasPhoneNumber = cursor.getInt(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                    // If the contact has a phone number, fetch it
                    if (hasPhoneNumber > 0) {
                        fetchContactPhoneNumber(contactId, contactName);
                    } else {
                        showToast("Contact Name: " + contactName);
                    }
                }
            } finally {
                // Close the cursor to avoid memory leaks
                cursor.close();
            }
        }
    }

    private void fetchContactPhoneNumber(long contactId, String contactName) {
        // Define the URI for the ContactsContract.CommonDataKinds.Phone
        Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        // Define the columns you want to retrieve
        String[] projection = {
                ContactsContract.CommonDataKinds.Phone.NUMBER
        };

        // Specify the selection criteria
        String selection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?";
        String[] selectionArgs = {String.valueOf(contactId)};

        // Perform the query
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(phoneUri, projection, selection, selectionArgs, null);

        if (cursor != null) {
            try {
                // Iterate through the cursor to retrieve phone number information
                while (cursor.moveToNext()) {
                    String phoneNumber = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    showToast("Contact Name: " + contactName + "\nPhone Number: " + phoneNumber);
                }
            } finally {
                // Close the cursor to avoid memory leaks
                cursor.close();
            }
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
