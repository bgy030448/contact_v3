package view;

import service.ContactService;
import vo.Contact;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ContactView {
    // 컨텍트 서비스 생성하기
    private ContactService contactService = new ContactService();

    private Scanner sc = new Scanner(System.in);
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

    // 검색기능 만들기
    private void search(){
        System.out.println("검색할 이름의 일부를 입력하세요");
        String searchName = sc.next();
        List<Contact> searchList = contactService.search(searchName);
        // 최종적으로 검색한 결과를 출력
        if (searchList.size() == 0) {
            System.out.println("검색 결과 없음.");
        } else {
            // 출력
            for (Contact contact : searchList) {
                System.out.println(contact);
            }
        }
    }

    // 서비스에게 위임...
    private void readAll() {
        //System.out.println("Read All");
        // 서비스에게 전체 데이터를 요청한다.
        List<Contact> list = contactService.findAll();
        // 위 실행결과 list에는 연락처 목록이 들어온다.
        // list에 목록이 있는지 확인하고 없으면 없다고 출력
        if (list.size() == 0) {
            System.out.println("목록이 비었어요");
            return;
        }

        // 출력
        for(Contact contact : list){
            System.out.println(contact);
        }
    }
    private void create(){
        // 처리 순서
        // 화면에서 이름과 전화번호를 입력받는다.
        // 입력받은 내용을 서비스에 전달한다.
        System.out.println("이름을 입력하세요.");
        String name = sc.next();
        System.out.println("전화번호를 입력하세요.");
        String phone = sc.next();
        contactService.create(name, phone);
    }
    private void update(){
        // 전체 리스트를 보여준다.
        //System.out.println("Update");
        // 1. 전체 리스트를 불러온다.
        List<Contact> list = contactService.findAll();
        // 2. 비어있으면 삭제할 리스트가 없어요. -> 종료
        if(list.size() == 0){
            System.out.println("리스트가 비어 있어요");
            System.out.println("메뉴로 이동합니다.");
            return;
        } else{
            // 3. 비어있지 않으면 목록을 출력한 후 수정할 번호를
            // 입력 받은 후 수정 처리 한다.
            for (Contact contact : list) {
                System.out.println(contact);
            }
            System.out.println("수정할 id를 입력하세요.");
            // 수정 처리
            // 1. 수정할 ID로 해당 정보를 먼저 획득을 해 온다.
            int updateNumber = sc.nextInt();
            Optional<Contact> beforeContact = contactService.findById(updateNumber);
            // 검색 자료가 없으면 빠져나간다.
            if (! beforeContact.isPresent()) {
                System.out.println("해당하는 ID 정보가 없습니다.");
                return;
            }
            // 기존의 이름을 먼저 보여주고... 수정할 이름을 얻는다.
            // 찾은 Optional Contact를 일반 Contact에 옮깁니다.
            Contact afterContact = beforeContact.get();
            // 만약에 그냥 Enter를 눌러서 이름이 비어 있으면 기존 값을 사용
            System.out.println("- 변경 전 : " + beforeContact.get().getName());
            System.out.println("수정할 이름을 입력하세요. (엔터치면 안바뀜)");
            String afterName = sc.next();
            if (! afterName.equals("")) {
                afterContact.setName(afterName);
            }
            // 기존 전화번호를 보여주고.. 수정할 전화번호를 얻어요.
            System.out.println("- 변경 전 : " + beforeContact.get().getPhone());
            System.out.println("수정할 전화번호를 입력하세요. (엔터치면 안바뀜)");
            String afterPhone = sc.next();
            if (! afterPhone.equals("")) {
                afterContact.setPhone(afterPhone);
            }
            // id와 수정할 afterContact를 받아서 서비스로 전달한다.
            contactService.update(updateNumber, afterContact);
        }
    }
    private void delete(){
        // System.out.println("Delete");
        // 1. 전체 리스트를 불러온다.
        List<Contact> list = contactService.findAll();
        // 2. 비어있으면 삭제할 리스트가 없어요. -> 종료
        if(list.size() == 0){
            System.out.println("리스트가 비어 있어요");
            System.out.println("메뉴로 이동합니다.");
            return;
        } else{
            // 3. 비어있지 않으면 목록을 출력한 후 삭제할 번호를
            // 입력 받은 후 삭제 처리 한다.
            for (Contact contact : list) {
                System.out.println(contact);
            }
            System.out.println("삭제할 id를 입력하세요.");
            int deleteNumber = sc.nextInt();
            // 삭제할 번호를 서비스에 전달해서 삭제 요청을 한다.
            contactService.delete(deleteNumber);
        }
    }
}
