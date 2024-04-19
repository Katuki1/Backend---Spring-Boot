package springbankingapp.bankingapp.atmCards;

import org.springframework.data.jpa.repository.JpaRepository;
import springbankingapp.bankingapp.atmCards.Card;

public interface CardRepo extends JpaRepository<Card, Long> {
}
