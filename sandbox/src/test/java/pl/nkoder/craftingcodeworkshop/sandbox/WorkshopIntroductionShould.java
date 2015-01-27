package pl.nkoder.craftingcodeworkshop.sandbox;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class WorkshopIntroductionShould {

    @Test
    public void introduceWorkshopWithGivenNameAndFacilitator() {
        WorkshopIntroduction introduction = spy(new WorkshopIntroduction("super workshop", "This Guy"));

        assertThat(introduction.asText())
                .isEqualTo("There it is! 'super workshop' facilitated by This Guy!");
    }

    @Test
    public void notCallImproperMethod() {
        WorkshopIntroduction introduction = spy(new WorkshopIntroduction("super workshop", "This Guy"));

        verify(introduction, never()).methodThatShouldNotBeCalled();
    }
}