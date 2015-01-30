package pl.nkoder.craftingcodeworkshop.exercise2.system;

import java.time.LocalDate;

import static java.time.LocalDate.now;

public class SystemClock {

    public LocalDate currentDate() {
        return now();
    }
}
