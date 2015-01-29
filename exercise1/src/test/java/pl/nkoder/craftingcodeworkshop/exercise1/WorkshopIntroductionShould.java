package pl.nkoder.craftingcodeworkshop.exercise1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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