package pl.nkoder.craftingcodeworkshop.sandbox;

import static java.lang.String.format;

public class WorkshopIntroduction {

    private final String name;
    private final String facilitator;

    public WorkshopIntroduction(String name, String facilitator) {
        this.name = name;
        this.facilitator = facilitator;
    }

    public String asText() {
        return format("There it is! '%s' facilitated by %s!", name, facilitator);
    }

    public void methodThatShouldNotBeCalled() {

    }
}
