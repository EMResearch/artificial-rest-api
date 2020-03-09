package org.autogenerated.rest.artificial.cs.n5denseshown.service;

import org.autogenerated.rest.artificial.cs.n5denseshown.entity.*;
import org.autogenerated.rest.artificial.cs.n5denseshown.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
/** automatically created on 2020-01-14 */
@RestController
@RequestMapping(path = "/api")
public class SIth8RestAPI {
  @Autowired private SIth8Repository sIth8Repository;

  @RequestMapping(
      value = "/sIth8s",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createSIth8(@RequestBody SIth8 sIth8) {
    // an entity with id sIth8.id should not exist
    if (sIth8Repository.findById(sIth8.id).isPresent()) return ResponseEntity.status(400).build();
    SIth8Entity node = new SIth8Entity();
    node.setId(sIth8.id);
    node.setName(sIth8.name);
    node.setValue(sIth8.value);
    // save the entity
    sIth8Repository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/sIth8s/{sIth8sId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateSIth8(
      @PathVariable(name = "sIth8sId") Integer sIth8sId, @RequestBody SIth8 sIth8) {
    sIth8.id = sIth8sId;
    SIth8Entity node = null;
    if (sIth8Repository.findById(sIth8.id).isPresent())
      node = sIth8Repository.findById(sIth8.id).get();
    else {
      node = new SIth8Entity();
      node.setId(sIth8.id);
    }
    node.setName(sIth8.name);
    node.setValue(sIth8.value);
    // save the entity
    sIth8Repository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/sIth8s/{sIth8sId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<SIth8> getSIth8ById(@PathVariable(name = "sIth8sId") Integer sIth8sId) {
    if (!sIth8Repository.findById(sIth8sId).isPresent()) return ResponseEntity.status(404).build();
    SIth8 dto = sIth8Repository.findById(sIth8sId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/sIth8s",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<SIth8>> getAllSIth8() {
    List<SIth8> allDtos = new ArrayList<>();
    for (SIth8Entity e : sIth8Repository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/sIth8s/{sIth8sId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateSIth8ByValues(
      @PathVariable(name = "sIth8sId") Integer sIth8sId,
      @RequestParam(name = "sIth8sname", required = false) String sIth8sname,
      @RequestParam(name = "sIth8svalue", required = false) Integer sIth8svalue) {
    if (!sIth8Repository.findById(sIth8sId).isPresent()) return ResponseEntity.status(404).build();
    SIth8Entity node = sIth8Repository.findById(sIth8sId).get();
    if (sIth8sname != null) {
      node.setName(sIth8sname);
    }
    if (sIth8svalue != null) {
      node.setValue(sIth8svalue);
    }
    // save the entity
    sIth8Repository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/sIth8s/{sIth8sId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteSIth8(@PathVariable(name = "sIth8sId") Integer sIth8sId) {
    // an entity with id sIth8sId should exist
    if (!sIth8Repository.findById(sIth8sId).isPresent()) return ResponseEntity.status(404).build();
    sIth8Repository.deleteById(sIth8sId);
    return ResponseEntity.status(200).build();
  }
}