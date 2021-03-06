package org.autogenerated.rest.artificial.cs.n5mediumpdhide.service;

import org.autogenerated.rest.artificial.cs.n5mediumpdhide.entity.*;
import org.autogenerated.rest.artificial.cs.n5mediumpdhide.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
/** automatically created on 2020-01-14 */
@RestController
@RequestMapping(path = "/api")
public class XfPcdRestAPI {
  @Autowired private XfPcdRepository xfPcdRepository;

  @RequestMapping(
      value = "/xfPcds",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createXfPcd(@RequestBody XfPcd xfPcd) {
    // an entity with id xfPcd.id should not exist
    if (xfPcdRepository.findById(xfPcd.id).isPresent()) return ResponseEntity.status(400).build();
    XfPcdEntity node = new XfPcdEntity();
    node.setId(xfPcd.id);
    node.setName(xfPcd.name);
    node.setValue(xfPcd.value);
    // save the entity
    xfPcdRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/xfPcds/{xfPcdsId}",
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON)
  public ResponseEntity createOrUpdateXfPcd(
      @PathVariable(name = "xfPcdsId") Integer xfPcdsId, @RequestBody XfPcd xfPcd) {
    xfPcd.id = xfPcdsId;
    XfPcdEntity node = null;
    if (xfPcdRepository.findById(xfPcd.id).isPresent())
      node = xfPcdRepository.findById(xfPcd.id).get();
    else {
      node = new XfPcdEntity();
      node.setId(xfPcd.id);
    }
    node.setName(xfPcd.name);
    node.setValue(xfPcd.value);
    // save the entity
    xfPcdRepository.save(node);
    return ResponseEntity.status(201).build();
  }

  @RequestMapping(
      value = "/xfPcds/{xfPcdsId}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<XfPcd> getXfPcdById(@PathVariable(name = "xfPcdsId") Integer xfPcdsId) {
    if (!xfPcdRepository.findById(xfPcdsId).isPresent()) return ResponseEntity.status(404).build();
    XfPcd dto = xfPcdRepository.findById(xfPcdsId).get().getDto();
    return ResponseEntity.ok(dto);
  }

  @RequestMapping(
      value = "/xfPcds",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<XfPcd>> getAllXfPcd() {
    List<XfPcd> allDtos = new ArrayList<>();
    for (XfPcdEntity e : xfPcdRepository.findAll()) {
      allDtos.add(e.getDto());
    }
    return ResponseEntity.ok(allDtos);
  }

  @RequestMapping(
      value = "/xfPcds/{xfPcdsId}",
      method = RequestMethod.PATCH,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity updateXfPcdByValues(
      @PathVariable(name = "xfPcdsId") Integer xfPcdsId,
      @RequestParam(name = "xfPcdsname", required = false) String xfPcdsname,
      @RequestParam(name = "xfPcdsvalue", required = false) Integer xfPcdsvalue) {
    if (!xfPcdRepository.findById(xfPcdsId).isPresent()) return ResponseEntity.status(404).build();
    XfPcdEntity node = xfPcdRepository.findById(xfPcdsId).get();
    if (xfPcdsname != null) {
      node.setName(xfPcdsname);
    }
    if (xfPcdsvalue != null) {
      node.setValue(xfPcdsvalue);
    }
    // save the entity
    xfPcdRepository.save(node);
    return ResponseEntity.status(200).build();
  }

  @RequestMapping(
      value = "/xfPcds/{xfPcdsId}",
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON)
  public ResponseEntity deleteXfPcd(@PathVariable(name = "xfPcdsId") Integer xfPcdsId) {
    // an entity with id xfPcdsId should exist
    if (!xfPcdRepository.findById(xfPcdsId).isPresent()) return ResponseEntity.status(404).build();
    xfPcdRepository.deleteById(xfPcdsId);
    return ResponseEntity.status(200).build();
  }
}
