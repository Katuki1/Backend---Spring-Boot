package springbankingapp.bankingapp.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository <Account, Long>{
}
