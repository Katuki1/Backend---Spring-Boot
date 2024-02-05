package springbankingapp.bankingapp.mapper;

import springbankingapp.bankingapp.dto.AccountDto;
import springbankingapp.bankingapp.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                AccountDto.getId(),
                AccountDto.getAccountName(),
                AccountDto.getBalance()
        );
        return account ;
    }
    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                Account.getId(),
                Account.getAccountName(),
                Account.getBalance()
        );
        return accountDto ;
    }

}
