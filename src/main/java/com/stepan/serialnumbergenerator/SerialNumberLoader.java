package com.stepan.serialnumbergenerator;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class SerialNumberLoader {

    @EmbeddedId
    private SerialNumberId id;

    @Column
    private long counter;

    public SerialNumberLoader() {
    }

    public SerialNumberLoader(SerialNumberId id, long counter) {
        this.id = id;
        this.counter = counter;
    }

    public SerialNumberId getId() {
        return id;
    }

    public void setId(SerialNumberId id) {
        this.id = id;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public String generateNext() {
        return getId().getYear() + "/" + getId().getSellPlace() + "/" + ++counter;
    }

    public static SerialNumberLoader generateNew(int year, String sellPlace) {
        return new SerialNumberLoader(new SerialNumberId(year, sellPlace), 0);
    }
}
