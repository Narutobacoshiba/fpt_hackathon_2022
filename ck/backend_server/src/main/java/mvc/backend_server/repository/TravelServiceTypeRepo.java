package mvc.backend_server.repository;

import mvc.backend_server.entity.TravelServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelServiceTypeRepo extends JpaRepository<TravelServiceType, Integer> {
}
