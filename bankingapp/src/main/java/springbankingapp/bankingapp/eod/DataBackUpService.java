package springbankingapp.bankingapp.eod;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import springbankingapp.bankingapp.accounts.Account;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class DataBackUpService {

    Gson gson = new Gson();

    @Value("${data.backup.folder}")
    private String backUpsFolder;

    //TimeStamp
    String timeStamp = new SimpleDateFormat("YYYYMMddHHmmss").format(Calendar.getInstance().getTime());


    //BACK UP HTD Data to a log file
    public EodRes writeHTDDataToFile(List<AccountsBackUp> data)
    {
        log.info("*** Begin HTD Data back up to a log file - "+new Date()+ " ***");
        EodRes eodRes = new EodRes();
        eodRes.setEodStep("HTD DATA BACKUP TO A FILE");
        String fileName = "HTD_"+timeStamp+".json";
        File file = new File(backUpsFolder+fileName);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            for (AccountsBackUp backUp :data) {
                fr.write(gson.toJson(backUp));
            }
            fr.close();
            log.info("*** HTD Data back up to a file Completed Successfully! " + new Date() + " File Location - "+backUpsFolder+fileName+" ***");
            eodRes.setIssues("NA");
            eodRes.setMessage("HTD DATA BACK UP TO FILE COMPLETED SUCCESSFULLY! FILE LOCATION - "+ backUpsFolder+fileName);
            eodRes.setStatus(true);

            return eodRes;
        } catch (IOException e) {
            log.info("*** HTD Data back up to a log file Failed! " + new Date() + " Error - "+e.getLocalizedMessage()+" ***");
            eodRes.setIssues(e.getMessage().toUpperCase());
            eodRes.setMessage("HTD DATA BACK UP TO FILE FAILED!");
            eodRes.setStatus(false);
            return eodRes;
        }
    }


    //BACK UP DTD DATA TO LOG FILE
    public EodRes writeDTDDataToFile(List<Account> data)
    {
        log.info("*** Begin DTD Data back up to a log file - "+new Date()+ " ***");
        EodRes eodRes = new EodRes();
        eodRes.setEodStep("DTD DATA BACKUP TO A FILE");
        String fileName = "DTD_"+timeStamp+".json";
        File file = new File(backUpsFolder+fileName);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            for (Account account :data) {
                fr.write(gson.toJson(account));
            }
            fr.close();
            log.info("*** DTD Data back up to a file Completed Successfully! " + new Date() + " File Location - "+backUpsFolder+fileName+" ***");
            eodRes.setIssues("NA");
            eodRes.setMessage("DTD DATA BACK UP TO FILE COMPLETED SUCCESSFULLY! FILE LOCATION - "+ backUpsFolder+fileName);
            eodRes.setStatus(true);

            return eodRes;
        } catch (IOException e) {
            log.info("*** DTD Data back up to a log file Failed! " + new Date() + " Error - "+e.getLocalizedMessage()+" ***");
            eodRes.setIssues(e.getMessage().toUpperCase());
            eodRes.setMessage("DTD DATA BACK UP TO FILE FAILED!");
            eodRes.setStatus(false);
            return eodRes;
        }
    }
}
