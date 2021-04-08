import java.util.ArrayList;
import java.util.Date;

public class User {
    private int id;
    private String nume;
    private String adresa;
    private Date dataNasterii;

    private ArrayList<Voucher> vouchere;

    private static int nrUser;

    static{
        nrUser = 0;
    }

    {
        id = ++nrUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Date getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Date dataNasterii) {
        this.dataNasterii = (Date) dataNasterii.clone();
    }

    public ArrayList<Voucher> getVouchere() {
        return vouchere;
    }

    public void setVouchere(ArrayList<Voucher> vouchere) {
        this.vouchere = new ArrayList<>(vouchere);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", dataNasterii=" + dataNasterii +
                '}';
    }


}
