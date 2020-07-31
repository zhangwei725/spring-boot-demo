package com.smart.sw.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;

@Validated
@Data
@ApiModel(value = "用户请求参数")
public class UserRequestParam {
    @ApiModelProperty("必要用户名")
    @Pattern(regexp = "[a-z]\\w{7,16}", message = "")
    private String username;
    @Pattern(regexp = "\\d{11}", message = "")
    @ApiModelProperty("手机号")
    private String phone;
}
