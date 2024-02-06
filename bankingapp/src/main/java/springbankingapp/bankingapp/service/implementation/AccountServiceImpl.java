package springbankingapp.bankingapp.service.implementation;

import org.springframework.stereotype.Service;
import springbankingapp.bankingapp.dto.AccountDto;
import springbankingapp.bankingapp.entity.Account;
import springbankingapp.bankingapp.mapper.AccountMapper;
import springbankingapp.bankingapp.repository.AccountRepo;
import springbankingapp.bankingapp.service.AccountService;

import java.util.List;
import java.util.stream.Collectors;

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
    public AccountDto getAccountById(Long id) {
        Account account = accountRepo
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        Account account = accountRepo
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account account = accountRepo
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exist"));

        if (account.getBalance()< amount){
            throw new RuntimeException("Insufficient funds");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount=  accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts =  accountRepo.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }
}
