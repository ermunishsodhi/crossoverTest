package com.crossover.techtrial.service;

import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.model.Panel;

import java.util.List;


/**
 * PanelService interface for Panels.
 * @author Crossover
 *
 */
public interface PanelService {
  
  /**
   * Register a panel for electricity monitoring.
   * @param panel to register with system.
   */
  
  void register(Panel panel);
  
  Panel findBySerial(String serial);

  List<Panel> get();
}
