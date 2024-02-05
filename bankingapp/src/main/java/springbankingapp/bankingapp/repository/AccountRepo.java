package springbankingapp.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbankingapp.bankingapp.entity.Account;

public interface AccountRepo extends JpaRepository <Account, Long>{
}
