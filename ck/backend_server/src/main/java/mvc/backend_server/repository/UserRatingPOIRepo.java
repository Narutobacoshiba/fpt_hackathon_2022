package mvc.backend_server.repository;

import mvc.backend_server.entity.UserRatingPOI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRatingPOIRepo extends JpaRepository<UserRatingPOI, Integer> {
}
