package org.autogenerated.rest.artificial.cs.n5sparsepdhide.service;

import org.autogenerated.rest.artificial.cs.n5sparsepdhide.entity.*;
import org.autogenerated.rest.artificial.cs.n5sparsepdhide.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
/** automatically created on 2020-01-14 */
@RestController
@RequestMapping(path = "/api")
public class Ye7deRestAPI {
  @Autowired private Ye7deRepository ye7deRepository;
  @Autowired private XPvzdRepository xPvzdRepository;

  @RequestMapping(
      value = "/ye7des",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createYe7de(@RequestBody Ye7de ye7de) {
    // an entity with id ye7de.id should not exist
    if (ye7deRepository.findById(ye7de.id).isPresent()) return ResponseEntity.status(400).build();
    Ye7deEntity node = new Ye7deEntity();
    node.setId(ye7de.id);
    // refer to related entity
    if (!xPvzdRepository.findById(ye7de.xPvzdId).isPresent())
      return ResponseEntity.status(404).build();
    XPvzdEntity referVarToXPvzdEntity = xPvzdRepository.findById(ye7de.xPvzdId).get();
    node.setXPvzd(referVarToXPvzdEntity);
    node.setName(ye7de.name);
    node.setValue(ye7de.value);
    // additional codes for handling dependency
    if (!(node.getValue() == referVarToXPvzdEntity.getValue()))
      return ResponseEntity.status(400).build();
    // save the entity
    ye7deRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/ye7des/{ye7desId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateYe7de(
      @PathVariable(name = "ye7desId") Integer ye7desId, @RequestBody Ye7de ye7de) {
    ye7de.id = ye7desId;
    Ye7deEntity node = null;
    if (ye7deRepository.findById(ye7de.id).isPresent())
      node = ye7deRepository.findById(ye7de.id).get();
    else {
      node = new Ye7deEntity();
      node.setId(ye7de.id);
    }
    // refer to related entity
    if (!xPvzdRepository.findById(ye7de.xPvzdId).isPresent())
      return ResponseEntity.status(404).build();
    XPvzdEntity referVarToXPvzdEntity = xPvzdRepository.findById(ye7de.xPvzdId).get();
    node.setXPvzd(referVarToXPvzdEntity);
    node.setName(ye7de.name);
    node.setValue(ye7de.value);
    // additional codes for handling dependency
    if (!(node.getValue() == referVarToXPvzdEntity.getValue()))
      return ResponseEntity.status(400).build();
    // save the entity
    ye7deRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/ye7des/{ye7desId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<Ye7de> getYe7deById(@PathVariable(name = "ye7desId") Integer ye7desId) {
    if (!ye7deRepository.findById(ye7desId).isPresent()) return ResponseEntity.status(404).build();
    Ye7de dto = ye7deRepository.findById(ye7desId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/ye7des",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<Ye7de>> getAllYe7de() {
    List<Ye7de> allDtos = new ArrayList<>();
    for (Ye7deEntity e : ye7deRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/ye7des/{ye7desId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateYe7deByValues(
      @PathVariable(name = "ye7desId") Integer ye7desId,
      @RequestParam(name = "ye7desname", required = false) String ye7desname,
      @RequestParam(name = "ye7desvalue", required = false) Integer ye7desvalue,
      @RequestParam(name = "xPvzdId", required = false) Integer xPvzdId) {
    if (!ye7deRepository.findById(ye7desId).isPresent()) return ResponseEntity.status(404).build();
    Ye7deEntity node = ye7deRepository.findById(ye7desId).get();
    // refer to related entity
    XPvzdEntity referVarToXPvzdEntity = null;
    if (xPvzdId != null) {
      if (!xPvzdRepository.findById(xPvzdId).isPresent()) return ResponseEntity.status(400).build();
      referVarToXPvzdEntity = xPvzdRepository.findById(xPvzdId).get();
      node.setXPvzd(referVarToXPvzdEntity);
    } else {
      referVarToXPvzdEntity = node.getXPvzd();
    }
    if (ye7desname != null) {
      node.setName(ye7desname);
    }
    if (ye7desvalue != null) {
      node.setValue(ye7desvalue);
    }
    // additional codes for handling dependency
    if (!(node.getValue() == referVarToXPvzdEntity.getValue()))
      return ResponseEntity.status(400).build();
    // save the entity
    ye7deRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/ye7des/{ye7desId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteYe7de(@PathVariable(name = "ye7desId") Integer ye7desId) {
    // an entity with id ye7desId should exist
    if (!ye7deRepository.findById(ye7desId).isPresent()) return ResponseEntity.status(404).build();
    ye7deRepository.deleteById(ye7desId);
    return ResponseEntity.status(200).build();
  }
}
