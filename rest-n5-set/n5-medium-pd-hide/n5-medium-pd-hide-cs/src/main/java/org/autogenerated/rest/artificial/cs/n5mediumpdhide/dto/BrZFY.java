package org.autogenerated.rest.artificial.cs.n5mediumpdhide.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/** automatically created on 2020-01-14 */
@ApiModel
public class BrZFY {
  public BrZFY() {}

  public BrZFY(Integer id_var, String name_var, Integer value_var, Integer rpZ1MId_var) {
    this.id = id_var;
    this.name = name_var;
    this.value = value_var;
    this.rpZ1MId = rpZ1MId_var;
  }

  @ApiModelProperty(required = true)
  public Integer id;

  @ApiModelProperty(required = true)
  public String name;

  @ApiModelProperty(required = true)
  public Integer value;

  @ApiModelProperty(required = true)
  public Integer rpZ1MId;
}
