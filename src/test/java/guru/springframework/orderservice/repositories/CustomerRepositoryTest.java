package guru.springframework.orderservice.repositories;

import guru.springframework.orderservice.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testFindCustomerByName() {
        Customer customer = new Customer();
        customer.setCustomerName("NEW CUSTOMER");

        customerRepository.save(customer);

        Customer fetchedCustomer =
                customerRepository.findCustomerByCustomerNameIgnoreCase(customer.getCustomerName())
                        .get();


        assertNotNull(fetchedCustomer);
        assertNotNull(fetchedCustomer.getId());
        assertEquals(fetchedCustomer.getCustomerName(), customer.getCustomerName());
    }

    @Test
    void testSaveCustomer() {

        Customer customer = new Customer();
        customer.setCustomerName("NEW CUSTOMER");

        Customer savedCustomer = customerRepository.save(customer);

        assertNotNull(savedCustomer);
        assertNotNull(savedCustomer.getId());
        assertTrue(savedCustomer.getId() > 0);
    }
}
