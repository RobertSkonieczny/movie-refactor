package com.jpmc.theater;

import org.junit.jupiter.api.Test;
import com.jpmc.theater.utils.LocalDateProvider;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalDateProviderTests {
    @Test
    void makeSureCurrentTime() {
        assertEquals(LocalDateProvider.singleton().currentDate(), LocalDate.now());
    }
}
