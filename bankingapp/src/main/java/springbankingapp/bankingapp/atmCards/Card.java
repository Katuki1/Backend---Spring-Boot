package springbankingapp.bankingapp.atmCards;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@Entity
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 4)
    private String expiryMonthYear;

    private LocalDate expiryDate;
    private int cardNumber;

//    private int pinHash;
//
//    public void setPin(int pin) {
//        // Hash the PIN using bcrypt and store the hash
//        this.pinHash = new BCryptPasswordEncoder().encode(pin);
//    }
//
//    public boolean verifyPin(String pin) {
//        // Verify the PIN by comparing the provided PIN with the stored hash
//        return new BCryptPasswordEncoder().matches(pin, this.pinHash);
//    }
}
