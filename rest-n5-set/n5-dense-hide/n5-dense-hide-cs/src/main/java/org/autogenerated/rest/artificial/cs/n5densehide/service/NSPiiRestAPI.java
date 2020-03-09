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
public class NSPiiRestAPI {
  @Autowired private NSPiiRepository nSPiiRepository;

  @RequestMapping(
      value = "/nSPiis",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createNSPii(@RequestBody NSPii nSPii) {
    // an entity with id nSPii.id should not exist
    if (nSPiiRepository.findById(nSPii.id).isPresent()) return ResponseEntity.status(400).build();
    NSPiiEntity node = new NSPiiEntity();
    node.setId(nSPii.id);
    node.setName(nSPii.name);
    node.setValue(nSPii.value);
    // save the entity
    nSPiiRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/nSPiis/{nSPiisId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateNSPii(
      @PathVariable(name = "nSPiisId") Integer nSPiisId, @RequestBody NSPii nSPii) {
    nSPii.id = nSPiisId;
    NSPiiEntity node = null;
    if (nSPiiRepository.findById(nSPii.id).isPresent())
      node = nSPiiRepository.findById(nSPii.id).get();
    else {
      node = new NSPiiEntity();
      node.setId(nSPii.id);
    }
    node.setName(nSPii.name);
    node.setValue(nSPii.value);
    // save the entity
    nSPiiRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/nSPiis/{nSPiisId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<NSPii> getNSPiiById(@PathVariable(name = "nSPiisId") Integer nSPiisId) {
    if (!nSPiiRepository.findById(nSPiisId).isPresent()) return ResponseEntity.status(404).build();
    NSPii dto = nSPiiRepository.findById(nSPiisId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/nSPiis",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<NSPii>> getAllNSPii() {
    List<NSPii> allDtos = new ArrayList<>();
    for (NSPiiEntity e : nSPiiRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/nSPiis/{nSPiisId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateNSPiiByValues(
      @PathVariable(name = "nSPiisId") Integer nSPiisId,
      @RequestParam(name = "nSPiisname", required = false) String nSPiisname,
      @RequestParam(name = "nSPiisvalue", required = false) Integer nSPiisvalue) {
    if (!nSPiiRepository.findById(nSPiisId).isPresent()) return ResponseEntity.status(404).build();
    NSPiiEntity node = nSPiiRepository.findById(nSPiisId).get();
    if (nSPiisname != null) {
      node.setName(nSPiisname);
    }
    if (nSPiisvalue != null) {
      node.setValue(nSPiisvalue);
    }
    // save the entity
    nSPiiRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/nSPiis/{nSPiisId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteNSPii(@PathVariable(name = "nSPiisId") Integer nSPiisId) {
    // an entity with id nSPiisId should exist
    if (!nSPiiRepository.findById(nSPiisId).isPresent()) return ResponseEntity.status(404).build();
    nSPiiRepository.deleteById(nSPiisId);
    return ResponseEntity.status(200).build();
  }
}
