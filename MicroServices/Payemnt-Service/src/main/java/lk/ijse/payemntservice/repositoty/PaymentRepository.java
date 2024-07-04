package lk.ijse.payemntservice.repositoty;

import lk.ijse.payemntservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/4/2024
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
