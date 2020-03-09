package org.autogenerated.rest.artificial.cs.n5mediumpdshown.service;

import org.autogenerated.rest.artificial.cs.n5mediumpdshown.entity.*;
import org.autogenerated.rest.artificial.cs.n5mediumpdshown.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
/** automatically created on 2020-01-14 */
@RestController
@RequestMapping(path = "/api")
public class Yag8eRestAPI {
  @Autowired private Yag8eRepository yag8eRepository;
  @Autowired private HGss7Repository hGss7Repository;

  @RequestMapping(
      value = "/i4AFGs/{i4AFGId}/s5htzs/{s5htzId}/hGss7s/{hGss7Id}/yag8es",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createYag8e(
      @RequestBody Yag8e yag8e,
      @PathVariable(name = "hGss7Id") Integer hGss7Id,
      @PathVariable(name = "i4AFGId") Integer i4AFGId,
      @PathVariable(name = "s5htzId") Integer s5htzId) {
    // an entity with id yag8e.id should not exist
    if (yag8eRepository.findById(yag8e.id).isPresent()) return ResponseEntity.status(400).build();
    Yag8eEntity node = new Yag8eEntity();
    node.setId(yag8e.id);
    // refer to related entity
    if (!hGss7Repository.findById(yag8e.hGss7Id).isPresent())
      return ResponseEntity.status(404).build();
    HGss7Entity referVarToHGss7Entity = hGss7Repository.findById(yag8e.hGss7Id).get();
    node.setHGss7(referVarToHGss7Entity);
    node.setName(yag8e.name);
    node.setValue(yag8e.value);
    // additional codes for handling dependency
    if (!(node.getValue() == referVarToHGss7Entity.getValue()))
      return ResponseEntity.status(400).build();
    // save the entity
    yag8eRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/i4AFGs/{i4AFGId}/s5htzs/{s5htzId}/hGss7s/{hGss7Id}/yag8es/{yag8esId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateYag8e(
      @PathVariable(name = "yag8esId") Integer yag8esId,
      @RequestBody Yag8e yag8e,
      @PathVariable(name = "hGss7Id") Integer hGss7Id,
      @PathVariable(name = "i4AFGId") Integer i4AFGId,
      @PathVariable(name = "s5htzId") Integer s5htzId) {
    yag8e.id = yag8esId;
    Yag8eEntity node = null;
    if (yag8eRepository.findById(yag8e.id).isPresent())
      node = yag8eRepository.findById(yag8e.id).get();
    else {
      node = new Yag8eEntity();
      node.setId(yag8e.id);
    }
    // refer to related entity
    if (!hGss7Repository.findById(yag8e.hGss7Id).isPresent())
      return ResponseEntity.status(404).build();
    HGss7Entity referVarToHGss7Entity = hGss7Repository.findById(yag8e.hGss7Id).get();
    node.setHGss7(referVarToHGss7Entity);
    node.setName(yag8e.name);
    node.setValue(yag8e.value);
    // additional codes for handling dependency
    if (!(node.getValue() == referVarToHGss7Entity.getValue()))
      return ResponseEntity.status(400).build();
    // save the entity
    yag8eRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/i4AFGs/{i4AFGId}/s5htzs/{s5htzId}/hGss7s/{hGss7Id}/yag8es/{yag8esId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<Yag8e> getYag8eById(
      @PathVariable(name = "yag8esId") Integer yag8esId,
      @PathVariable(name = "hGss7Id") Integer hGss7Id,
      @PathVariable(name = "i4AFGId") Integer i4AFGId,
      @PathVariable(name = "s5htzId") Integer s5htzId) {
    if (!yag8eRepository.findById(yag8esId).isPresent()) return ResponseEntity.status(404).build();
    Yag8e dto = yag8eRepository.findById(yag8esId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/i4AFGs/{i4AFGId}/s5htzs/{s5htzId}/hGss7s/{hGss7Id}/yag8es",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<Yag8e>> getAllWithConditionYag8e(
      @PathVariable(name = "hGss7Id") Integer hGss7Id,
      @PathVariable(name = "i4AFGId") Integer i4AFGId,
      @PathVariable(name = "s5htzId") Integer s5htzId) {
    List<Yag8e> allDtos = new ArrayList<>();
    for (Yag8eEntity e : yag8eRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/i4AFGs/{i4AFGId}/s5htzs/{s5htzId}/hGss7s/{hGss7Id}/yag8es/{yag8esId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateYag8eByValues(
      @PathVariable(name = "yag8esId") Integer yag8esId,
      @RequestParam(name = "yag8esname", required = false) String yag8esname,
      @RequestParam(name = "yag8esvalue", required = false) Integer yag8esvalue,
      @PathVariable(name = "hGss7Id") Integer hGss7Id,
      @PathVariable(name = "i4AFGId") Integer i4AFGId,
      @PathVariable(name = "s5htzId") Integer s5htzId) {
    if (!yag8eRepository.findById(yag8esId).isPresent()) return ResponseEntity.status(404).build();
    Yag8eEntity node = yag8eRepository.findById(yag8esId).get();
    // refer to related entity
    HGss7Entity referVarToHGss7Entity = null;
    if (hGss7Id != null) {
      if (!hGss7Repository.findById(hGss7Id).isPresent()) return ResponseEntity.status(400).build();
      referVarToHGss7Entity = hGss7Repository.findById(hGss7Id).get();
      node.setHGss7(referVarToHGss7Entity);
    } else {
      referVarToHGss7Entity = node.getHGss7();
    }
    if (yag8esname != null) {
      node.setName(yag8esname);
    }
    if (yag8esvalue != null) {
      node.setValue(yag8esvalue);
    }
    // additional codes for handling dependency
    if (!(node.getValue() == referVarToHGss7Entity.getValue()))
      return ResponseEntity.status(400).build();
    // save the entity
    yag8eRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/i4AFGs/{i4AFGId}/s5htzs/{s5htzId}/hGss7s/{hGss7Id}/yag8es/{yag8esId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteWithConditionYag8e(
      @PathVariable(name = "yag8esId") Integer yag8esId,
      @PathVariable(name = "hGss7Id") Integer hGss7Id,
      @PathVariable(name = "i4AFGId") Integer i4AFGId,
      @PathVariable(name = "s5htzId") Integer s5htzId) {
    // an entity with id yag8esId should exist
    if (!yag8eRepository.findById(yag8esId).isPresent()) return ResponseEntity.status(404).build();
    yag8eRepository.deleteById(yag8esId);
    return ResponseEntity.status(200).build();
  }
}
