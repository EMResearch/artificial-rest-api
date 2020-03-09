package org.autogenerated.rest.artificial.cs.n5densehide.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.autogenerated.rest.artificial.cs.n5densehide.dto.*;
/** automatically created on 2020-01-14 */
@Entity
@Table(name = "Hvltg")
public class HvltgEntity {
  public HvltgEntity() {}

  public HvltgEntity(
      Integer id_var,
      String name_var,
      Integer value_var,
      YaDPDEntity yaDPD_var,
      KuGn6Entity kuGn6_var,
      NSPiiEntity ownedNSPii_var,
      WUaJGEntity ownedWUaJG_var) {
    this.id = id_var;
    this.name = name_var;
    this.value = value_var;
    this.yaDPD = yaDPD_var;
    this.kuGn6 = kuGn6_var;
    this.ownedNSPii = ownedNSPii_var;
    this.ownedWUaJG = ownedWUaJG_var;
  }

  @Id @NotNull private Integer id;
  @NotNull private String name;
  @NotNull private Integer value;
  @NotNull @OneToOne private YaDPDEntity yaDPD;
  @NotNull @OneToOne private KuGn6Entity kuGn6;

  @NotNull
  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  private NSPiiEntity ownedNSPii;

  @NotNull
  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  private WUaJGEntity ownedWUaJG;

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

  public void setYaDPD(YaDPDEntity yaDPD) {
    this.yaDPD = yaDPD;
  }

  public YaDPDEntity getYaDPD() {
    return this.yaDPD;
  }

  public void setKuGn6(KuGn6Entity kuGn6) {
    this.kuGn6 = kuGn6;
  }

  public KuGn6Entity getKuGn6() {
    return this.kuGn6;
  }

  public void setOwnedNSPii(NSPiiEntity ownedNSPii) {
    this.ownedNSPii = ownedNSPii;
  }

  public NSPiiEntity getOwnedNSPii() {
    return this.ownedNSPii;
  }

  public void setOwnedWUaJG(WUaJGEntity ownedWUaJG) {
    this.ownedWUaJG = ownedWUaJG;
  }

  public WUaJGEntity getOwnedWUaJG() {
    return this.ownedWUaJG;
  }

  public Hvltg getDto() {
    Hvltg dto = new Hvltg();
    dto.id = this.getId();
    dto.name = this.getName();
    dto.value = this.getValue();
    dto.yaDPDId = this.getYaDPD().getId();
    dto.kuGn6Id = this.getKuGn6().getId();
    dto.nSPiiId = this.getOwnedNSPii().getId();
    dto.nSPiiName = this.getOwnedNSPii().getName();
    dto.nSPiiValue = this.getOwnedNSPii().getValue();
    dto.wUaJGId = this.getOwnedWUaJG().getId();
    dto.wUaJGName = this.getOwnedWUaJG().getName();
    dto.wUaJGValue = this.getOwnedWUaJG().getValue();
    return dto;
  }
}