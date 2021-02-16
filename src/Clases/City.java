package Clases;
// Generated 19-ene-2020 12:17:37 by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * City generated by hbm2java
 */
public class City implements java.io.Serializable {

    private Short cityId;
    private Country country;
    private String city;
    private Date lastUpdate;

    public City() {
    }

    public City(Country country, String city, Date lastUpdate) {
        this.country = country;
        this.city = city;
        this.lastUpdate = lastUpdate;
    }

    public Short getCityId() {
        return this.cityId;
    }

    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}