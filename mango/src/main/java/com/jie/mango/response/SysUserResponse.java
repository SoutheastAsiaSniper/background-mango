package com.jie.mango.response;

import com.jie.mango.model.SysUserModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SysUserResponse {
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
     * 用户所有信息
     */
    @ApiModelProperty(value = "查询所有信息列表")
    private List<SysUserModel> findSysUserInfo;
}
