package org.autogenerated.rest.artificial.cs.n5mediumhide.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.autogenerated.rest.artificial.cs.n5mediumhide.dto.*;
/** automatically created on 2020-01-14 */
@Entity
@Table(name = "GqxtS")
public class GqxtSEntity {
  public GqxtSEntity() {}

  public GqxtSEntity(Integer id_var, String name_var, Integer value_var) {
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

  public GqxtS getDto() {
    GqxtS dto = new GqxtS();
    dto.id = this.getId();
    dto.name = this.getName();
    dto.value = this.getValue();
    return dto;
  }
}
