package springbankingapp.bankingapp.accounts;

import java.util.Date;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountName(),
                accountDto.getBalance()
        );
        account.setTranDate(new Date());
        return account ;
    }
    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountName(),
                account.getBalance()
        );
        return accountDto ;
    }

}
