package com.crossover.techtrial.dto;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by msodhi on 8/19/18.
 */
public class DailyElectricityTest {

    @Test
    public void toStringTest() {
        LocalDate date = LocalDate.of(2018, 8, 9);
        DailyElectricity dailyElectricity = new DailyElectricity();
        dailyElectricity.setAverage(50.0);
        dailyElectricity.setDate(date);
        dailyElectricity.setMax(20L);
        dailyElectricity.setMin(10L);
        dailyElectricity.setSum(100L);

        String actual = "DailyElectricity [date=2018-08-09, sum=100, average=50.0, min=10, max=20]";
        assertThat(dailyElectricity.toString()).isEqualTo(actual);
    }
}
