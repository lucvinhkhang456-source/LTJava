public class Hourly extends Employee {
    private int hoursWorked;

    public Hourly(String name, String address, String phone, String ssn, double rate) {
        super(name, address, phone, ssn, rate);
        this.hoursWorked = 0;
    }
    public void addHours(int moreHours)
    {
        this.hoursWorked +=moreHours;
    }
    @Override
    public double pay()
    {
        double totalPay=payRate*hoursWorked;
        hoursWorked=0;
        return totalPay;
    }
    @Override
    public String toString()
    {
        return super.toString()+"\nHours Worked"+hoursWorked;
    }
}
