package org.autogenerated.rest.artificial.cs.n5sparsehide.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.autogenerated.rest.artificial.cs.n5sparsehide.dto.*;
/** automatically created on 2020-01-14 */
@Entity
@Table(name = "X7Qey")
public class X7QeyEntity {
  public X7QeyEntity() {}

  public X7QeyEntity(Integer id_var, String name_var, Integer value_var) {
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

  public X7Qey getDto() {
    X7Qey dto = new X7Qey();
    dto.id = this.getId();
    dto.name = this.getName();
    dto.value = this.getValue();
    return dto;
  }
}