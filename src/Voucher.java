import java.util.Date;

public class Voucher {
    private final int id;
    private int discount;
    private Date dataExpirare;
    private static int nrVoucher;

    static{
        nrVoucher = 0;
    }

    {
        id = ++nrVoucher;
    }

    public int getId() {
        return id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(Date dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    public static int getNrVoucher() {
        return nrVoucher;
    }

    public static void setNrVoucher(int nrVoucher) {
        Voucher.nrVoucher = nrVoucher;
    }

}
