package org.autogenerated.rest.artificial.cs.n5densepdshown.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.autogenerated.rest.artificial.cs.n5densepdshown.dto.*;
/** automatically created on 2020-01-14 */
@Entity
@Table(name = "IUJWo")
public class IUJWoEntity {
  public IUJWoEntity() {}

  public IUJWoEntity(Integer id_var, String name_var, Integer value_var) {
    this.id = id_var;
    this.name = name_var;
    this.value = value_var;
  }

  @Id @NotNull private Integer id;
  @NotNull private String name;
  @NotNull private Integer value;

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

  public IUJWo getDto() {
    IUJWo dto = new IUJWo();
    dto.id = this.getId();
    dto.name = this.getName();
    dto.value = this.getValue();
    return dto;
  }
}
