package org.autogenerated.rest.artificial.cs.n5sparsepdshown.service;

import org.autogenerated.rest.artificial.cs.n5sparsepdshown.entity.*;
import org.autogenerated.rest.artificial.cs.n5sparsepdshown.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
/** automatically created on 2020-01-14 */
@RestController
@RequestMapping(path = "/api")
public class QoVyRRestAPI {
  @Autowired private QoVyRRepository qoVyRRepository;

  @RequestMapping(
      value = "/qoVyRs",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createQoVyR(@RequestBody QoVyR qoVyR) {
    // an entity with id qoVyR.id should not exist
    if (qoVyRRepository.findById(qoVyR.id).isPresent()) return ResponseEntity.status(400).build();
    QoVyREntity node = new QoVyREntity();
    node.setId(qoVyR.id);
    node.setName(qoVyR.name);
    node.setValue(qoVyR.value);
    // save the entity
    qoVyRRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/qoVyRs/{qoVyRsId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateQoVyR(
      @PathVariable(name = "qoVyRsId") Integer qoVyRsId, @RequestBody QoVyR qoVyR) {
    qoVyR.id = qoVyRsId;
    QoVyREntity node = null;
    if (qoVyRRepository.findById(qoVyR.id).isPresent())
      node = qoVyRRepository.findById(qoVyR.id).get();
    else {
      node = new QoVyREntity();
      node.setId(qoVyR.id);
    }
    node.setName(qoVyR.name);
    node.setValue(qoVyR.value);
    // save the entity
    qoVyRRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/qoVyRs/{qoVyRsId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<QoVyR> getQoVyRById(@PathVariable(name = "qoVyRsId") Integer qoVyRsId) {
    if (!qoVyRRepository.findById(qoVyRsId).isPresent()) return ResponseEntity.status(404).build();
    QoVyR dto = qoVyRRepository.findById(qoVyRsId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/qoVyRs",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<QoVyR>> getAllQoVyR() {
    List<QoVyR> allDtos = new ArrayList<>();
    for (QoVyREntity e : qoVyRRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/qoVyRs/{qoVyRsId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateQoVyRByValues(
      @PathVariable(name = "qoVyRsId") Integer qoVyRsId,
      @RequestParam(name = "qoVyRsname", required = false) String qoVyRsname,
      @RequestParam(name = "qoVyRsvalue", required = false) Integer qoVyRsvalue) {
    if (!qoVyRRepository.findById(qoVyRsId).isPresent()) return ResponseEntity.status(404).build();
    QoVyREntity node = qoVyRRepository.findById(qoVyRsId).get();
    if (qoVyRsname != null) {
      node.setName(qoVyRsname);
    }
    if (qoVyRsvalue != null) {
      node.setValue(qoVyRsvalue);
    }
    // save the entity
    qoVyRRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/qoVyRs/{qoVyRsId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteQoVyR(@PathVariable(name = "qoVyRsId") Integer qoVyRsId) {
    // an entity with id qoVyRsId should exist
    if (!qoVyRRepository.findById(qoVyRsId).isPresent()) return ResponseEntity.status(404).build();
    qoVyRRepository.deleteById(qoVyRsId);
    return ResponseEntity.status(200).build();
  }
}
