package pl.nkoder.craftingcodeworkshop.exercise1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SomeClassShould {

    @Test
    public void fail() {
        assertThat(true).isFalse();
    }
}