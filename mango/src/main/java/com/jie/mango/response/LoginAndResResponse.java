package com.jie.mango.response;

import com.jie.mango.model.SysUserModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Map;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LoginAndResResponse {

    /**
     *返回码
     */
    @ApiModelProperty(value = "返回码")
    private String rejCode;

    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息")
    private String rejMsg;

    /**
     * token
     */
    @ApiModelProperty(value = "token")
    private Object token;

    /**
     * 用户信息
     */
    @ApiModelProperty(value = "用户信息")
    private SysUserModel userInfo;
}
