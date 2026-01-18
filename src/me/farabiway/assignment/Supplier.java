package me.farabiway.assignment.objects;

import java.util.Objects;

public class Supplier {

    private String phone;
    private String address;
    private String email;

    public Supplier(String phone, String address, String email) {
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(phone, supplier.phone) &&
                Objects.equals(address, supplier.address) &&
                Objects.equals(email, supplier.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, address, email);
    }
}
