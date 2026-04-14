package service;

import main.Main;
import vo.Contact;

import java.util.List;

public class ContactService {
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public void create(String name, String phone) {
        Contact contact = new Contact(Main.nextId, name, phone);
        Main.nextId++;
        contactRepository.save(contact);
    }

    public void update(int updateNumber, Contact afterContact) {
    }
    private void delete(){
        List<Contact> list = contactService.findAll
    }
}
