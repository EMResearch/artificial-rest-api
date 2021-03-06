package org.autogenerated.rest.artificial.cs.n5densepdshown.service;

import org.autogenerated.rest.artificial.cs.n5densepdshown.entity.*;
import org.autogenerated.rest.artificial.cs.n5densepdshown.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
/** automatically created on 2020-01-14 */
@RestController
@RequestMapping(path = "/api")
public class IUJWoRestAPI {
  @Autowired private IUJWoRepository iUJWoRepository;

  @RequestMapping(
      value = "/iUJWos",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createIUJWo(@RequestBody IUJWo iUJWo) {
    // an entity with id iUJWo.id should not exist
    if (iUJWoRepository.findById(iUJWo.id).isPresent()) return ResponseEntity.status(400).build();
    IUJWoEntity node = new IUJWoEntity();
    node.setId(iUJWo.id);
    node.setName(iUJWo.name);
    node.setValue(iUJWo.value);
    // save the entity
    iUJWoRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/iUJWos/{iUJWosId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateIUJWo(
      @PathVariable(name = "iUJWosId") Integer iUJWosId, @RequestBody IUJWo iUJWo) {
    iUJWo.id = iUJWosId;
    IUJWoEntity node = null;
    if (iUJWoRepository.findById(iUJWo.id).isPresent())
      node = iUJWoRepository.findById(iUJWo.id).get();
    else {
      node = new IUJWoEntity();
      node.setId(iUJWo.id);
    }
    node.setName(iUJWo.name);
    node.setValue(iUJWo.value);
    // save the entity
    iUJWoRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/iUJWos/{iUJWosId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<IUJWo> getIUJWoById(@PathVariable(name = "iUJWosId") Integer iUJWosId) {
    if (!iUJWoRepository.findById(iUJWosId).isPresent()) return ResponseEntity.status(404).build();
    IUJWo dto = iUJWoRepository.findById(iUJWosId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/iUJWos",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<IUJWo>> getAllIUJWo() {
    List<IUJWo> allDtos = new ArrayList<>();
    for (IUJWoEntity e : iUJWoRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/iUJWos/{iUJWosId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateIUJWoByValues(
      @PathVariable(name = "iUJWosId") Integer iUJWosId,
      @RequestParam(name = "iUJWosname", required = false) String iUJWosname,
      @RequestParam(name = "iUJWosvalue", required = false) Integer iUJWosvalue) {
    if (!iUJWoRepository.findById(iUJWosId).isPresent()) return ResponseEntity.status(404).build();
    IUJWoEntity node = iUJWoRepository.findById(iUJWosId).get();
    if (iUJWosname != null) {
      node.setName(iUJWosname);
    }
    if (iUJWosvalue != null) {
      node.setValue(iUJWosvalue);
    }
    // save the entity
    iUJWoRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/iUJWos/{iUJWosId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteIUJWo(@PathVariable(name = "iUJWosId") Integer iUJWosId) {
    // an entity with id iUJWosId should exist
    if (!iUJWoRepository.findById(iUJWosId).isPresent()) return ResponseEntity.status(404).build();
    iUJWoRepository.deleteById(iUJWosId);
    return ResponseEntity.status(200).build();
  }
}
