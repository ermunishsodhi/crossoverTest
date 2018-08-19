package com.crossover.techtrial.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by msodhi on 8/19/18.
 */
public class PanelTest {

    @Test
    public void testEqualsAndHashCode() {
        String serial = "123";
        Panel panel1 = createPanel(serial);
        Panel panel2 = createPanel(serial);

        String panelToString = "Panel [id=1, serial="+serial+", longitude=100.0, latitude=100.0, brand=TEST]";

        assertEquals(panel1.toString(), panelToString);
        assertEquals(panel1, panel2);
        assertTrue( panel1.hashCode() == panel2.hashCode() );
    }

    private Panel createPanel(String serial) {
        Panel panel = new Panel();
        panel.setBrand("TEST");
        panel.setLatitude(100.0);
        panel.setLongitude(100.0);
        panel.setSerial(serial);
        panel.setId(1L);

        return panel;
    }
}
