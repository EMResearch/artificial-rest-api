package org.autogenerated.rest.artificial.cs.n5densehide.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/** automatically created on 2020-01-14 */
@ApiModel
public class YaDPD {
  public YaDPD() {}

  public YaDPD(Integer id_var, String name_var, Integer value_var) {
    this.id = id_var;
    this.name = name_var;
    this.value = value_var;
  }

  @ApiModelProperty(required = true)
  public Integer id;

  @ApiModelProperty(required = true)
  public String name;

  @ApiModelProperty(required = true)
  public Integer value;
}
