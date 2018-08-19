package com.crossover.techtrial.service;

import com.crossover.techtrial.model.Panel;
import com.crossover.techtrial.repository.PanelRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by msodhi on 8/19/18.
 */
public class PanelServiceTest {

    PanelServiceImpl panelService;

    PanelRepository panelRepository;

    @Before
    public void init(){
        panelService = new PanelServiceImpl();
        panelRepository = mock(PanelRepository.class);
        panelService.panelRepository=panelRepository;
    }

    @Test
    public void registerTest(){
        Panel panel = new Panel();
        when (panelRepository.save(any(Panel.class))).thenReturn(new Panel());
       panelService.register(panel);
    }

    @Test
    public void findBySerial(){
        Panel panel = new Panel();panel.setSerial("123");panel.setBrand("T");
        when (panelRepository.findBySerial("123")).thenReturn(panel);
        Panel actual = panelService.findBySerial("123");
        assertEquals (panel,actual);
    }



}
