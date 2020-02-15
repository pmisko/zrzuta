package pl.sda.service;

import org.springframework.stereotype.Service;
import pl.sda.model.Donation;
import pl.sda.model.WhipRound;
import pl.sda.repositories.DonationRepository;
import pl.sda.repositories.UserRepository;
import pl.sda.repositories.WhipRoundRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class WhipRoundService {
    private DonationRepository donationRepository;
    private WhipRoundRepository whipRoundRepository;


    public WhipRoundService(DonationRepository donationRepository,
                            WhipRoundRepository whipRoundRepository) {
        this.donationRepository = donationRepository;
        this.whipRoundRepository = whipRoundRepository;
    }

    public Set<WhipRound> findAllWhipRounds() {
        return new HashSet<>(whipRoundRepository.findAll());
    }

    public WhipRound addWhipRound(WhipRound whipRound) {
       return whipRoundRepository.save(whipRound);
    }

    public Donation donate(Donation donation) {
        return donationRepository.save(donation);
    }

    public Set<Donation> getAllDonationByWhipRoundId (Long id) {
        return donationRepository.fetchDonationByWhipRoundId(id);
    }
}
