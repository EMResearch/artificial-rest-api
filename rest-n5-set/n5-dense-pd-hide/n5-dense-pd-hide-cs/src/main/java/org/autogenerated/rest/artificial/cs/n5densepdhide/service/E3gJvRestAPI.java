package org.autogenerated.rest.artificial.cs.n5densepdhide.service;

import org.autogenerated.rest.artificial.cs.n5densepdhide.entity.*;
import org.autogenerated.rest.artificial.cs.n5densepdhide.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
/** automatically created on 2020-01-14 */
@RestController
@RequestMapping(path = "/api")
public class E3gJvRestAPI {
  @Autowired private E3gJvRepository e3gJvRepository;

  @RequestMapping(
      value = "/e3gJvs",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createE3gJv(@RequestBody E3gJv e3gJv) {
    // an entity with id e3gJv.id should not exist
    if (e3gJvRepository.findById(e3gJv.id).isPresent()) return ResponseEntity.status(400).build();
    E3gJvEntity node = new E3gJvEntity();
    node.setId(e3gJv.id);
    node.setName(e3gJv.name);
    node.setValue(e3gJv.value);
    // save the entity
    e3gJvRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/e3gJvs/{e3gJvsId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateE3gJv(
      @PathVariable(name = "e3gJvsId") Integer e3gJvsId, @RequestBody E3gJv e3gJv) {
    e3gJv.id = e3gJvsId;
    E3gJvEntity node = null;
    if (e3gJvRepository.findById(e3gJv.id).isPresent())
      node = e3gJvRepository.findById(e3gJv.id).get();
    else {
      node = new E3gJvEntity();
      node.setId(e3gJv.id);
    }
    node.setName(e3gJv.name);
    node.setValue(e3gJv.value);
    // save the entity
    e3gJvRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/e3gJvs/{e3gJvsId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<E3gJv> getE3gJvById(@PathVariable(name = "e3gJvsId") Integer e3gJvsId) {
    if (!e3gJvRepository.findById(e3gJvsId).isPresent()) return ResponseEntity.status(404).build();
    E3gJv dto = e3gJvRepository.findById(e3gJvsId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/e3gJvs",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<E3gJv>> getAllE3gJv() {
    List<E3gJv> allDtos = new ArrayList<>();
    for (E3gJvEntity e : e3gJvRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/e3gJvs/{e3gJvsId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateE3gJvByValues(
      @PathVariable(name = "e3gJvsId") Integer e3gJvsId,
      @RequestParam(name = "e3gJvsname", required = false) String e3gJvsname,
      @RequestParam(name = "e3gJvsvalue", required = false) Integer e3gJvsvalue) {
    if (!e3gJvRepository.findById(e3gJvsId).isPresent()) return ResponseEntity.status(404).build();
    E3gJvEntity node = e3gJvRepository.findById(e3gJvsId).get();
    if (e3gJvsname != null) {
      node.setName(e3gJvsname);
    }
    if (e3gJvsvalue != null) {
      node.setValue(e3gJvsvalue);
    }
    // save the entity
    e3gJvRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/e3gJvs/{e3gJvsId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteE3gJv(@PathVariable(name = "e3gJvsId") Integer e3gJvsId) {
    // an entity with id e3gJvsId should exist
    if (!e3gJvRepository.findById(e3gJvsId).isPresent()) return ResponseEntity.status(404).build();
    e3gJvRepository.deleteById(e3gJvsId);
    return ResponseEntity.status(200).build();
  }
}