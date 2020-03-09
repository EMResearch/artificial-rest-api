package org.autogenerated.rest.artificial.cs.n5mediumhide.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.autogenerated.rest.artificial.cs.n5mediumhide.dto.*;
/** automatically created on 2020-01-14 */
@Entity
@Table(name = "VIL0S")
public class VIL0SEntity {
  public VIL0SEntity() {}

  public VIL0SEntity(Integer id_var, String name_var, Integer value_var, HErqDEntity hErqD_var) {
    this.id = id_var;
    this.name = name_var;
    this.value = value_var;
    this.hErqD = hErqD_var;
  }

  @Id @NotNull private Integer id;
  @NotNull private String name;
  @NotNull private Integer value;
  @NotNull @OneToOne private HErqDEntity hErqD;

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

  public void setHErqD(HErqDEntity hErqD) {
    this.hErqD = hErqD;
  }

  public HErqDEntity getHErqD() {
    return this.hErqD;
  }

  public VIL0S getDto() {
    VIL0S dto = new VIL0S();
    dto.id = this.getId();
    dto.name = this.getName();
    dto.value = this.getValue();
    dto.hErqDId = this.getHErqD().getId();
    return dto;
  }
}