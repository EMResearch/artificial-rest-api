package org.autogenerated.rest.artificial.cs.n5mediumshown.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/** automatically created on 2020-01-14 */
@ApiModel
public class WdL1Q {
  public WdL1Q() {}

  public WdL1Q(Integer id_var, String name_var, Integer value_var, Integer lIM1ZId_var) {
    this.id = id_var;
    this.name = name_var;
    this.value = value_var;
    this.lIM1ZId = lIM1ZId_var;
  }

  @ApiModelProperty(required = true)
  public Integer id;

  @ApiModelProperty(required = true)
  public String name;

  @ApiModelProperty(required = true)
  public Integer value;

  @ApiModelProperty(required = true)
  public Integer lIM1ZId;
}