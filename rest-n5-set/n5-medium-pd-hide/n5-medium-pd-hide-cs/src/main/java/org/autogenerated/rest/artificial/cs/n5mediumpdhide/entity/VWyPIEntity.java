package org.autogenerated.rest.artificial.cs.n5mediumpdhide.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.autogenerated.rest.artificial.cs.n5mediumpdhide.dto.*;
/** automatically created on 2020-01-14 */
@Entity
@Table(name = "VWyPI")
public class VWyPIEntity {
  public VWyPIEntity() {}

  public VWyPIEntity(Integer id_var, String name_var, Integer value_var, XfPcdEntity xfPcd_var) {
    this.id = id_var;
    this.name = name_var;
    this.value = value_var;
    this.xfPcd = xfPcd_var;
  }

  @Id @NotNull private Integer id;
  @NotNull private String name;
  @NotNull private Integer value;
  @NotNull @OneToOne private XfPcdEntity xfPcd;

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

  public void setXfPcd(XfPcdEntity xfPcd) {
    this.xfPcd = xfPcd;
  }

  public XfPcdEntity getXfPcd() {
    return this.xfPcd;
  }

  public VWyPI getDto() {
    VWyPI dto = new VWyPI();
    dto.id = this.getId();
    dto.name = this.getName();
    dto.value = this.getValue();
    dto.xfPcdId = this.getXfPcd().getId();
    return dto;
  }
}
