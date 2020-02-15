package pl.sda.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Donation {

    @Id
    @GeneratedValue(generator = "donationSeq")
    @SequenceGenerator(name = "donationSeq", sequenceName = "donation_seq", allocationSize = 1)
    private Long id;
    private BigDecimal amount;
    LocalDate donationDate;
    @ManyToOne(targetEntity = WhipRound.class)
    private WhipRound whipRound;
    @ManyToOne (targetEntity = User.class)
    private User user;

    public Donation(Long id, BigDecimal amount, LocalDate donationDate, WhipRound whipRound, User user) {
        this.amount = amount;
        this.donationDate = donationDate;
        this.whipRound = whipRound;
        this.user = user;
    }

    public Donation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public WhipRound getWhipRound() {
        return whipRound;
    }

    public void setWhipRound(WhipRound whipRound) {
        this.whipRound = whipRound;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Donation)) return false;
        Donation donation = (Donation) o;
        return Objects.equals(id, donation.id) &&
                Objects.equals(amount, donation.amount) &&
                Objects.equals(donationDate, donation.donationDate) &&
                Objects.equals(whipRound, donation.whipRound) &&
                Objects.equals(user, donation.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, donationDate, whipRound, user);
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", amount=" + amount +
                ", donationDate=" + donationDate +
                ", whipRound=" + whipRound +
                ", user=" + user +
                '}';
    }
}
