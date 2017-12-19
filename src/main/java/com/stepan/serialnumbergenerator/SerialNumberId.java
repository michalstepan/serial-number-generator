package com.stepan.serialnumbergenerator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SerialNumberId implements Serializable{

    @Column
    private int year;

    @Column
    private String sellPlace;

    public SerialNumberId() {
    }

    public SerialNumberId(int year, String sellPlace) {
        this.year = year;
        this.sellPlace = sellPlace;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSellPlace() {
        return sellPlace;
    }

    public void setSellPlace(String sellPlace) {
        this.sellPlace = sellPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerialNumberId that = (SerialNumberId) o;
        return year == that.year &&
                Objects.equals(sellPlace, that.sellPlace);
    }

    @Override
    public int hashCode() {

        return Objects.hash(year, sellPlace);
    }
}
