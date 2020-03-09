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
public class SzAxJRestAPI {
  @Autowired private SzAxJRepository szAxJRepository;

  @RequestMapping(
      value = "/szAxJs",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createSzAxJ(@RequestBody SzAxJ szAxJ) {
    // an entity with id szAxJ.id should not exist
    if (szAxJRepository.findById(szAxJ.id).isPresent()) return ResponseEntity.status(400).build();
    SzAxJEntity node = new SzAxJEntity();
    node.setId(szAxJ.id);
    node.setName(szAxJ.name);
    node.setValue(szAxJ.value);
    // save the entity
    szAxJRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/szAxJs/{szAxJsId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateSzAxJ(
      @PathVariable(name = "szAxJsId") Integer szAxJsId, @RequestBody SzAxJ szAxJ) {
    szAxJ.id = szAxJsId;
    SzAxJEntity node = null;
    if (szAxJRepository.findById(szAxJ.id).isPresent())
      node = szAxJRepository.findById(szAxJ.id).get();
    else {
      node = new SzAxJEntity();
      node.setId(szAxJ.id);
    }
    node.setName(szAxJ.name);
    node.setValue(szAxJ.value);
    // save the entity
    szAxJRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/szAxJs/{szAxJsId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<SzAxJ> getSzAxJById(@PathVariable(name = "szAxJsId") Integer szAxJsId) {
    if (!szAxJRepository.findById(szAxJsId).isPresent()) return ResponseEntity.status(404).build();
    SzAxJ dto = szAxJRepository.findById(szAxJsId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/szAxJs",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<SzAxJ>> getAllSzAxJ() {
    List<SzAxJ> allDtos = new ArrayList<>();
    for (SzAxJEntity e : szAxJRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/szAxJs/{szAxJsId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateSzAxJByValues(
      @PathVariable(name = "szAxJsId") Integer szAxJsId,
      @RequestParam(name = "szAxJsname", required = false) String szAxJsname,
      @RequestParam(name = "szAxJsvalue", required = false) Integer szAxJsvalue) {
    if (!szAxJRepository.findById(szAxJsId).isPresent()) return ResponseEntity.status(404).build();
    SzAxJEntity node = szAxJRepository.findById(szAxJsId).get();
    if (szAxJsname != null) {
      node.setName(szAxJsname);
    }
    if (szAxJsvalue != null) {
      node.setValue(szAxJsvalue);
    }
    // save the entity
    szAxJRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/szAxJs/{szAxJsId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteSzAxJ(@PathVariable(name = "szAxJsId") Integer szAxJsId) {
    // an entity with id szAxJsId should exist
    if (!szAxJRepository.findById(szAxJsId).isPresent()) return ResponseEntity.status(404).build();
    szAxJRepository.deleteById(szAxJsId);
    return ResponseEntity.status(200).build();
  }
}
