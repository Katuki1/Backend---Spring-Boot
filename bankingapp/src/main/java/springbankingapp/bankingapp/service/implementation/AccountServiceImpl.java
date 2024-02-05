package springbankingapp.bankingapp.service.implementation;

import org.springframework.stereotype.Service;
import springbankingapp.bankingapp.dto.AccountDto;
import springbankingapp.bankingapp.entity.Account;
import springbankingapp.bankingapp.mapper.AccountMapper;
import springbankingapp.bankingapp.repository.AccountRepo;
import springbankingapp.bankingapp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;
    //@Autowired optional here
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public AccountDto createAcount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto );
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
