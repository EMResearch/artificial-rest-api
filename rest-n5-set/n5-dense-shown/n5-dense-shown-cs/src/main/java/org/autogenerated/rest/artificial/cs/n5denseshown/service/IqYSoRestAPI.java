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
public class IqYSoRestAPI {
  @Autowired private IqYSoRepository iqYSoRepository;

  @RequestMapping(
      value = "/iqYSos",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createIqYSo(@RequestBody IqYSo iqYSo) {
    // an entity with id iqYSo.id should not exist
    if (iqYSoRepository.findById(iqYSo.id).isPresent()) return ResponseEntity.status(400).build();
    IqYSoEntity node = new IqYSoEntity();
    node.setId(iqYSo.id);
    node.setName(iqYSo.name);
    node.setValue(iqYSo.value);
    // save the entity
    iqYSoRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/iqYSos/{iqYSosId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateIqYSo(
      @PathVariable(name = "iqYSosId") Integer iqYSosId, @RequestBody IqYSo iqYSo) {
    iqYSo.id = iqYSosId;
    IqYSoEntity node = null;
    if (iqYSoRepository.findById(iqYSo.id).isPresent())
      node = iqYSoRepository.findById(iqYSo.id).get();
    else {
      node = new IqYSoEntity();
      node.setId(iqYSo.id);
    }
    node.setName(iqYSo.name);
    node.setValue(iqYSo.value);
    // save the entity
    iqYSoRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/iqYSos/{iqYSosId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<IqYSo> getIqYSoById(@PathVariable(name = "iqYSosId") Integer iqYSosId) {
    if (!iqYSoRepository.findById(iqYSosId).isPresent()) return ResponseEntity.status(404).build();
    IqYSo dto = iqYSoRepository.findById(iqYSosId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/iqYSos",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<IqYSo>> getAllIqYSo() {
    List<IqYSo> allDtos = new ArrayList<>();
    for (IqYSoEntity e : iqYSoRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/iqYSos/{iqYSosId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateIqYSoByValues(
      @PathVariable(name = "iqYSosId") Integer iqYSosId,
      @RequestParam(name = "iqYSosname", required = false) String iqYSosname,
      @RequestParam(name = "iqYSosvalue", required = false) Integer iqYSosvalue) {
    if (!iqYSoRepository.findById(iqYSosId).isPresent()) return ResponseEntity.status(404).build();
    IqYSoEntity node = iqYSoRepository.findById(iqYSosId).get();
    if (iqYSosname != null) {
      node.setName(iqYSosname);
    }
    if (iqYSosvalue != null) {
      node.setValue(iqYSosvalue);
    }
    // save the entity
    iqYSoRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/iqYSos/{iqYSosId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteIqYSo(@PathVariable(name = "iqYSosId") Integer iqYSosId) {
    // an entity with id iqYSosId should exist
    if (!iqYSoRepository.findById(iqYSosId).isPresent()) return ResponseEntity.status(404).build();
    iqYSoRepository.deleteById(iqYSosId);
    return ResponseEntity.status(200).build();
  }
}
