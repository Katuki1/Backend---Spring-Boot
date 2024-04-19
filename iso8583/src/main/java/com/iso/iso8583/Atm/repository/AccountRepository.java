package com.iso.iso8583.Atm.repository;


import com.iso.iso8583.Atm.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccNumber(String AccountNumber);
//    Account findByVirtualAccount(String virtualAccount);
}
