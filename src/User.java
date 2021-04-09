import java.util.ArrayList;
import java.util.Date;

public class User {
    private int id;
    private String nume;
    private String adresa;
    private Date dataNasterii = new Date();

    private ArrayList<Voucher> vouchere;

    private static int nrUser;

    static{
        nrUser = 0;
    }

    {
        id = ++nrUser;
    }

    User(){

    }

    User(String nume,String adresa){
        this.nume = nume;
        this.adresa = adresa;
    }

    User(String nume,String adresa, Date dataNasterii){
        this.nume = nume;
        this.adresa = adresa;
        this.dataNasterii = dataNasterii;
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
        return  "id=" + id + "\n" +
                ", nume='" + nume + "\n" +
                ", adresa='" + adresa + "\n" +
                ", dataNasterii=" + dataNasterii+"\n";
    }


}
