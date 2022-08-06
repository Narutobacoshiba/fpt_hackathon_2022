package mvc.backend_server.repository;

import mvc.backend_server.entity.TravelerRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerRatingRepo extends JpaRepository<TravelerRating, Integer> {
}
