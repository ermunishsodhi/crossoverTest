package com.crossover.techtrial.service;

import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.model.Panel;
import com.crossover.techtrial.repository.PanelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;


/**
 * PanelServiceImpl for panel related handling.
 * @author Crossover
 *
 */
@Service
public class PanelServiceImpl implements PanelService {

  @Autowired
  PanelRepository panelRepository;

  @Autowired
  EntityManager entityManager;
  
  /* (non-Javadoc)
   * @see com.crossover.techtrial.service.PanelService#register(com.crossover.techtrial.model.Panel)
   */
  
  @Override
  public void register(Panel panel) { 
    panelRepository.save(panel);
  }
  
  public Panel findBySerial(String serial) {
    return panelRepository.findBySerial(serial);
  }

  public List<Panel> get() {
    return panelRepository.findAll();
  }

}
