package pl.nkoder.craftingcodeworkshop.exercise1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralConverterShould {

    @Test
    public void generate_a_roman_numeral_for_a_given_decimal() {
        assertThat(romanFor(1)).isEqualTo("I");
        assertThat(romanFor(2)).isEqualTo("II");
        assertThat(romanFor(3)).isEqualTo("III");
        assertThat(romanFor(4)).isEqualTo("IV");
        assertThat(romanFor(5)).isEqualTo("V");
        assertThat(romanFor(7)).isEqualTo("VII");
        assertThat(romanFor(9)).isEqualTo("IX");
        assertThat(romanFor(10)).isEqualTo("X");
        assertThat(romanFor(17)).isEqualTo("XVII");
        assertThat(romanFor(30)).isEqualTo("XXX");
        assertThat(romanFor(38)).isEqualTo("XXXVIII");
        assertThat(romanFor(40)).isEqualTo("XL");
        assertThat(romanFor(90)).isEqualTo("XC");
        assertThat(romanFor(50)).isEqualTo("L");
        assertThat(romanFor(90)).isEqualTo("XC");
        assertThat(romanFor(100)).isEqualTo("C");
        assertThat(romanFor(400)).isEqualTo("CD");
        assertThat(romanFor(500)).isEqualTo("D");
        assertThat(romanFor(900)).isEqualTo("CM");
        assertThat(romanFor(1000)).isEqualTo("M");
        assertThat(romanFor(3999)).isEqualTo("MMMCMXCIX");
    }

    private String romanFor(int decimal) {
        return new RomanNumeralConverter().convert(decimal);
    }
}