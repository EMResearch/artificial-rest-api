package org.autogenerated.rest.artificial.cs.n5sparseshown.service;

import org.autogenerated.rest.artificial.cs.n5sparseshown.entity.*;
import org.autogenerated.rest.artificial.cs.n5sparseshown.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
/** automatically created on 2020-01-14 */
@RestController
@RequestMapping(path = "/api")
public class YQQIqRestAPI {
  @Autowired private YQQIqRepository yQQIqRepository;
  @Autowired private DioO1Repository dioO1Repository;

  @RequestMapping(
      value = "/dioO1s/{dioO1Id}/yQQIqs",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createYQQIq(
      @RequestBody YQQIq yQQIq, @PathVariable(name = "dioO1Id") Integer dioO1Id) {
    // an entity with id yQQIq.id should not exist
    if (yQQIqRepository.findById(yQQIq.id).isPresent()) return ResponseEntity.status(400).build();
    YQQIqEntity node = new YQQIqEntity();
    node.setId(yQQIq.id);
    // refer to related entity
    if (!dioO1Repository.findById(yQQIq.dioO1Id).isPresent())
      return ResponseEntity.status(404).build();
    DioO1Entity referVarToDioO1Entity = dioO1Repository.findById(yQQIq.dioO1Id).get();
    node.setDioO1(referVarToDioO1Entity);
    node.setName(yQQIq.name);
    node.setValue(yQQIq.value);
    // save the entity
    yQQIqRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/dioO1s/{dioO1Id}/yQQIqs/{yQQIqsId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateYQQIq(
      @PathVariable(name = "yQQIqsId") Integer yQQIqsId,
      @RequestBody YQQIq yQQIq,
      @PathVariable(name = "dioO1Id") Integer dioO1Id) {
    yQQIq.id = yQQIqsId;
    YQQIqEntity node = null;
    if (yQQIqRepository.findById(yQQIq.id).isPresent())
      node = yQQIqRepository.findById(yQQIq.id).get();
    else {
      node = new YQQIqEntity();
      node.setId(yQQIq.id);
    }
    // refer to related entity
    if (!dioO1Repository.findById(yQQIq.dioO1Id).isPresent())
      return ResponseEntity.status(404).build();
    DioO1Entity referVarToDioO1Entity = dioO1Repository.findById(yQQIq.dioO1Id).get();
    node.setDioO1(referVarToDioO1Entity);
    node.setName(yQQIq.name);
    node.setValue(yQQIq.value);
    // save the entity
    yQQIqRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/dioO1s/{dioO1Id}/yQQIqs/{yQQIqsId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<YQQIq> getYQQIqById(
      @PathVariable(name = "yQQIqsId") Integer yQQIqsId,
      @PathVariable(name = "dioO1Id") Integer dioO1Id) {
    if (!yQQIqRepository.findById(yQQIqsId).isPresent()) return ResponseEntity.status(404).build();
    YQQIq dto = yQQIqRepository.findById(yQQIqsId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/dioO1s/{dioO1Id}/yQQIqs",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<YQQIq>> getAllWithConditionYQQIq(
      @PathVariable(name = "dioO1Id") Integer dioO1Id) {
    List<YQQIq> allDtos = new ArrayList<>();
    for (YQQIqEntity e : yQQIqRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/dioO1s/{dioO1Id}/yQQIqs/{yQQIqsId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateYQQIqByValues(
      @PathVariable(name = "yQQIqsId") Integer yQQIqsId,
      @RequestParam(name = "yQQIqsname", required = false) String yQQIqsname,
      @RequestParam(name = "yQQIqsvalue", required = false) Integer yQQIqsvalue,
      @PathVariable(name = "dioO1Id") Integer dioO1Id) {
    if (!yQQIqRepository.findById(yQQIqsId).isPresent()) return ResponseEntity.status(404).build();
    YQQIqEntity node = yQQIqRepository.findById(yQQIqsId).get();
    // refer to related entity
    DioO1Entity referVarToDioO1Entity = null;
    if (dioO1Id != null) {
      if (!dioO1Repository.findById(dioO1Id).isPresent()) return ResponseEntity.status(400).build();
      referVarToDioO1Entity = dioO1Repository.findById(dioO1Id).get();
      node.setDioO1(referVarToDioO1Entity);
    } else {
      referVarToDioO1Entity = node.getDioO1();
    }
    if (yQQIqsname != null) {
      node.setName(yQQIqsname);
    }
    if (yQQIqsvalue != null) {
      node.setValue(yQQIqsvalue);
    }
    // save the entity
    yQQIqRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/dioO1s/{dioO1Id}/yQQIqs/{yQQIqsId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteWithConditionYQQIq(
      @PathVariable(name = "yQQIqsId") Integer yQQIqsId,
      @PathVariable(name = "dioO1Id") Integer dioO1Id) {
    // an entity with id yQQIqsId should exist
    if (!yQQIqRepository.findById(yQQIqsId).isPresent()) return ResponseEntity.status(404).build();
    yQQIqRepository.deleteById(yQQIqsId);
    return ResponseEntity.status(200).build();
  }
}
