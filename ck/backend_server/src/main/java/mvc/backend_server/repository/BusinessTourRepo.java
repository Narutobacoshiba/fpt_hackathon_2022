package mvc.backend_server.repository;

import mvc.backend_server.entity.BusinessTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessTourRepo extends JpaRepository<BusinessTour, Integer> {
}
