package springbankingapp.bankingapp.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepo extends JpaRepository <Account, Long>{

    @Query(value = "SELECT * FROM dtd WHERE date(tran_date) LIKE date(:tran_date) AND deleted_flag='N'", nativeQuery = true)
    List<TransactionHeader> getTodaytransactions(String tran_date);
}
