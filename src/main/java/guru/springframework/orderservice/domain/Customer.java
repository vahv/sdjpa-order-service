package guru.springframework.orderservice.domain;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AttributeOverrides({
        @AttributeOverride(
                name = "address.address",
                column = @Column(name = "address")),
        @AttributeOverride(
                name = "address.city",
                column = @Column(name = "city")),
        @AttributeOverride(
                name = "address.state",
                column = @Column(name = "state")),
        @AttributeOverride(
                name = "address.zipCode",
                column = @Column(name = "zip_code"))
})
public class Customer extends BaseEntity{

    private String customerName;

    @Embedded
    private Address address;

    private String phone;

    private String email;

    @OneToMany(mappedBy = "customer")
    private Set<OrderHeader> orders = new LinkedHashSet<>();

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<OrderHeader> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderHeader> orders) {
        this.orders = orders;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getCustomerName(), customer.getCustomerName()) && Objects.equals(getAddress(), customer.getAddress()) && Objects.equals(getPhone(), customer.getPhone()) && Objects.equals(getEmail(), customer.getEmail());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(getCustomerName());
        result = 31 * result + Objects.hashCode(getAddress());
        result = 31 * result + Objects.hashCode(getPhone());
        result = 31 * result + Objects.hashCode(getEmail());
        return result;
    }
}
