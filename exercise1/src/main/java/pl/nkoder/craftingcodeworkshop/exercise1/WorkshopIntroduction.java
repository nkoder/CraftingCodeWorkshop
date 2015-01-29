package pl.nkoder.craftingcodeworkshop.exercise1;

import java.util.StringJoiner;

import static java.lang.String.format;

public class WorkshopIntroduction {

    private final String name;
    private final String facilitator;

    public WorkshopIntroduction(String name, String facilitator) {
        this.name = name;
        this.facilitator = facilitator;
    }

    public String asText() {
        StringJoiner joiner = new StringJoiner(" ");
        joiner.add("There it is!");
        joiner.add("'%s'");
        joiner.add("fffacilitated by %s!");
        return format(joiner.toString(), name, facilitator);
    }

    public void methodThatShouldNotBeCalled() {

    }
}
