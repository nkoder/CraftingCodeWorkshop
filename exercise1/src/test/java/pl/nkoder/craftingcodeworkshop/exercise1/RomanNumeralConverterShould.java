package pl.nkoder.craftingcodeworkshop.exercise1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralConverterShould {

    @Test
    public void generate_a_roman_numeral_for_a_given_decimal() {
        assertThat(romanFor(1)).isEqualTo("I");
    }

    private String romanFor(int decimal) {
        return new RomanNumeralConverter().convert(decimal);
    }
}