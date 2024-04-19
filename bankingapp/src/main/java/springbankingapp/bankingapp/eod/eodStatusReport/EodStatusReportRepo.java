package springbankingapp.bankingapp.eod.eodStatusReport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Repository
public interface EodStatusReportRepo extends JpaRepository<EodStatusReport, Long> {

    Optional<EodStatusReport> findByPrevSystemDate (Date prevSystemDate);



}
