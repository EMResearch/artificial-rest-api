package org.autogenerated.rest.artificial.cs.n5mediumhide.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/** automatically created on 2020-01-14 */
@ApiModel
public class VIL0S {
  public VIL0S() {}

  public VIL0S(Integer id_var, String name_var, Integer value_var, Integer hErqDId_var) {
    this.id = id_var;
    this.name = name_var;
    this.value = value_var;
    this.hErqDId = hErqDId_var;
  }

  @ApiModelProperty(required = true)
  public Integer id;

  @ApiModelProperty(required = true)
  public String name;

  @ApiModelProperty(required = true)
  public Integer value;

  @ApiModelProperty(required = true)
  public Integer hErqDId;
}
