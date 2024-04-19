package springbankingapp.bankingapp.atmCards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;

@Service
public class CardService {

    @Autowired
    private CardRepo cardRepository;

    public CardService(CardRepo cardRepository) {
        this.cardRepository = cardRepository;
    }

    public String saveCardWithExpiryDate(Card card) {
        // Assuming expiryMonthYear is in the format MMYY
        int month = Integer.parseInt(card.getExpiryMonthYear().substring(0, 2));
        int year = Integer.parseInt("20" + card.getExpiryMonthYear().substring(2)); // Assuming we're dealing with 21st century dates

        // Calculate the last day of the month
        LocalDate expiryDate = YearMonth.of(year, month).atEndOfMonth();

        // Create and save the card entity
//        Card card = new Card();
//        card.setId(cardId);
        card.setExpiryDate(expiryDate);
        cardRepository.save(card);

        return String.valueOf(card);
    }
}
