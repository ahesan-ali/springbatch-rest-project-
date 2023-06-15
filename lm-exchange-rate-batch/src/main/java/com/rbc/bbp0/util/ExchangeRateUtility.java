package com.rbc.bbp0.util;

import com.rbc.bbp0.constant.ApplicationConstant;
import lombok.AllArgsConstructor;
import lombok.Generated;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Generated
@AllArgsConstructor
public class ExchangeRateUtility {
    public static LocalDateTime getLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter.ofPattern(ApplicationConstant.DATE_FORMAT, Locale.ENGLISH).format(localDateTime);
        return localDateTime;
    }
}
