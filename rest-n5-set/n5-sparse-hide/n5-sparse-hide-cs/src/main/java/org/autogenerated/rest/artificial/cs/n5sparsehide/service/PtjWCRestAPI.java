package org.autogenerated.rest.artificial.cs.n5sparsehide.service;

import org.autogenerated.rest.artificial.cs.n5sparsehide.entity.*;
import org.autogenerated.rest.artificial.cs.n5sparsehide.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
/** automatically created on 2020-01-14 */
@RestController
@RequestMapping(path = "/api")
public class PtjWCRestAPI {
  @Autowired private PtjWCRepository ptjWCRepository;

  @RequestMapping(
      value = "/ptjWCs",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createPtjWC(@RequestBody PtjWC ptjWC) {
    // an entity with id ptjWC.id should not exist
    if (ptjWCRepository.findById(ptjWC.id).isPresent()) return ResponseEntity.status(400).build();
    PtjWCEntity node = new PtjWCEntity();
    node.setId(ptjWC.id);
    node.setName(ptjWC.name);
    node.setValue(ptjWC.value);
    // save the entity
    ptjWCRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/ptjWCs/{ptjWCsId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdatePtjWC(
      @PathVariable(name = "ptjWCsId") Integer ptjWCsId, @RequestBody PtjWC ptjWC) {
    ptjWC.id = ptjWCsId;
    PtjWCEntity node = null;
    if (ptjWCRepository.findById(ptjWC.id).isPresent())
      node = ptjWCRepository.findById(ptjWC.id).get();
    else {
      node = new PtjWCEntity();
      node.setId(ptjWC.id);
    }
    node.setName(ptjWC.name);
    node.setValue(ptjWC.value);
    // save the entity
    ptjWCRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/ptjWCs/{ptjWCsId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<PtjWC> getPtjWCById(@PathVariable(name = "ptjWCsId") Integer ptjWCsId) {
    if (!ptjWCRepository.findById(ptjWCsId).isPresent()) return ResponseEntity.status(404).build();
    PtjWC dto = ptjWCRepository.findById(ptjWCsId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/ptjWCs",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<PtjWC>> getAllPtjWC() {
    List<PtjWC> allDtos = new ArrayList<>();
    for (PtjWCEntity e : ptjWCRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/ptjWCs/{ptjWCsId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updatePtjWCByValues(
      @PathVariable(name = "ptjWCsId") Integer ptjWCsId,
      @RequestParam(name = "ptjWCsname", required = false) String ptjWCsname,
      @RequestParam(name = "ptjWCsvalue", required = false) Integer ptjWCsvalue) {
    if (!ptjWCRepository.findById(ptjWCsId).isPresent()) return ResponseEntity.status(404).build();
    PtjWCEntity node = ptjWCRepository.findById(ptjWCsId).get();
    if (ptjWCsname != null) {
      node.setName(ptjWCsname);
    }
    if (ptjWCsvalue != null) {
      node.setValue(ptjWCsvalue);
    }
    // save the entity
    ptjWCRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/ptjWCs/{ptjWCsId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deletePtjWC(@PathVariable(name = "ptjWCsId") Integer ptjWCsId) {
    // an entity with id ptjWCsId should exist
    if (!ptjWCRepository.findById(ptjWCsId).isPresent()) return ResponseEntity.status(404).build();
    ptjWCRepository.deleteById(ptjWCsId);
    return ResponseEntity.status(200).build();
  }
}
