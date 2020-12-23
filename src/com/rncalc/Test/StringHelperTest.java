package com.rncalc.Test;

import com.rncalc.Helper.StringHelper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringHelperTest {
    StringHelper helper = new StringHelper();
    @Test
    public void formatString_parameter0_0() {
        assertEquals("0",helper.formatStr(new BigDecimal(0)));
    }

    @Test
    public void formatString_oneHundred_formattedHundred() {
        assertEquals("100",helper.formatStr(new BigDecimal(100)));
    }

    @Test
    public void formatString_10point3_formatted10point3() {
        assertEquals("10.3",helper.formatStr(new BigDecimal(10.3)));
    }

    @Test
    public void formatString_1000WithDecimalFormatted_1000point3() {
        assertEquals("1,000",helper.formatStr(new BigDecimal(1000)));
    }

    @Test
    public void joinNumber_4with0_40() {
        assertEquals("40",helper.joinNumber("4",0,1));
    }

    @Test
    public void joinNumber_currentNumber0value5SignNegative_negative5() {
        assertEquals("5",helper.joinNumber("0",5,-1));

    }
    @Test
    public void addSeparator_100point3_100point3() {
        assertEquals("100.3",helper.addSeparator("100.3"));
    }

    @Test
    public void addSeparator_100_100point() {
        assertEquals("100.",helper.addSeparator("100"));
    }


}
