package pl.sda.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sda.model.Donation;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class DonationRepositoryTest {

    @Autowired
    private DonationRepository SUT;



    @Test
    void fetchDonationByWhipRoundIdShouldReturnDonationSetByWhipRoundId() {

        Set<Donation> actual = SUT.fetchDonationByWhipRoundId(2L);

        assertThat(actual)
                .extracting(Donation::getId)
                .containsExactlyInAnyOrder(2L, 3L);

    }
}