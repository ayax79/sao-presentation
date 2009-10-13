package org.yestech.user;

import javax.persistence.Embeddable;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

import java.io.Serializable;

@Embeddable
public class Address implements Serializable {
	
	private String street;
	private String city;

    @Field(store = Store.YES, index = Index.TOKENIZED)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Field(store = Store.YES, index = Index.TOKENIZED)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        //noinspection RedundantIfStatement
        if (street != null ? !street.equals(address.street) : address.street != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
