package view;


import java.util.Scanner;

public class ContactView {
    private final Scanner sc;

    public ContactView(Scanner sc) {
        this.sc = sc;
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
    }
}
