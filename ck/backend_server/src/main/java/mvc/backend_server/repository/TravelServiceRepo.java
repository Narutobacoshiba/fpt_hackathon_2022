package mvc.backend_server.repository;

import mvc.backend_server.entity.TravelService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelServiceRepo extends JpaRepository<TravelService, Integer> {
}
