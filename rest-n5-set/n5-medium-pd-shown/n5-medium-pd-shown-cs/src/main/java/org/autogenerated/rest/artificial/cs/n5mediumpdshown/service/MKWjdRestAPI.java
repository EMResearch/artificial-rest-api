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
public class MKWjdRestAPI {
  @Autowired private MKWjdRepository mKWjdRepository;

  @RequestMapping(
      value = "/mKWjds",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createMKWjd(@RequestBody MKWjd mKWjd) {
    // an entity with id mKWjd.id should not exist
    if (mKWjdRepository.findById(mKWjd.id).isPresent()) return ResponseEntity.status(400).build();
    MKWjdEntity node = new MKWjdEntity();
    node.setId(mKWjd.id);
    node.setName(mKWjd.name);
    node.setValue(mKWjd.value);
    // save the entity
    mKWjdRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/mKWjds/{mKWjdsId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateMKWjd(
      @PathVariable(name = "mKWjdsId") Integer mKWjdsId, @RequestBody MKWjd mKWjd) {
    mKWjd.id = mKWjdsId;
    MKWjdEntity node = null;
    if (mKWjdRepository.findById(mKWjd.id).isPresent())
      node = mKWjdRepository.findById(mKWjd.id).get();
    else {
      node = new MKWjdEntity();
      node.setId(mKWjd.id);
    }
    node.setName(mKWjd.name);
    node.setValue(mKWjd.value);
    // save the entity
    mKWjdRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/mKWjds/{mKWjdsId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<MKWjd> getMKWjdById(@PathVariable(name = "mKWjdsId") Integer mKWjdsId) {
    if (!mKWjdRepository.findById(mKWjdsId).isPresent()) return ResponseEntity.status(404).build();
    MKWjd dto = mKWjdRepository.findById(mKWjdsId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/mKWjds",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<MKWjd>> getAllMKWjd() {
    List<MKWjd> allDtos = new ArrayList<>();
    for (MKWjdEntity e : mKWjdRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/mKWjds/{mKWjdsId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateMKWjdByValues(
      @PathVariable(name = "mKWjdsId") Integer mKWjdsId,
      @RequestParam(name = "mKWjdsname", required = false) String mKWjdsname,
      @RequestParam(name = "mKWjdsvalue", required = false) Integer mKWjdsvalue) {
    if (!mKWjdRepository.findById(mKWjdsId).isPresent()) return ResponseEntity.status(404).build();
    MKWjdEntity node = mKWjdRepository.findById(mKWjdsId).get();
    if (mKWjdsname != null) {
      node.setName(mKWjdsname);
    }
    if (mKWjdsvalue != null) {
      node.setValue(mKWjdsvalue);
    }
    // save the entity
    mKWjdRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/mKWjds/{mKWjdsId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteMKWjd(@PathVariable(name = "mKWjdsId") Integer mKWjdsId) {
    // an entity with id mKWjdsId should exist
    if (!mKWjdRepository.findById(mKWjdsId).isPresent()) return ResponseEntity.status(404).build();
    mKWjdRepository.deleteById(mKWjdsId);
    return ResponseEntity.status(200).build();
  }
}
