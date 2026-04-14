package vo;

public class Contact {
    private int id;
    private String name;
    private String phone;

    public Contact(int id, String name, String phone){
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString(){
        return "[" + id + "]" + name + phone;
    }
}
