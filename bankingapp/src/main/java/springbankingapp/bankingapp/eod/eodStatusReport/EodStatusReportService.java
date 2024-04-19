package springbankingapp.bankingapp.eod.eodStatusReport;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class EodStatusReportService {

    @Autowired
    private EodStatusReportRepo eodStatusReportRepo;

    public void saveEODStatusData (EodStatusReport eodStatusReport){
        if (!eodStatusReportRepo.findByPrevSystemDate(eodStatusReport.getPrevSystemDate()).isPresent())
        {
            eodStatusReportRepo.save(eodStatusReport);
        }
    }

    //Find By System Date
    public EodStatusReport findBySystemDate(String sysDate){
        Date systemDate = null;
        try {
            systemDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sysDate);
        }
        catch (Exception e)
        {
        }
        if(eodStatusReportRepo.findByPrevSystemDate(systemDate).isPresent())
        {
            EodStatusReport report = eodStatusReportRepo.findByPrevSystemDate(systemDate).get();
            return report;
        }
        else
        {
            return null;
        }
    }
}
