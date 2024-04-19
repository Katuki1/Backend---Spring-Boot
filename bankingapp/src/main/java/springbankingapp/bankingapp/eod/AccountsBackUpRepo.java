package springbankingapp.bankingapp.eod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsBackUpRepo extends JpaRepository<AccountsBackUp, Long> {


}
