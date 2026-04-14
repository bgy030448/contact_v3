package repository;

import state.ContactState;
import vo.Contact;

import java.util.Map;

public class ContactRepository {
    private final ContactState state;

    public ContactRepository(ContactState state) {
        this.state = state;
    }

    public void save(Long id, Contact contact) {
        System.out.println("[ContactRepository.save()]");
        Map<Long, Contact> currentStore = state.getStore();
        currentStore.put(id, contact);
        System.out.println("저장완료");
        state.increaseId();
        System.out.println("id 증가 완료");
    }

    public Map<Long, Contact> findAll() {
        System.out.println("[ContactRepository.findAll()]");
        return state.getStore();
    }
}
