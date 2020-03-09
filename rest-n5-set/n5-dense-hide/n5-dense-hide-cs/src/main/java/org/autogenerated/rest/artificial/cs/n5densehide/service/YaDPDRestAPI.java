package org.autogenerated.rest.artificial.cs.n5densehide.service;

import org.autogenerated.rest.artificial.cs.n5densehide.entity.*;
import org.autogenerated.rest.artificial.cs.n5densehide.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
/** automatically created on 2020-01-14 */
@RestController
@RequestMapping(path = "/api")
public class YaDPDRestAPI {
  @Autowired private YaDPDRepository yaDPDRepository;

  @RequestMapping(
      value = "/yaDPDs",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createYaDPD(@RequestBody YaDPD yaDPD) {
    // an entity with id yaDPD.id should not exist
    if (yaDPDRepository.findById(yaDPD.id).isPresent()) return ResponseEntity.status(400).build();
    YaDPDEntity node = new YaDPDEntity();
    node.setId(yaDPD.id);
    node.setName(yaDPD.name);
    node.setValue(yaDPD.value);
    // save the entity
    yaDPDRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/yaDPDs/{yaDPDsId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateYaDPD(
      @PathVariable(name = "yaDPDsId") Integer yaDPDsId, @RequestBody YaDPD yaDPD) {
    yaDPD.id = yaDPDsId;
    YaDPDEntity node = null;
    if (yaDPDRepository.findById(yaDPD.id).isPresent())
      node = yaDPDRepository.findById(yaDPD.id).get();
    else {
      node = new YaDPDEntity();
      node.setId(yaDPD.id);
    }
    node.setName(yaDPD.name);
    node.setValue(yaDPD.value);
    // save the entity
    yaDPDRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/yaDPDs/{yaDPDsId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<YaDPD> getYaDPDById(@PathVariable(name = "yaDPDsId") Integer yaDPDsId) {
    if (!yaDPDRepository.findById(yaDPDsId).isPresent()) return ResponseEntity.status(404).build();
    YaDPD dto = yaDPDRepository.findById(yaDPDsId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/yaDPDs",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<YaDPD>> getAllYaDPD() {
    List<YaDPD> allDtos = new ArrayList<>();
    for (YaDPDEntity e : yaDPDRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/yaDPDs/{yaDPDsId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateYaDPDByValues(
      @PathVariable(name = "yaDPDsId") Integer yaDPDsId,
      @RequestParam(name = "yaDPDsname", required = false) String yaDPDsname,
      @RequestParam(name = "yaDPDsvalue", required = false) Integer yaDPDsvalue) {
    if (!yaDPDRepository.findById(yaDPDsId).isPresent()) return ResponseEntity.status(404).build();
    YaDPDEntity node = yaDPDRepository.findById(yaDPDsId).get();
    if (yaDPDsname != null) {
      node.setName(yaDPDsname);
    }
    if (yaDPDsvalue != null) {
      node.setValue(yaDPDsvalue);
    }
    // save the entity
    yaDPDRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/yaDPDs/{yaDPDsId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteYaDPD(@PathVariable(name = "yaDPDsId") Integer yaDPDsId) {
    // an entity with id yaDPDsId should exist
    if (!yaDPDRepository.findById(yaDPDsId).isPresent()) return ResponseEntity.status(404).build();
    yaDPDRepository.deleteById(yaDPDsId);
    return ResponseEntity.status(200).build();
  }
}