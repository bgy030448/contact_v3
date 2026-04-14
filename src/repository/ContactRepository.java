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

    public boolean findById(Long deleteId) {
        System.out.println("[ContactRepository.findById()]");
        return state.getStore().containsKey(deleteId);
    }

    public void deleteById(Long deleteId) {
        System.out.println("[ContactRepository.deleteById()]");
        state.getStore().remove(deleteId);
    }

    public void updateById(Long updateId, String updatePhone) {
        System.out.println("[ContactRepository.updateById()]");
        // 1. 수정할 대상의 연락처를 찾아서
        // 그 안에 있는 전화번호를 수정한다.
        Contact contact = state.getStore().get(updateId);
        //System.out.println(contact);
        // 2. 해당 id에 다시 저장
        contact.setPhone(updatePhone);
        // map은 key가 같으면 수정이 된다.
        state.getStore().put(updateId, contact);
    }
}
