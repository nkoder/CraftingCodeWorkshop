package pl.nkoder.craftingcodeworkshop.exercise1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralConverterShould {

    @Test
    public void generate_a_roman_numeral_for_a_given_decimal() {
        assertThat(romanFor(1)).isEqualTo("I");
        assertThat(romanFor(2)).isEqualTo("II");
        assertThat(romanFor(3)).isEqualTo("III");
        assertThat(romanFor(5)).isEqualTo("V");
        assertThat(romanFor(7)).isEqualTo("VII");
        assertThat(romanFor(10)).isEqualTo("X");
        assertThat(romanFor(17)).isEqualTo("XVII");
        assertThat(romanFor(30)).isEqualTo("XXX");
        assertThat(romanFor(38)).isEqualTo("XXXVIII");
    }

    private String romanFor(int decimal) {
        return new RomanNumeralConverter().convert(decimal);
    }
}