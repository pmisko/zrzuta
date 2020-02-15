package pl.sda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.model.Donation;

import java.util.Set;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT d FROM Donation d where d.whipRound.id = :id")
    Set<Donation> fetchDonationByWhipRoundId(@Param("id") Long id);
}
