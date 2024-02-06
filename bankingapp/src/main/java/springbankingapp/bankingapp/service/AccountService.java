package springbankingapp.bankingapp.service;

import springbankingapp.bankingapp.dto.AccountDto;
import springbankingapp.bankingapp.entity.Account;

public interface AccountService {

    //define method
    //Account createAccount(Account account);

    //or create a dto class alternatively. It passes data btw client and server
    AccountDto createAcount(AccountDto accountDto);
    AccountDto getAccountById(Long Id);

}
