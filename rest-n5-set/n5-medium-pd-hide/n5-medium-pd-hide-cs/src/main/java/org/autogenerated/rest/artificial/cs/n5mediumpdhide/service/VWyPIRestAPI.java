package org.autogenerated.rest.artificial.cs.n5mediumpdhide.service;

import org.autogenerated.rest.artificial.cs.n5mediumpdhide.entity.*;
import org.autogenerated.rest.artificial.cs.n5mediumpdhide.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
/** automatically created on 2020-01-14 */
@RestController
@RequestMapping(path = "/api")
public class VWyPIRestAPI {
  @Autowired private VWyPIRepository vWyPIRepository;
  @Autowired private XfPcdRepository xfPcdRepository;

  @RequestMapping(
      value = "/vWyPIs",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createVWyPI(@RequestBody VWyPI vWyPI) {
    // an entity with id vWyPI.id should not exist
    if (vWyPIRepository.findById(vWyPI.id).isPresent()) return ResponseEntity.status(400).build();
    VWyPIEntity node = new VWyPIEntity();
    node.setId(vWyPI.id);
    // refer to related entity
    if (!xfPcdRepository.findById(vWyPI.xfPcdId).isPresent())
      return ResponseEntity.status(404).build();
    XfPcdEntity referVarToXfPcdEntity = xfPcdRepository.findById(vWyPI.xfPcdId).get();
    node.setXfPcd(referVarToXfPcdEntity);
    node.setName(vWyPI.name);
    node.setValue(vWyPI.value);
    // additional codes for handling dependency
    if (!(node.getValue() == referVarToXfPcdEntity.getValue()))
      return ResponseEntity.status(400).build();
    // save the entity
    vWyPIRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/vWyPIs/{vWyPIsId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateVWyPI(
      @PathVariable(name = "vWyPIsId") Integer vWyPIsId, @RequestBody VWyPI vWyPI) {
    vWyPI.id = vWyPIsId;
    VWyPIEntity node = null;
    if (vWyPIRepository.findById(vWyPI.id).isPresent())
      node = vWyPIRepository.findById(vWyPI.id).get();
    else {
      node = new VWyPIEntity();
      node.setId(vWyPI.id);
    }
    // refer to related entity
    if (!xfPcdRepository.findById(vWyPI.xfPcdId).isPresent())
      return ResponseEntity.status(404).build();
    XfPcdEntity referVarToXfPcdEntity = xfPcdRepository.findById(vWyPI.xfPcdId).get();
    node.setXfPcd(referVarToXfPcdEntity);
    node.setName(vWyPI.name);
    node.setValue(vWyPI.value);
    // additional codes for handling dependency
    if (!(node.getValue() == referVarToXfPcdEntity.getValue()))
      return ResponseEntity.status(400).build();
    // save the entity
    vWyPIRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/vWyPIs/{vWyPIsId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<VWyPI> getVWyPIById(@PathVariable(name = "vWyPIsId") Integer vWyPIsId) {
    if (!vWyPIRepository.findById(vWyPIsId).isPresent()) return ResponseEntity.status(404).build();
    VWyPI dto = vWyPIRepository.findById(vWyPIsId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/vWyPIs",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<VWyPI>> getAllVWyPI() {
    List<VWyPI> allDtos = new ArrayList<>();
    for (VWyPIEntity e : vWyPIRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/vWyPIs/{vWyPIsId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateVWyPIByValues(
      @PathVariable(name = "vWyPIsId") Integer vWyPIsId,
      @RequestParam(name = "vWyPIsname", required = false) String vWyPIsname,
      @RequestParam(name = "vWyPIsvalue", required = false) Integer vWyPIsvalue,
      @RequestParam(name = "xfPcdId", required = false) Integer xfPcdId) {
    if (!vWyPIRepository.findById(vWyPIsId).isPresent()) return ResponseEntity.status(404).build();
    VWyPIEntity node = vWyPIRepository.findById(vWyPIsId).get();
    // refer to related entity
    XfPcdEntity referVarToXfPcdEntity = null;
    if (xfPcdId != null) {
      if (!xfPcdRepository.findById(xfPcdId).isPresent()) return ResponseEntity.status(400).build();
      referVarToXfPcdEntity = xfPcdRepository.findById(xfPcdId).get();
      node.setXfPcd(referVarToXfPcdEntity);
    } else {
      referVarToXfPcdEntity = node.getXfPcd();
    }
    if (vWyPIsname != null) {
      node.setName(vWyPIsname);
    }
    if (vWyPIsvalue != null) {
      node.setValue(vWyPIsvalue);
    }
    // additional codes for handling dependency
    if (!(node.getValue() == referVarToXfPcdEntity.getValue()))
      return ResponseEntity.status(400).build();
    // save the entity
    vWyPIRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/vWyPIs/{vWyPIsId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteVWyPI(@PathVariable(name = "vWyPIsId") Integer vWyPIsId) {
    // an entity with id vWyPIsId should exist
    if (!vWyPIRepository.findById(vWyPIsId).isPresent()) return ResponseEntity.status(404).build();
    vWyPIRepository.deleteById(vWyPIsId);
    return ResponseEntity.status(200).build();
  }
}
