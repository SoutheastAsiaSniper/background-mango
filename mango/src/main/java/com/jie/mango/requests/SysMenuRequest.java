package com.jie.mango.requests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuRequest {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;
}
