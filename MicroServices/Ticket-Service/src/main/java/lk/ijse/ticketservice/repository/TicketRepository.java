package lk.ijse.ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/2/2024
 */

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}

