package springbankingapp.bankingapp.service.implementation;

import org.springframework.stereotype.Service;
import springbankingapp.bankingapp.dto.AccountDto;
import springbankingapp.bankingapp.entity.Account;
import springbankingapp.bankingapp.mapper.AccountMapper;
import springbankingapp.bankingapp.repository.AccountRepo;
import springbankingapp.bankingapp.service.AccountService;

//creates a springbean for AccountServiceImpl class
@Service
public class AccountServiceImpl implements AccountService {

    //injecting dependancy
    private AccountRepo accountRepo;
    //@Autowired optional here coz there is only one constructor in this class
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    //initialized from accountservice
    @Override
    public AccountDto createAcount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long Id) {
        Account account = accountRepo
                .findById(Id)
                .orElseThrow(()-> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }
}
