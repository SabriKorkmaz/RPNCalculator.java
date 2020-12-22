package com.rncalc.Helper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class StringHelper {
    public static String formatStr(BigDecimal val) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        formatter.setMaximumFractionDigits(10);
        formatter.setRoundingMode(RoundingMode.DOWN);
        return formatter.format(val);
    }

    public static String joinNumber(String currentNumber,int newValue,int sign) {
        if (currentNumber == "0" ) {
            return formatStr(new BigDecimal(newValue));
        }
        var currentNumberString = "";
        var currentValue = currentNumber.replace("-", "");
        if (currentValue.contains(".")) {
            var numberParts = currentValue.split("\\.", -1);
            currentNumberString = numberParts[0] + "." + numberParts[1] + newValue;
        } else {
            currentNumberString = currentValue + newValue;
        }
        return formatStr(new BigDecimal(currentNumberString).multiply(new BigDecimal(sign)));
    }

    public static String addSeparator(String value) {
        if (value.contains(".")) return value;
        else return value + ".";
    }


}
