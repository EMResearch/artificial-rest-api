package org.autogenerated.rest.artificial.cs.n5mediumhide.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.autogenerated.rest.artificial.cs.n5mediumhide.dto.*;
/** automatically created on 2020-01-14 */
@Entity
@Table(name = "XpOCt")
public class XpOCtEntity {
  public XpOCtEntity() {}

  public XpOCtEntity(Integer id_var, String name_var, Integer value_var, U1rAlEntity u1rAl_var) {
    this.id = id_var;
    this.name = name_var;
    this.value = value_var;
    this.u1rAl = u1rAl_var;
  }

  @Id @NotNull private Integer id;
  @NotNull private String name;
  @NotNull private Integer value;
  @NotNull @OneToOne private U1rAlEntity u1rAl;

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return this.id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }

  public void setU1rAl(U1rAlEntity u1rAl) {
    this.u1rAl = u1rAl;
  }

  public U1rAlEntity getU1rAl() {
    return this.u1rAl;
  }

  public XpOCt getDto() {
    XpOCt dto = new XpOCt();
    dto.id = this.getId();
    dto.name = this.getName();
    dto.value = this.getValue();
    dto.u1rAlId = this.getU1rAl().getId();
    return dto;
  }
}
