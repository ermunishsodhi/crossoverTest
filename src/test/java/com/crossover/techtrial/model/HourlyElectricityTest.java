package com.crossover.techtrial.model;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by msodhi on 8/19/18.
 */
public class HourlyElectricityTest {
    @Test
    public void testEqualsAndHashCode() {

        LocalDateTime now = LocalDateTime.now();
        long generatedElectricity = 100;
        long id = 1001;

        HourlyElectricity hourlyElectricity1 = createHourlyElectricity(now, generatedElectricity, id);
        HourlyElectricity hourlyElectricity2 = createHourlyElectricity(now, generatedElectricity, id);

        assertEquals(hourlyElectricity1, hourlyElectricity2);
        assertTrue( hourlyElectricity1.hashCode()==hourlyElectricity2.hashCode() );

    }

    public HourlyElectricity createHourlyElectricity(LocalDateTime now,long generatedElectricity, long id) {
        HourlyElectricity hourlyElectricity = new HourlyElectricity();
        hourlyElectricity.setGeneratedElectricity(generatedElectricity);
        hourlyElectricity.setReadingAt(now);
        hourlyElectricity.setId(id);
        return hourlyElectricity;
    }
}
