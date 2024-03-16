package springbankingapp.bankingapp.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;

//to generate constructors, getters, setters automatically
@Data
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String accountName;
    private double balance;
}
