//Vì phương thức pay() sẽ khác nhau cho từng loại nhân viên,chung ta nen để nó là abstract
public abstract class StaffMember {
    protected String name;
    protected String address;
    protected String phone;

    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Name:" + name + "\nAddress:" + address + " \nPhone" + phone;
    }

    public abstract double pay();
}
