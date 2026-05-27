public class Employee extends StaffMember {
    protected String socialSecurityNumber;
    protected double payRate;

    public Employee(String name, String address, String phone, String ssn, double rate) {
        super(name, address, phone);
        this.socialSecurityNumber = ssn;
        this.payRate = rate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSSN" + socialSecurityNumber;
    }

    @Override

    public double pay() {
        return payRate;
    }
}
