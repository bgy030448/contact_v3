package service;

import repository.ContactRepository;
import state.ContactState;
import vo.Contact;

import java.util.Map;

public class ContactService {
    private final ContactRepository repository;
    private final ContactState state;

    public ContactService(ContactRepository repository, ContactState state) {
        this.repository = repository;
        this.state = state;
    }

    public void insert(String name, int age, String phone) {
        System.out.println("[ContactService.insert()]");
        // Contact를 받은 데이터를 갖고 만들어요.
        Long id = state.getNextId();
        Contact contact = new Contact(id, name, age, phone);
        System.out.println(contact);
        // repository.ContactRepository.save() 를 호출해서
        // store에 저장
        repository.save(id, contact);
        // 출력
        System.out.println("저장된 거 출력");
        Map<Long, Contact> currentStore = state.getStore();
        for (Long key : currentStore.keySet()) {
            System.out.println(currentStore.get(key));
        }
    }
}
