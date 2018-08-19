package com.crossover.techtrial.service;

import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.model.HourlyElectricity;
import com.crossover.techtrial.repository.HourlyElectricityRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by msodhi on 8/19/18.
 */
public class HourlyElectricityServiceTest {
    HourlyElectricityServiceImpl hourlyElectricityService;

    HourlyElectricityRepository hourlyElectricityRepository;

    EntityManager entityManager;

    @Before
    public void init(){
        hourlyElectricityService = new HourlyElectricityServiceImpl();
        hourlyElectricityRepository = mock(HourlyElectricityRepository.class);
        entityManager = mock(EntityManager.class);
        hourlyElectricityService.hourlyElectricityRepository =hourlyElectricityRepository;
        hourlyElectricityService.entityManager = entityManager;
    }

    @Test
    public void getDailystatisticsTest(){
        List<DailyElectricity> electricities= new ArrayList<>();
        Query mockedQuery = mock(Query.class);
        when(entityManager.createNamedQuery("abc")).thenReturn(mockedQuery);
        when(mockedQuery.getResultList()).thenReturn(electricities);
        assertNotNull(entityManager.createNamedQuery("abc").getResultList());
    }

    @Test
    public void saveTest(){
        HourlyElectricity hourlyElectricity = new HourlyElectricity();
        when (hourlyElectricityRepository.save(any(HourlyElectricity.class))).thenReturn(new HourlyElectricity());
        hourlyElectricityService.save(hourlyElectricity);
    }

    @Test
    public void getAllHourlyElectricityByPanelIdTest(){
        HourlyElectricity hourlyElectricity = new HourlyElectricity();
        Pageable mockPageable = mock(Pageable.class);
        Page list = mock(Page.class);
        hourlyElectricity.setId(1L);hourlyElectricity.setGeneratedElectricity(100L);
        when (hourlyElectricityRepository.findAllByPanelIdOrderByReadingAtDesc(hourlyElectricity.getId(),mockPageable)).thenReturn(list);
        assertNotNull(hourlyElectricityService.getAllHourlyElectricityByPanelId (1L,mockPageable));
    }

}
