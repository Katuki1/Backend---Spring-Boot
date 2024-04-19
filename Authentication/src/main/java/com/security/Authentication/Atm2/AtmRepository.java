package com.security.Authentication.Atm2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtmRepository extends JpaRepository<Atm, Long>{

    List<Atm> findByDeletedFlag(Character deletedFlag);
//
//    List<String> findByIPAddresses();
//
//    void updateStatus(String ipAddress, String status);

    Optional<Atm> findByTerminalId(String terminalId);
}
