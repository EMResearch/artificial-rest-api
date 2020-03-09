package org.autogenerated.rest.artificial.cs.n5densepdshown.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.autogenerated.rest.artificial.cs.n5densepdshown.dto.*;
/** automatically created on 2020-01-14 */
@Entity
@Table(name = "UEear")
public class UEearEntity {
  public UEearEntity() {}

  public UEearEntity(
      Integer id_var,
      String name_var,
      Integer value_var,
      B8v25Entity b8v25_var,
      IUJWoEntity iUJWo_var,
      OEXmzEntity ownedOEXmz_var,
      W27dtEntity ownedW27dt_var) {
    this.id = id_var;
    this.name = name_var;
    this.value = value_var;
    this.b8v25 = b8v25_var;
    this.iUJWo = iUJWo_var;
    this.ownedOEXmz = ownedOEXmz_var;
    this.ownedW27dt = ownedW27dt_var;
  }

  @Id @NotNull private Integer id;
  @NotNull private String name;
  @NotNull private Integer value;
  @NotNull @OneToOne private B8v25Entity b8v25;
  @NotNull @OneToOne private IUJWoEntity iUJWo;

  @NotNull
  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  private OEXmzEntity ownedOEXmz;

  @NotNull
  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  private W27dtEntity ownedW27dt;

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

  public void setB8v25(B8v25Entity b8v25) {
    this.b8v25 = b8v25;
  }

  public B8v25Entity getB8v25() {
    return this.b8v25;
  }

  public void setIUJWo(IUJWoEntity iUJWo) {
    this.iUJWo = iUJWo;
  }

  public IUJWoEntity getIUJWo() {
    return this.iUJWo;
  }

  public void setOwnedOEXmz(OEXmzEntity ownedOEXmz) {
    this.ownedOEXmz = ownedOEXmz;
  }

  public OEXmzEntity getOwnedOEXmz() {
    return this.ownedOEXmz;
  }

  public void setOwnedW27dt(W27dtEntity ownedW27dt) {
    this.ownedW27dt = ownedW27dt;
  }

  public W27dtEntity getOwnedW27dt() {
    return this.ownedW27dt;
  }

  public UEear getDto() {
    UEear dto = new UEear();
    dto.id = this.getId();
    dto.name = this.getName();
    dto.value = this.getValue();
    dto.b8v25Id = this.getB8v25().getId();
    dto.iUJWoId = this.getIUJWo().getId();
    dto.oEXmzId = this.getOwnedOEXmz().getId();
    dto.oEXmzName = this.getOwnedOEXmz().getName();
    dto.oEXmzValue = this.getOwnedOEXmz().getValue();
    dto.w27dtId = this.getOwnedW27dt().getId();
    dto.w27dtName = this.getOwnedW27dt().getName();
    dto.w27dtValue = this.getOwnedW27dt().getValue();
    return dto;
  }
}