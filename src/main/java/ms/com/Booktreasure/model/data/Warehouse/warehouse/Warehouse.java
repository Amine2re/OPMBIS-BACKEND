package ms.com.Booktreasure.model.data.Warehouse.warehouse;

import ms.com.Booktreasure.model.data.Warehouse.manager.WManager;
import ms.com.Booktreasure.model.data.localization.City;

import javax.persistence.*;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idWarehouse;

    @Lob
    private String name;

    @ManyToOne
    @JoinColumn(name="id")
    private City city;
    
    @Lob
    private String address;

    private String postalCode;
    
    private String fax;
    
    private String phone;

    @ManyToOne
    @JoinColumn(name="idMan" ,referencedColumnName = "idManager")
    private WManager manager;

    public Warehouse(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }


    public Warehouse() {
    }

    public long getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(long idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public WManager getManager() {
        return manager;
    }

    public void setManager(WManager manager) {
        this.manager = manager;
    }
}
