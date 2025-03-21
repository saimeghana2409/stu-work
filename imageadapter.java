package com.example.myapplication;// ContactAdapter.java

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class imageadapter extends RecyclerView.Adapter<imageadapter.ContactViewHolder> {

    private final Context context;
    private final List<ContactData> contactList;

    public imageadapter(Context context) {
        this.context = context;
        this.contactList = new ArrayList<>();
    }


    public void addContact(ContactData contactData) {
        contactList.add(contactData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        ContactData contactData = contactList.get(position);
        holder.bind(contactData);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {

        private final TextView contactNameTextView;
        private final TextView phoneNumberTextView;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            contactNameTextView = itemView.findViewById(R.id.textContactName);
            phoneNumberTextView = itemView.findViewById(R.id.textPhoneNumber);
        }

        public void bind(ContactData contactData) {
            contactNameTextView.setText(contactData.getContactName());
            phoneNumberTextView.setText(contactData.getPhoneNumber());
        }

    }
}
