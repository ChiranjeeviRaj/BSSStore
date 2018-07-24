package uk.bss.store.service.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BSSStoreServiceUtil {

    /**
     *This below util converts Big Decimal value to Pounds to pense
     * for ex if the value less than pound then convers to penes 10p, 50p
     *
     * @param pounds the value on pounds.
     * @return the pounds converting to pense.
     */
    public static BigDecimal getPense(BigDecimal pounds) {
            return pounds.multiply(new BigDecimal(100)).setScale(0, RoundingMode.FLOOR);
    }

    public static BigDecimal getPounds(BigDecimal pounds) {
        return pounds.divide(new BigDecimal(100)).setScale(2, RoundingMode.FLOOR);
    }

    public static List<String> listConverter(String orderStr){
        Pattern pattern = Pattern.compile(" ");
        return pattern.splitAsStream(orderStr).collect(Collectors.toList());
    }

    public static List<String> arrayConverter(String[] orderStr){
        return Arrays.asList(orderStr);
    }
}
