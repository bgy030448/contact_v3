package view;


import service.ContactService;

import java.util.Scanner;

public class ContactView {
    private final Scanner sc;
    private final ContactService contactService;
    public ContactView(Scanner sc, ContactService contactService) {
        this.sc = sc;
        this.contactService = contactService;
    }

    public void run(){
        while (true){
            System.out.println("1.추가  2.목록  3.수정  4.삭제  5.이름의 일부로 검색 -1:종료");
            int cmd = sc.nextInt();
            switch (cmd){
                case -1 :
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
        System.out.println("[ContactView.search]");
    }

    private void delete() {
        System.out.println("[ContactView.delete()]");
    }

    private void update() {
        System.out.println("[ContactView.update()]");
    }

    private void readAll() {
        System.out.println("[ContactView.readAll()]");
    }

    private void create(){
        System.out.println("[ContactView.create()]");
        // 이름과 나이, 전화번호를 입력 받아서
        //서비스에 전달한다.
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
