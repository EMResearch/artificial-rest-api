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
public class B8v25RestAPI {
  @Autowired private B8v25Repository b8v25Repository;

  @RequestMapping(
      value = "/b8v25s",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createB8v25(@RequestBody B8v25 b8v25) {
    // an entity with id b8v25.id should not exist
    if (b8v25Repository.findById(b8v25.id).isPresent()) return ResponseEntity.status(400).build();
    B8v25Entity node = new B8v25Entity();
    node.setId(b8v25.id);
    node.setName(b8v25.name);
    node.setValue(b8v25.value);
    // save the entity
    b8v25Repository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/b8v25s/{b8v25sId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateB8v25(
      @PathVariable(name = "b8v25sId") Integer b8v25sId, @RequestBody B8v25 b8v25) {
    b8v25.id = b8v25sId;
    B8v25Entity node = null;
    if (b8v25Repository.findById(b8v25.id).isPresent())
      node = b8v25Repository.findById(b8v25.id).get();
    else {
      node = new B8v25Entity();
      node.setId(b8v25.id);
    }
    node.setName(b8v25.name);
    node.setValue(b8v25.value);
    // save the entity
    b8v25Repository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/b8v25s/{b8v25sId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<B8v25> getB8v25ById(@PathVariable(name = "b8v25sId") Integer b8v25sId) {
    if (!b8v25Repository.findById(b8v25sId).isPresent()) return ResponseEntity.status(404).build();
    B8v25 dto = b8v25Repository.findById(b8v25sId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/b8v25s",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<B8v25>> getAllB8v25() {
    List<B8v25> allDtos = new ArrayList<>();
    for (B8v25Entity e : b8v25Repository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/b8v25s/{b8v25sId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateB8v25ByValues(
      @PathVariable(name = "b8v25sId") Integer b8v25sId,
      @RequestParam(name = "b8v25sname", required = false) String b8v25sname,
      @RequestParam(name = "b8v25svalue", required = false) Integer b8v25svalue) {
    if (!b8v25Repository.findById(b8v25sId).isPresent()) return ResponseEntity.status(404).build();
    B8v25Entity node = b8v25Repository.findById(b8v25sId).get();
    if (b8v25sname != null) {
      node.setName(b8v25sname);
    }
    if (b8v25svalue != null) {
      node.setValue(b8v25svalue);
    }
    // save the entity
    b8v25Repository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/b8v25s/{b8v25sId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteB8v25(@PathVariable(name = "b8v25sId") Integer b8v25sId) {
    // an entity with id b8v25sId should exist
    if (!b8v25Repository.findById(b8v25sId).isPresent()) return ResponseEntity.status(404).build();
    b8v25Repository.deleteById(b8v25sId);
    return ResponseEntity.status(200).build();
  }
}