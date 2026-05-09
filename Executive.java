public class Executive extends Employee {
    private double bonus;

    public Executive(String name, String address, String phone, String ssn, double rate) {
        super(name, address, phone, ssn, rate);
        this.bonus = 0;
    }

    public void adwardBonus(double execBonus) {
        this.bonus = execBonus;
    }

    @Override
    public double pay() {
        double totalPay = super.pay() + bonus;
        bonus = 0; // Sau khi trả lương reset thưởng
        return totalPay;
    }
}
