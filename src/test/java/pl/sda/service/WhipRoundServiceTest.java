package pl.sda.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.model.Donation;
import pl.sda.model.WhipRound;
import pl.sda.repositories.DonationRepository;
import pl.sda.repositories.WhipRoundRepository;

import javax.swing.text.Document;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class WhipRoundServiceTest {

    @Autowired
    private WhipRoundService SUT;
    @Autowired
    private WhipRoundRepository whipRoundRepository;
    @Autowired
    private DonationRepository donationRepository;

    @Test
    void findAllWhipRoundsShouldAllWhipRounds() {

        Set<WhipRound> actual = SUT.findAllWhipRounds();

        assertThat(actual).hasSize(2);
    }

    @Test
    @Transactional
    void addWhipRoundShouldAddWhipRound() {
        //given
        WhipRound newWhipRound = new WhipRound("Na kota", "rudego", LocalDate.parse("2020-03-01"), LocalDate.parse("2020-04-01"), new BigDecimal(10000), null);

        //when
        WhipRound addedWhipRound = SUT.addWhipRound(newWhipRound);

        //then
        assertThat(addedWhipRound.getId()).isEqualTo(3L);
        assertThat(whipRoundRepository.getOne(3L)).isNotNull();
    }

    @Test
    @Transactional
    void donateShouldAddDonationToRepository() {

        //given
        Donation donation = new Donation(new BigDecimal(100), LocalDate.parse("2020-02-15"), null, null);
        //when
        Donation actual = SUT.donate(donation);
        //then
        assertThat(actual.getId()).isEqualTo(4L);
        assertThat(donationRepository.getOne(4L)).isNotNull();
    }

    @Test
    void fetchDonationByWhipRoundIdShouldReturnDonationSetByWhipRoundId() {

        Set<Donation> actual = SUT.getAllDonationByWhipRoundId(2L);

        assertThat(actual)
                .extracting(Donation::getId)
                .containsExactlyInAnyOrder(2L, 3L);
    }
}