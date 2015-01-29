package pl.nkoder.craftingcodeworkshop.exercise1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RomanNumeralConverterShould {

    @Parameters(method = "decimalsAndRomans")
    @Test
    public void generate_a_roman_numeral_for_a_given_decimal(int decimal, String roman) {
        assertThat(romanFor(decimal)).isEqualTo(roman);
    }

    @Test
    public void generate_a_roman_numeral_for_tricky_decimal() {
        assertThat(romanFor(444)).isEqualTo("CDXLIV");
        assertThat(romanFor(999)).isEqualTo("CMXCIX");
    }

    private String romanFor(int decimal) {
        return new RomanNumeralConverter().convert(decimal);
    }

    @SuppressWarnings("UnusedDeclaration")
    private Object decimalsAndRomans() {
        return $(
                $(1, "I"),
                $(2, "II"),
                $(3, "III"),
                $(4, "IV"),
                $(5, "V"),
                $(7, "VII"),
                $(9, "IX"),
                $(10, "X"),
                $(17, "XVII"),
                $(30, "XXX"),
                $(38, "XXXVIII"),
                $(40, "XL"),
                $(90, "XC"),
                $(50, "L"),
                $(90, "XC"),
                $(100, "C"),
                $(400, "CD"),
                $(500, "D"),
                $(900, "CM"),
                $(1000, "M"),
                $(3999, "MMMCMXCIX")
        );
    }
}