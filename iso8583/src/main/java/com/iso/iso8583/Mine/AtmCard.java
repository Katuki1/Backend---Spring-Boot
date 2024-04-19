package com.iso.iso8583.Mine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AtmCard {
    private Long id;
    private Long cardNumber;
    private String accountName;
    private double amount;
    private int pin;
}
