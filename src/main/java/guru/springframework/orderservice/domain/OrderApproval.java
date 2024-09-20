package guru.springframework.orderservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity
public class OrderApproval extends BaseEntity{

    private String approvedBy;

    @OneToOne(mappedBy = "orderApproval")
    private OrderHeader order;

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public OrderHeader getOrder() {
        return order;
    }

    public void setOrder(OrderHeader order) {
        this.order = order;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderApproval that)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(getApprovedBy(), that.getApprovedBy());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(getApprovedBy());
        return result;
    }
}
