public class Invoice {
    private String partNumber;
    private String partDescription;
    private int quanlity;
    private double princePerItem;

    public Invoice(String partNumber, String partDescription, int quanlity, double princePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quanlity = (quanlity > 0) ? quanlity : 0;
        this.princePerItem = (princePerItem > 0.0) ? princePerItem : 0.0;
    }

    public String getpartNumber() {
        return partNumber;
    }

    public void setpartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = (quanlity > 0) ? quanlity : 0;
    }

    public double getprincePerItem() {
        return princePerItem;
    }

    public void setprincePerItem(double princePerItem) {
        this.princePerItem = (princePerItem > 0.0) ? princePerItem : 0.0;
    }

    public double getInvoiceAmount() {
        return quanlity * princePerItem;
    }

    @Override
    public String toString() {
        return String.format("Ma: %-8s | Mo ta: %-25s | So luong: %-5d | Don gia: %-10.2f | Tong tien: %-10.2f",
                partNumber, partDescription, quanlity, princePerItem, getInvoiceAmount());
    }
}
