package view;

import service.ContactService;
import vo.Contact;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ContactView {
    private final Scanner sc;
    private final ContactService contactService;

    public ContactView(Scanner sc, ContactService contactService) {
        this.sc = sc;
        this.contactService = contactService;
    }

    public void run() {
        while (true) {
            System.out.println("1.추가  2.목록  3.수정  4.삭제  5.이름의 일부로 검색 -1:종료");
            int cmd = sc.nextInt();
            switch (cmd) {
                case -1:
                    return;
                case 1:
                    create();
                    break;
                case 2:
                    readAll();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                default:
                    System.out.println("잘 못 입력 함.");
            }
        }
    }

    private void search() {
        System.out.println("[ContactView.search()]");
        System.out.println("검색어(이름) : ");
        String keyword = sc.next();
        Map<Long, Contact> result = contactService.search(keyword);
        // 검색결과 출력
        if (result.isEmpty()) {
            System.out.println("검색 결과가 없어요");
        } else {
            for (Long key : result.keySet()) {
                System.out.println(result.get(key));
            }
        }
    }

    private void update() {
        System.out.println("[ContactView.update()]");
        System.out.println("수정할 아이디 : ");
        Long updateId = sc.nextLong();
        System.out.println("수정할 전화번호 : ");
        String updatePhone = sc.next();
        contactService.update(updateId, updatePhone);
    }

    private void delete() {
        System.out.println("[ContactView.delete()]");
        System.out.println("삭제 아이디 : ");
        Long deleteId = sc.nextLong();
        // 서비스로 id 보내기
        contactService.delete(deleteId);
    }

    private void readAll() {
        System.out.println("[ContactView.readAll()]");
        // 맵을 읽어와서 화면 출력
        Map<Long, Contact> store = contactService.findAll();
        // store 비어 있으면 없다고 출력한 후 종료
        if (store.isEmpty()) {
            System.out.println("저장된 자료가 없어요");
            return;
        }
        // 출력
        for (Long key : store.keySet()) {
            System.out.println(store.get(key));
        }
    }

    private void create() {
        System.out.println("[ContactView.create()]");
        // 이름과 나이, 전화번호를 입력받아서
        // 서비스에 전달한다.
        String name;
        int age;
        String phone;
        System.out.println("이름 : ");
        name = sc.next();
        System.out.println("나이 : ");
        age = sc.nextInt();
        System.out.println("전화 : ");
        phone = sc.next();
        // 받은 값들을 service.ContactService.insert() 전달
        contactService.insert(name, age, phone);
    }
}
