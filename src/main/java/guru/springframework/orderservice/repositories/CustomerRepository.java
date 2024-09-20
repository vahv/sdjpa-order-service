package guru.springframework.orderservice.repositories;

import guru.springframework.orderservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByCustomerName(String customerName);
}
