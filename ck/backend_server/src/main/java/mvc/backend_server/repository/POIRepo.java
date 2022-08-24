package mvc.backend_server.repository;

import mvc.backend_server.entity.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POIRepo extends JpaRepository<POI, Integer> {
    public POI findByPOIId(int POIId);
}
