import view.ContactView;

import java.util.Scanner;

public class ContactMain {
    public static void main(String[] args) {
        // 처음 생성할 때 스캐너를 갖고 시작하도록 스캐너를
        //생성자 주입방법으로 넣고 시작
        Scanner scanner = new Scanner(System.in);
        ContactView contactView = new ContactView(scanner);
        // 화면 호출
        contactView.run();
    }
}