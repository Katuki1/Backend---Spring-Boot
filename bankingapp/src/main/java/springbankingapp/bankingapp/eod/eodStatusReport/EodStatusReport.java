package springbankingapp.bankingapp.eod.eodStatusReport;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EodStatusReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date prevSystemDate;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date nextSystemDate;
    @Column(nullable = false)
    private boolean htdDataBackup = false;
    @Column(nullable = false)
    private boolean dtdDataBackup = false;
    @Column(nullable = false)
    private boolean preEodDbBackup = false;
    @Column(nullable = false)
    private boolean postEodDbBackup = false;
    @Column(nullable = false)
    private boolean eodStatus = false;
    @Column(nullable = false)
    private boolean dtdToHtdBackup = false;
    @Column(nullable = false)
    private boolean moveSystemDate = false;
    @Column(nullable = false)
    private Date eodTime;
}
