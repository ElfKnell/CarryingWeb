package ua.carrying.dao.entities;

public class UserExpanded {

    private  long id;
    private long id_customer;
    private String adress;
    /*адреси в соц. мережах*/
    private String society;
    /*тривалість активності на сайті*/
    private String time_loyality;
    private int raiting;
    /*короткий опис про себе*/
    private String cv;

    public UserExpanded() {
    }

    public UserExpanded(long id, long id_customer, String adress, String telephone,
                        String society, String time_loyality, int raiting, String cv) {
        this.id = id;
        this.id_customer = id_customer;
        this.adress = adress;
        this.society = society;
        this.time_loyality = time_loyality;
        this.raiting = raiting;
        this.cv = cv;
    }

    public long getId_customer() {
        return id_customer;
    }

    public void setId_customer(long id_customer) {
        this.id_customer = id_customer;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getTime_loyality() {
        return time_loyality;
    }

    public void setTime_loyality(String time_loyality) {
        this.time_loyality = time_loyality;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserExpanded{" +
                "id=" + id +
                ", id_customer=" + id_customer +
                ", adress='" + adress + '\'' +
                ", society='" + society + '\'' +
                ", time_loyality='" + time_loyality + '\'' +
                ", raiting=" + raiting +
                ", cv='" + cv + '\'' +
                '}';
    }
}
