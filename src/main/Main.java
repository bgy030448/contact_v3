package main;

import view.ContactView;
import vo.Contact;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Contact> contactList = new ArrayList<>();
    public static int nextId = 1;

    public static void main(String[] args) {
        ContactView contactView = new ContactView();
        contactView.run();
    }
}
